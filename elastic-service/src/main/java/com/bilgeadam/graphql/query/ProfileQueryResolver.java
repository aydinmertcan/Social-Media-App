package com.bilgeadam.graphql.query;

import com.bilgeadam.repository.IProfileRepository;
import com.bilgeadam.repository.entity.Profile;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

// Aldığı parametreler ile sorgulama yapmak için tasarlanmıştır. Burada sorgu işlemleri gerçekleştirilir.
@Component
@RequiredArgsConstructor
public class ProfileQueryResolver implements GraphQLMutationResolver {

    private final IProfileRepository repository;

    public List<Profile> findByFirstnameLike(String firstname) {
        return repository.findByFirstnameLike(firstname);
    }

    public Iterable<Profile> findAll () {
        return repository.findAll();
    }
}
