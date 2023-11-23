package com.godlife.godlifeback.common.object;

import java.util.ArrayList;
import java.util.List;


import com.godlife.godlifeback.repository.resultSet.StudyNoticeListResultSet;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class NoticeListItem {

    private int studyNoticeNumber;
    private int studyNumber;
    private String studyNoticeContent;
    private String userEmail;


    public NoticeListItem(StudyNoticeListResultSet resultSet){
        this.studyNoticeNumber = resultSet.getStudyNoticeNumber();
        this.studyNumber = resultSet.getStudyNumber();
        this.studyNoticeContent = resultSet.getStudyNoticeContent();
        this.userEmail = resultSet.getUserEmail();
        // this.userEmail = resultSet.userEmail();
    }

    public static List<NoticeListItem> getNoticeList(List<StudyNoticeListResultSet> resultSets){
        List<NoticeListItem> list = new ArrayList<>();
        
        for(StudyNoticeListResultSet resultSet :  resultSets){
            NoticeListItem noticeListItem = new NoticeListItem(resultSet);
            list.add(noticeListItem);
        }
        
        return list;
    }    

    
}
