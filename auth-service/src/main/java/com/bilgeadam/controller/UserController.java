package com.bilgeadam.controller;

import com.bilgeadam.dto.request.DoLoginRequestDto;
import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.dto.response.DoLoginResponseDto;
import com.bilgeadam.repository.entity.User;
import com.bilgeadam.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Return Type
    // returnCode ->
    // errorCode -> 9XXX -> 9001 -> username veya passwordde hata oluştu
    // successCode -> 1XXX -> 1000 ->başarılı
    // Burada validation yapılmalı
    @PostMapping("/dologin")
    public ResponseEntity<DoLoginResponseDto> doLogin(@RequestBody @Valid DoLoginRequestDto dto) {
        return ResponseEntity.ok(userService.findByUsernameAndPassword(dto));
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterRequestDto dto) {
        userService.saveReturnUser(dto);
        // 1. etapta -> Auth içeri kayıt olmalı
//        userService.saveReturnUser(User.builder()
//                .username(dto.getEmail())
//                .password(dto.getPassword())
//            .build());
        // 2. etapta -> User-Service e kayıt için istek atılmalı, dönen cevaba göre işlem devam etmeli
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findall")
    public ResponseEntity<List<User>> findAll () {
        return ResponseEntity.ok(userService.findAll());
    }
}
