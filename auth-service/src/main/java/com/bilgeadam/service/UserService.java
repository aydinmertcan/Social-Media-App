package com.bilgeadam.service;
import com.bilgeadam.config.security.JwtTokenManager;
import com.bilgeadam.dto.request.DoLoginRequestDto;
import com.bilgeadam.dto.request.FindByAutIdDto;
import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.dto.response.DoLoginResponseDto;
import com.bilgeadam.exception.AuthServiceException;
import com.bilgeadam.exception.ErrorType;
import com.bilgeadam.manager.ProfileManager;
import com.bilgeadam.mapper.UserMapper;
import com.bilgeadam.repository.IUserRepository;
import com.bilgeadam.repository.entity.User;
import com.bilgeadam.utility.JwtEncodeDecode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    IUserRepository iUserRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
    ProfileManager profileManager;

    @Autowired
    JwtTokenManager jwtTokenManager;

    @Autowired
    JwtEncodeDecode jwtEncodeDecode;

    /**
     * Kullanıcıyı kayıt eder ve kayıtedilen kullanıcının id bilgisi alınarak geri döndürülür.
     * @param dto
     * @return
     */
    public User saveReturnUser(RegisterRequestDto dto){
        User user = userMapper.toUser(dto);
        iUserRepository.save(user);
        return user;
    }

    public void save(User user){
        iUserRepository.save(user);
    }

    public void update(User user){
        iUserRepository.save(user);
    }

    public void delete(User user){
        iUserRepository.delete(user);
    }

    public List<User> findAll(){
        return iUserRepository.findAll();
    }

    @Cacheable(value = "merhaba_cache")
    public String merhaba(String mesaj){
        try {
            Thread.sleep(3500);
        }catch (Exception e){
        }
        return mesaj;
    }

    public boolean isUser(String username,String password){
        Optional<User> user = iUserRepository.findByUsernameAndPassword(username, password);
        if (user.isPresent())
            return true;
        return false;
    }
    /*
        public  Optional<User> getUser(DoLoginRequestDto dto){
            return iUserRepository.findByUsernameAndPassword(dto.getUsername(), dto.getPassword());
        }
    */
    public DoLoginResponseDto getProfile(DoLoginRequestDto dto) {
        /**
         * Kullancı adı ve şifre den auth Db de ki kullanıcıyı arar.
         */
        Optional<User> user = iUserRepository.findByUsernameAndPassword(dto.getUsername(), dto.getPassword());
        if (user.isPresent()) {
            /**
             * Eğer kullanıvı var ise, ProfileController a giderek kişiye ait profil id sini getirecek.             *
             */
            long authid = user.get().getId();
            String profileid = profileManager.findByAuthId(FindByAutIdDto.builder().authid(authid).build()).getBody();

            /**
             * Eğer dönen değer, "" ise farklı dolu ise farklı işlem yapılacak.
             */
            if (profileid.equals("")) {
                throw new AuthServiceException("Profil Id bilgisi alınamadı", ErrorType.AUTH_KULLANICI_SIFRE_HATASI);
            } else {
                return DoLoginResponseDto.builder().profileid(profileid).error(200).build();
            }
        }
        throw new AuthServiceException("Oturum Bilgileri alanamadı", ErrorType.AUTH_KULLANICI_SIFRE_HATASI);
    }


}
