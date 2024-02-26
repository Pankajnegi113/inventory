package com.inventory.inventory.config;

import com.inventory.inventory.model.UserInfo;
import com.inventory.inventory.repository.UserInfoRepository;
import org.springframework.security.core.userdetails.UserDetailsService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserInfoRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = repository.findByName(username);
        return userInfo.map(UserInfoDetail::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

    }
}
