package com.godlife.godlifeback.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.godlife.godlifeback.dto.request.study.PatchToDoListRequestDto;
import com.godlife.godlifeback.dto.request.study.PostToDoListRequestDto;

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
    private int studyToDoListNumber;
    private int studyNumber;
    
    @NotBlank
    private String studyNoticeContent;
    private boolean studyListCheck;

    public StudyToDoListEntity(PostToDoListRequestDto dto, Integer studyNumber){
        this.studyNumber = studyNumber;
        this.studyNoticeContent =  dto.getStudyToDolistContent();
    }

    public void patchNoticeContent(PatchToDoListRequestDto dto){
        this.studyNoticeContent =  dto.getStudyToDolistContent();
    }
}
