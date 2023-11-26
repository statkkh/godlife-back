package com.godlife.godlifeback.repository.resultSet;

public interface StudyCommentListResultSet {
    int getStudyMaterialCommentNumber();
    int getStudyMaterialNumber();
    
    String getUserGrade();
    String getUserProfileImage();
    String getNickname();
    
    String getWriteDatetime();
    String getContent();
} 
