package com.pxp.springsecurity.jwt.clr;

import com.pxp.springsecurity.jwt.entity.UserEntity;
import com.pxp.springsecurity.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

//@Component
public class UserCLR implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        UserEntity user1 = new UserEntity();
        user1.setUserName("john");
        user1.setPassword("john");
        user1.setRoles("USER");

        UserEntity user2 = new UserEntity();
        user2.setUserName("linda");
        user2.setPassword("linda");
        user2.setRoles("USER");

        try {
            userRepository.save(user1);
            userRepository.save(user2);
        }catch (Exception e) {
            throw e;
        }
    }

}
