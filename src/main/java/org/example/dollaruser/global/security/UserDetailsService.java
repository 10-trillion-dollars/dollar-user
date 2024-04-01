package org.example.dollaruser.global.security;

import lombok.RequiredArgsConstructor;
import org.example.dollaruser.user.entity.User;
import org.example.dollaruser.user.entity.UserRoleEnum;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsService {


    public UserDetails getUser(Long userId, String username, String email, UserRoleEnum role)
        throws UsernameNotFoundException {
        User user = new User(userId, username, email, role);
        return new UserDetailsImpl(user);
    }
}
