package com.godlife.godlifeback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.godlife.godlifeback.entity.StudyUserListEntity;

@Repository
public interface StudyUserListRepository extends JpaRepository<StudyUserListEntity,Integer>{
    
}
