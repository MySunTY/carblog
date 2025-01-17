package com.example.CarBlog_2.User;

import com.example.CarBlog_2.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserDTO create(String username, String password , String email){
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(username);
        userDTO.setEmail(email);
        userDTO.setPassword(passwordEncoder.encode(password));
        this.userRepository.save(userDTO);
        return userDTO;
    }

    public UserDTO getUser(String username){
        Optional<UserDTO> user = this.userRepository.findByUsername(username);

        if(user.isPresent()){
            return user.get();
        }else{
            throw new DataNotFoundException("User Not Found");
        }
    }
}
