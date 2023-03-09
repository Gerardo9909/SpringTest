package com.exam.springtest.repository;

import com.exam.springtest.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, String> {

    List<User> findAll();

    User save(User user);

    Optional<User> findUserByLogin(String login);
}
