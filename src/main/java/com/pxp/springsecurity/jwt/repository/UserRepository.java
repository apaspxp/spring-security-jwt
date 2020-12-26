package com.pxp.springsecurity.jwt.repository;

import com.pxp.springsecurity.jwt.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    public Optional<UserEntity> findById(String id);
}
