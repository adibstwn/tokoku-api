package com.tokoku.services;

import java.util.Optional;
import com.tokoku.models.entities.UserEmail;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tokoku.helpers.SendEmail;
import com.tokoku.helpers.GenerateTokenEmail;
import com.tokoku.models.dto.CreateUserDto;
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
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private UserEmailRepo userEmailRepo;

    public User saveUser(CreateUserDto dto) {
        String token = GenerateTokenEmail.GenerateRandom();
        User user = modelMapper.map(dto, User.class);
        var userData = userRepo.save(user);
        
        UserEmail email = new UserEmail();
        email.setValid(false);
        email.setEmailUser(dto.getEmail());
        email.setToken(token);
        email.setUser(userData);
        userEmailRepo.save(email);

        SendEmail.SendGmail(dto.getEmail(), token);
        return userData;
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
