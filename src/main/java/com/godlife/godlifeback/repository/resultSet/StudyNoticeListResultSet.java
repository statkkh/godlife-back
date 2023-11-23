package com.godlife.godlifeback.repository.resultSet;

public interface StudyNoticeListResultSet {
    int getStudyNoticeNumber();
    int getStudyNumber();
    String getStudyNoticeContent();
    String getUserEmail();

} 

    // public void patchNotice(PatchNoticeRequestDto dto){
    //     this.studyNoticeContent = dto.getNoticeContent();
    // }