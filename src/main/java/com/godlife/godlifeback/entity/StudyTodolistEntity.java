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
@Table(name="study_todolist")
public class StudyTodolistEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studyListNumber;
    private int studyNumber;
    @NotBlank
    private String studyListContent;
    private boolean studyListCheck;

    public StudyTodolistEntity(PostToDoListRequestDto dto, Integer studyNumber){
        this.studyNumber = studyNumber;
        this.studyListContent =  dto.getStudyListContent();
        this.studyListCheck = dto.getStudyListCheck();
    }

    public void patchTodoList(PatchToDoListRequestDto dto){
        this.studyListContent =  dto.getStudyListContent();
        this.studyListCheck = dto.getStudyListCheck();
    }


}
