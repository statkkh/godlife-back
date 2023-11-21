package com.godlife.godlifeback.repository.resultSet;

public interface StudyCommentListResultSet {
    // int getStudyNumber();
    // String getUserEmail();
    String getUserGrade();
    String getUserProfileImage();
    String getNickname();

    int studyMaterialCommentNumber();
    int studyMaterialNumber();
    
    String getWriteDatetime();
    String getContent();
} 
