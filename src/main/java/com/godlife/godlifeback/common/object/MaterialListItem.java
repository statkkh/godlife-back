package com.godlife.godlifeback.common.object;

import java.util.ArrayList;
import java.util.List;

// import com.godlife.godlifeback.entity.StudyMaterialEntity;
import com.godlife.godlifeback.repository.resultSet.StudyMaterialListResultSet;

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

    public MaterialListItem(StudyMaterialListResultSet resultSet ){
        this.studyMaterialNumber = resultSet.getStudyMaterialNumber();
        this.studyNumber = resultSet.getStudyNumber();
        this.studyMaterialName = resultSet.getStudyMaterialName();
        this.studyMaterialImageUrl = resultSet.getStudyMaterialImageUrl();
        this.studyMaterialWriter = resultSet.getStudyMaterialWriter();
        this.studyMaterialDatetime = resultSet.getStudyMaterialDatetime();
    }

    public static List<MaterialListItem> getMaterialList(List<StudyMaterialListResultSet> resultSets){
        List<MaterialListItem> materialList = new ArrayList<>();
        for(StudyMaterialListResultSet resultSet : resultSets){
            MaterialListItem materialListItem = new MaterialListItem(resultSet);
            materialList.add(materialListItem);
        }
        return materialList;
    }
}
