package com.godlife.godlifeback.repository.resultSet;

public interface StudyCommentListResultSet {
    // int getStudyNumber();
    int studyMaterialCommentNumber();
    int studyMaterialNumber();

    String getUserGrade();
    String getUserProfileImage();
    String getNickname();
    
    String getUserEmail();
    String getContent();
    String getWriteDatetime();
} 
