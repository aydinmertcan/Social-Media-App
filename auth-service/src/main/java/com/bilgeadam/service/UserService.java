package com.bilgeadam.service;

import com.bilgeadam.dto.request.DoLoginRequestDto;
import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.dto.response.DoLoginResponseDto;
import com.bilgeadam.mapper.UserMapper;
import com.bilgeadam.repository.IUserRepository;
import com.bilgeadam.repository.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService{
    final IUserRepository iUserRepository;
    UserMapper userMapper;

    public UserService(IUserRepository iUserRepository, UserMapper userMapper) {
        this.iUserRepository = iUserRepository;
        this.userMapper = userMapper;
    }

    /**
     * Kullanıcıyı kayıt eder ve kayıtedilen kullanıcının id bilgisi alınarak geri döndürülür.
     * @param
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

    public DoLoginResponseDto findByUsernameAndPassword(DoLoginRequestDto dto){
        Optional<User> user =  iUserRepository.findByUsernameAndPassword(dto.getUsername(), dto.getPassword());
        if(user.isPresent())
            return userMapper.doLoginResponseDto(user.get());
        return new DoLoginResponseDto();
    }

    public boolean isUser(String username,String password){
        Optional<User> user = iUserRepository.findByUsernameAndPassword(username, password);
        if (user.isPresent())
            return true;
        return false;
    }


}
