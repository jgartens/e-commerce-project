package com.tts.ecommerce.repositories;

import com.tts.ecommerce.models.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface UserRepository extends CrudRepository<User, Long> {
        User findByUsername(String username);
    }
