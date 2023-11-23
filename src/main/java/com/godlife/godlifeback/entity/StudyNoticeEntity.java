package com.godlife.godlifeback.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.godlife.godlifeback.dto.request.study.PatchNoticeRequestDto;
import com.godlife.godlifeback.dto.request.study.PostNoticeRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="study_notice")
@Table(name="study_notice")
public class StudyNoticeEntity {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int studyNoticeNumber;
    private int studyNumber;
    private String userEmail;

    @NotBlank
    private String studyNoticeContent;

    public StudyNoticeEntity(PostNoticeRequestDto dto, Integer studyNumber, String userEmail){
        this.studyNumber = studyNumber;
        this.userEmail = userEmail;
        this.studyNoticeContent = dto.getNoticeContent();
    }

    public void patchNotice(PatchNoticeRequestDto dto){
        this.studyNoticeContent = dto.getNoticeContent();
    }

}
