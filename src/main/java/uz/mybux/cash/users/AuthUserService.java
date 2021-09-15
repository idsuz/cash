package uz.mybux.cash.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthUserService {
    @Autowired
    private AppUserRepository userRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;
    public Optional<AuthUser> loadByUserName(String username){
        return userRepository.findByUserName(username);
    }
//    public AppUser register(UserDto userDto) {
//        AuthUser authUser = new ObjectMapper().convertValue(userDto, AuthUser.class);
//        authUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
//        authUser.setRoles(Collections.singletonList(userRoleRepo.findByRoleNameContaining("USER")));
//        Optional<AuthUser> optUser = userRepository.findByUserNameOrEmail(userDto.getUserName(), userDto.getEmail());
//        if (!optUser.isPresent()) {
//            return userRepository.save(authUser);
//        }
//        throw new RuntimeException("User already exist");
//    }
}
