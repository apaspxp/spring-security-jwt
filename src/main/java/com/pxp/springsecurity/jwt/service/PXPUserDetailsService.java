package com.pxp.springsecurity.jwt.service;

import com.pxp.springsecurity.jwt.entity.UserEntity;
import com.pxp.springsecurity.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PXPUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<UserEntity> user = userRepository.findById(s);
        if(user.isPresent()){
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            Arrays.asList(user.get().getRoles().split(",")).stream().forEach(authority -> {
                authorities.add(new SimpleGrantedAuthority(authority));
            });
            return new User(user.get().getUserName(),user.get().getPassword(), authorities);
        }else {
            throw new UsernameNotFoundException("User does not exist...");
        }
    }
}
