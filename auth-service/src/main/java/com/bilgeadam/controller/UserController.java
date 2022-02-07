package com.bilgeadam.controller;

import static com.bilgeadam.constant.RestApiUrls.*;
import com.bilgeadam.dto.request.DoLoginRequestDto;
import com.bilgeadam.dto.request.ProfileRequestDto;
import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.dto.response.DoLoginResponseDto;
import com.bilgeadam.manager.ProfileManager;
import com.bilgeadam.repository.entity.User;
import com.bilgeadam.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(VERSION+USER)
public class UserController {

    UserService userService;
    ProfileManager profileManager;

    public UserController(UserService userService, ProfileManager profileManager) {
        this.userService = userService;
        this.profileManager = profileManager;
    }

    //Return Type
    // returnCode ->
    // errorCode -> 9XXX -> 9001 -> username veya passwordde hata oluştu
    // successCode -> 1XXX -> 1000 ->başarılı
    // Burada validation yapılmalı
    @PostMapping(DOLOGIN)
    @Operation(summary = "Kullanıcı girişi için kullanılan method")
    public ResponseEntity<DoLoginResponseDto> doLogin(@RequestBody @Valid DoLoginRequestDto dto) {
        return ResponseEntity.ok(userService.findByUsernameAndPassword(dto));
    }

    @PostMapping(REGISTER)
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterRequestDto dto) {
        User user = userService.saveReturnUser(dto);
        profileManager.save(ProfileRequestDto.builder()
                .authid(user.getId())
                .email(dto.getEmail())
                .firstname(dto.getName())
                .lastname(dto.getLastname())
                .country(dto.getCountry())
                .city(dto.getCity())
                .gender(dto.getGender())
                .build());
        return ResponseEntity.ok().build();
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<User>> findAll () {
        return ResponseEntity.ok(userService.findAll());
    }
}
