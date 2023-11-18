package com.godlife.godlifeback.common.object;

import java.util.ArrayList;
import java.util.List;


import com.godlife.godlifeback.entity.StudyNoticeEntity;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class NoticeListItem {

    private int studyNoticeNumber;
    private int studyNumber;
    private String studyNoticeContent;    

    public NoticeListItem(StudyNoticeEntity studyNoticeEntity){
        this.studyNoticeNumber = studyNoticeEntity.getStudyNoticeNumber();
        this.studyNumber = studyNoticeEntity.getStudyNumber();
        this.studyNoticeContent = studyNoticeEntity.getStudyNoticeContent();
    }

    public static List<NoticeListItem> getNoticeList(List<StudyNoticeEntity> studyNoticeEntites){
        List<NoticeListItem> noticeList = new ArrayList<>();
        
        for(StudyNoticeEntity studyNoticeEntity :  studyNoticeEntites){
            NoticeListItem noticeListItem = new NoticeListItem(studyNoticeEntity);
            noticeList.add(noticeListItem);
        }
        return noticeList;
    }    

    
}
