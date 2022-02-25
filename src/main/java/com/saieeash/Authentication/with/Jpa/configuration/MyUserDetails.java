package com.saieeash.Authentication.with.Jpa.configuration;

import com.saieeash.Authentication.with.Jpa.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MyUserDetails implements UserDetails {

    private String userName;
    private String password;
    private Boolean active;
    private List<GrantedAuthority>  authorities;

    public MyUserDetails(User user){
        userName = user.getUserName();
        password = user.getPassword();
        active = user.getActive();
        authorities = Arrays.stream(user.getRoles().split(","))
                .map((e) -> new SimpleGrantedAuthority(e) )
                .collect(Collectors.toList());
    }


    public MyUserDetails() {
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
