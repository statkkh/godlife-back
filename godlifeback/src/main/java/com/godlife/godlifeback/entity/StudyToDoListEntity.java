package com.godlife.godlifeback.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="study_todolist")
@Table(name = "study_todolist")
public class StudyToDoListEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studyListNumber;
    private int studyNumber;
    
    @NotBlank
    private String studyNoticeContent;
    private boolean studyListCheck;

    // public void patchNoticeContent()
}
