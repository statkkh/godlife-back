package com.godlife.godlifeback.common.object;

import java.util.ArrayList;
import java.util.List;


import com.godlife.godlifeback.entity.StudyNoticeListEntity;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class NoticeListItem {

    private int studyNoticeNumber;
    private int studyNumber;
    private String studyNoticeContent;    

    public NoticeListItem(StudyNoticeListEntity studyNoticeEntity){
        this.studyNoticeNumber = studyNoticeEntity.getStudyNoticeNumber();
        this.studyNumber = studyNoticeEntity.getStudyNumber();
        this.studyNoticeContent = studyNoticeEntity.getStudyNoticeContent();
    }

    public static List<NoticeListItem> getNoticeList(List<StudyNoticeListEntity> studyNoticeEntites){
        List<NoticeListItem> list = new ArrayList<>();
        for(StudyNoticeListEntity studyNoticeEntity :  studyNoticeEntites){
            NoticeListItem noticeListItem = new NoticeListItem(studyNoticeEntity);
            list.add(noticeListItem);
        }
        return list;
    }    

    
}
