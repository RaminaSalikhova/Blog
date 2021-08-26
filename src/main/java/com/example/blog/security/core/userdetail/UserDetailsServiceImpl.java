package com.example.blog.security.core.userdetail;

import com.example.blog.models.User;
import com.example.blog.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        final User customuser = userRepository.getUserByUsername(username);
        if (customuser == null) {
            throw new UsernameNotFoundException(username);
        }
        UserDetails user = org.springframework.security.core.userdetails.User.withUsername(customuser.getUsername())
                .password(customuser.getPassword())
                .authorities(customuser.getRole()).build();
        return user;
    }

}