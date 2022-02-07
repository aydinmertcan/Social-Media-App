package com.bilgeadam.controller;
import static com.bilgeadam.constant.RestApiUrls.*;

import com.bilgeadam.constant.RestApiUrls;
import com.bilgeadam.dto.request.ProfileRequestDto;
import com.bilgeadam.repository.entity.Profile;
import com.bilgeadam.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(VERSION+PROFILE)
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService service;

    @PostMapping(SAVE)
    public ResponseEntity<String> save(@RequestBody @Valid ProfileRequestDto dto) {
        service.save(dto);
        return ResponseEntity.ok("Ok.");
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<Profile>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }



}
