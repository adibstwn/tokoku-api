package com.tokoku.services;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import com.tokoku.models.entities.UserEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokoku.helpers.SendEmail;
import com.tokoku.helpers.GenerateTokenEmail;
import com.tokoku.models.entities.User;
import com.tokoku.models.entities.UserRole;
import com.tokoku.repos.RoleRepo;
import com.tokoku.repos.UserRepo;
import com.tokoku.repos.UserEmailRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl {

    @Autowired
    private UserRepo userRepo;
    private RoleRepo roleRepo;
    private UserEmailRepo userEmailRepo;

    public User saveUser(User user) {
        var token = GenerateTokenEmail.GenerateRandom();

        var email = new UserEmail();
        email.setEmailStatus(false);
        email.setEmailUser(user.getEmail().getEmailUser());
        email.setToken(token);
        userEmailRepo.save(email);

        SendEmail.SendGmail(user.getName(), token);
        return userRepo.save(user);
    }

    public UserRole saveRole(UserRole role) {
        return roleRepo.save(role);
    }

    public Optional<User> getUser(Long username) {
        return userRepo.findById(username);
    }

    public Iterable<User> getUsers() {
        return userRepo.findAll();
    }
}
