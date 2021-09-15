package uz.mybux.cash.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AppUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) {
        // it will be called at access token generation time
        Optional<AuthUser> optUser = userRepository.findByUserName(userName);
        if (optUser.isPresent()) {
            AuthUser user = optUser.get();

            return new User(user.getUserName(), user.getPassword(), Collections.singleton(new SimpleGrantedAuthority(user.getRoles())));
        }
        throw new RuntimeException("user not exist");
    }
}
