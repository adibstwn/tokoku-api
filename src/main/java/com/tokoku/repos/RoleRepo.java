package com.tokoku.repos;

import org.springframework.data.repository.CrudRepository;

import com.tokoku.models.entities.UserRole;

public interface RoleRepo extends CrudRepository<UserRole, Long> {
    // UserRole findByName(String name);
}