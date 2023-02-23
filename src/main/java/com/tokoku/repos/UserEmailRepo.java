package com.tokoku.repos;

import org.springframework.data.repository.CrudRepository;

import com.tokoku.models.entities.UserEmail;

public interface UserEmailRepo extends CrudRepository<UserEmail, Long> {

}
