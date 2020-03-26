package com.learning.spring.githubapiwrapper.repo;

import com.learning.spring.githubapiwrapper.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
