package com.example.CarBlog_2.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDTO, Long> {
    Optional<UserDTO> findByUsername(String username);

}
