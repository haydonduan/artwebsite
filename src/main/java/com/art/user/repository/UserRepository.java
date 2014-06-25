package com.art.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.art.user.domain.User;

public interface UserRepository extends JpaRepository<User, Long> , UserRepositoryCutstom{
}
