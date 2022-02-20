package com.bilgeadam.rabbitmq.consumer;

import com.bilgeadam.mapper.ProfileMapper;
import com.bilgeadam.rabbitmq.model.ProfileNotification;
import com.bilgeadam.repository.IProfileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProfileConsumer {
    private final IProfileRepository iProfileRepository;
    private final ProfileMapper profileMapper;

    public void handleProfileSave(ProfileNotification profileNotification) {
        iProfileRepository.save(profileMapper.toProfile(profileNotification));
        log.info("Profile save: {}", profileNotification.toString());

    }
}
