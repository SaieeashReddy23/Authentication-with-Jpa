package com.saieeash.Authentication.with.Jpa.service;

import com.saieeash.Authentication.with.Jpa.configuration.MyUserDetails;
import com.saieeash.Authentication.with.Jpa.entity.User;
import com.saieeash.Authentication.with.Jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = repo.findByUserName(username);

        user.orElseThrow(() -> new UsernameNotFoundException("Not fount " + username));

        return user.map(MyUserDetails::new).get();
    }
}
