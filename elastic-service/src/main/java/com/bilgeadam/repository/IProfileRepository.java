package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Profile;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProfileRepository extends ElasticsearchRepository<Profile, String> {

    List<Profile> findByFirstnameLike(String firstName);
}
