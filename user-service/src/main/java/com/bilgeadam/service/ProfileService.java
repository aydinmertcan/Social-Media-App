package com.bilgeadam.service;

import com.bilgeadam.dto.request.ProfileRequestDto;
import com.bilgeadam.mapper.ProfileMapper;
import com.bilgeadam.repository.IProfileRepository;
import com.bilgeadam.repository.entity.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final IProfileRepository iProfileRepository;
    private final ProfileMapper mapper;

    public void save(ProfileRequestDto dto){
        Profile profile = mapper.toProfile(dto);
        iProfileRepository.save(profile);
    }
    public void update(Profile profile){
        iProfileRepository.save(profile);
    }
    public void delete(Profile profile){
        iProfileRepository.delete(profile);
    }
    public List<Profile> findAll(){
        return iProfileRepository.findAll();
    }
    public Optional<Profile> findByAuthId(long authId) {
        return iProfileRepository.findByAuthid(authId);
    }
    public Optional<Profile> findById(String id) {
        return iProfileRepository.findById(id);
    }





}
