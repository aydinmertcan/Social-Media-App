package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    /**
     * Kullanıcının oturum açabilmesi için email ve şifre bilgisi alınır.
     * Kayıtlı bilgi var ise optional olarak cevap döner.
     * @param username Email Info
     * @param password Pw Info
     * @return
     */
    Optional<User> findByUsernameAndPassword(String username, String password);

    /**
     * Durumlarına göre:
     * 0 -> pasif kullanıcı
     * 1 -> aktif kullanıcı
     * 2 -> engellenmiş kullanıcı, Hesabı askıya alınmış
     * 3 -> V.S
     * @param status
     * @return
     */
    List<User> findByStatus(int status);
}
