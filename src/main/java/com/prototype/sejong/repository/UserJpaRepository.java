package com.prototype.sejong.repository;

import com.prototype.sejong.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {
    User findByName(String name);

    User findByEmail(String email);
}
