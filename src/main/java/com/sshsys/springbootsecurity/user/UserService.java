package com.sshsys.springbootsecurity.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    /**
     * 유저등록
     * 
     * @param username 
     * @param password
     * @return 유저 권한을 가지고 있는 유저
     */
    public User signUp(String username, String password) {
        if (userRepository.findByUsername(username) != null) {
            throw new AlreadyRegisteredUserException();
        }

        User user = new User(
                username,
                passwordEncoder.encode(password),
                "ROLE_USER"
        );
        return userRepository.save(user);
    }

    /**
     * 관리자 등록
     *
     * @param username
     * @param password
     * @return 관리자 권한을 가지고 있는 유저
     */
    public User signUpAdmin(String username, String password) {
        if (userRepository.findByUsername(username) != null) {
            throw new AlreadyRegisteredUserException();
        }

        User user = new User(
                username,
                passwordEncoder.encode(password),
                "ROLE_ADMIN"
        );
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
