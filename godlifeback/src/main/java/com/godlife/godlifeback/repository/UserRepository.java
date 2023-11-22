package com.godlife.godlifeback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.godlife.godlifeback.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String>{

    boolean existsByUserEmail(String userEmail);

    UserEntity findByUserEmail(String userEmail);
}
