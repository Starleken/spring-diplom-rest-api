package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.entity.UserDetailsImpl;
import com.example.DiplomRestApi.exception.EntityNotFoundException;
import com.example.DiplomRestApi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var found = userRepository.findByLogin(username)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        return new UserDetailsImpl(found);
    }
}
