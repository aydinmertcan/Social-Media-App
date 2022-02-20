package com.bilgeadam.graphql.mutation;

import com.bilgeadam.graphql.model.ProfileInput;
import com.bilgeadam.repository.IProfileRepository;
import com.bilgeadam.repository.entity.Profile;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

// İstenilen değerler ile kayıt, güncelleme ve silme işlemlerinde kullanılmak üzere tasarlanmıştır.
@Component
@RequiredArgsConstructor
public class ProfileMutationResolver implements GraphQLMutationResolver {

    private final IProfileRepository repository;

    public void createProfileElastic(ProfileInput profileInput) {
        repository.save(Profile.builder()
                        .profileid(profileInput.getProfileid())
                        .firstname(profileInput.getFirstname())
                        .lastname(profileInput.getLastname())
                        .email(profileInput.getEmail())
                        .city(profileInput.getCity())
                        .country(profileInput.getCountry())
                .build());

    }
}
