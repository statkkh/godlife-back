package com.godlife.godlifeback.common.object;

import java.util.ArrayList;
import java.util.List;

import com.godlife.godlifeback.entity.StudyMaterialCommentEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaterialCommentListItem {
    
    private int studyMaterialComentNumber;
    private int studyMaterialNumber;
    private String userEmail;
    private String studyMaterialComment;
    private String studyMaterialCommentDatetime;

    public MaterialCommentListItem(StudyMaterialCommentEntity studyMaterialCommentEntity){
        this.studyMaterialComentNumber = studyMaterialCommentEntity.getStudyMaterialCommentNumber();
        this.studyMaterialNumber = studyMaterialCommentEntity.getStudyMaterialNumber();
        this.userEmail = studyMaterialCommentEntity.getUserEmail();
        this.studyMaterialComment = studyMaterialCommentEntity.getStudyMaterialComment();
        this.studyMaterialCommentDatetime = studyMaterialCommentEntity.getStudyMaterialCommentDatetime();
    }

    public static List<MaterialCommentListItem> getMaterialCommentList(List<StudyMaterialCommentEntity> studyMaterialCommentEntities){
        List<MaterialCommentListItem> materialCommentList = new ArrayList<>();

        for(StudyMaterialCommentEntity studyMaterialCommentEntity : studyMaterialCommentEntities){
            MaterialCommentListItem materialCommentListItem = new MaterialCommentListItem(studyMaterialCommentEntity);
            materialCommentList.add(materialCommentListItem);
        }

        return materialCommentList;
    } 

}
