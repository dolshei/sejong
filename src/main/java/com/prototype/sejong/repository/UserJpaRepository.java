package com.prototype.sejong.repository;

import com.prototype.sejong.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserJpaRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name);

    User findByEmail(String email);
}
