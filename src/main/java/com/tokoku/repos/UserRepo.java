package com.tokoku.repos;

import org.springframework.data.repository.CrudRepository;

import com.tokoku.models.entities.User;

public interface UserRepo extends CrudRepository<User, Long> {
    // User findByUserName(String username);
}
