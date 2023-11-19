package com.godlife.godlifeback.common.object;

import java.util.ArrayList;
import java.util.List;

import com.godlife.godlifeback.entity.StudyMaterialEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaterialListItem {
    
    private int studyMaterialNumber;
    private int studyNumber;
    private String studyMaterialName;
    private String studyMaterialImageUrl;
    private String studyMaterialWriter;
    private String studyMaterialDatetime;

    public MaterialListItem(StudyMaterialEntity studyMaterialEntity ){
        this.studyMaterialNumber = studyMaterialEntity.getStudyMaterialNumber();
        this.studyNumber = studyMaterialEntity.getStudyNumber();
        this.studyMaterialName = studyMaterialEntity.getStudyMaterialName();
        this.studyMaterialImageUrl = studyMaterialEntity.getStudyMaterialImageUrl();
        this.studyMaterialWriter = studyMaterialEntity.getStudyMaterialWriter();
        this.studyMaterialDatetime = studyMaterialEntity.getStudyMaterialDatetime();
    }

    public static List<MaterialListItem> getMaterialList(List<StudyMaterialEntity> studyMaterialEntities){
        List<MaterialListItem> materailList = new ArrayList<>();
        for(StudyMaterialEntity studyMaterialEntity : studyMaterialEntities){
            MaterialListItem materialListItem = new MaterialListItem(studyMaterialEntity);
            materailList.add(materialListItem);
        }
        return materailList;
    }
}
