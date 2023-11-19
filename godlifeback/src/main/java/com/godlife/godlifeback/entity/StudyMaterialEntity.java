package com.godlife.godlifeback.entity;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.godlife.godlifeback.dto.request.study.PatchMaterialRequestDto;
import com.godlife.godlifeback.dto.request.study.PostMaterialRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "study_material")
@Table(name = "study_material")
public class StudyMaterialEntity {

    @Id @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int studyMaterialNumber;
    private int studyNumber;
    private String studyMaterialName;
    private String studyMaterialImageUrl;
    private String studyMaterialWriter;
    private String studyMaterialDatetime;

    public StudyMaterialEntity( PostMaterialRequestDto dto,int studyNumber, String imageUrl){
        Date now = Date.from(Instant.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String studyMaterialDatetime = simpleDateFormat.format(now);

        this.studyMaterialName = dto.getStudyMaterialName();
        this.studyMaterialImageUrl = imageUrl;
        this.studyMaterialWriter = dto.getStudyMaterialWriter();
        this.studyMaterialDatetime = studyMaterialDatetime;
    }

    public void patchMaterial(PatchMaterialRequestDto dto){
        this.studyMaterialName = dto.getStudyMaterialName();
        this.studyMaterialWriter = dto.getStudyMaterialWriter();
    }
}
