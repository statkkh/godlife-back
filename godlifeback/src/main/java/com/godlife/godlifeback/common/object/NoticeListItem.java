package com.godlife.godlifeback.common.object;

import java.util.ArrayList;
import java.util.List;

import com.godlife.godlifeback.entity.StudyNoticeEntity;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class NoticeListItem {
    private int noticeNumber;
    private int studyNumber;
    private String noticeContent;    

    public NoticeListItem(StudyNoticeEntity studyNoticeEntity){
        this.noticeNumber = studyNoticeEntity.getNoticeNumber();
        this.studyNumber = studyNoticeEntity.getStudyNumber();
        this.noticeContent = studyNoticeEntity.getNoticeContent();
    }

    public static List<NoticeListItem> getNoticeList(List<StudyNoticeEntity> studyNoticeEntites){
        List<NoticeListItem> list = new ArrayList<>();
        for(StudyNoticeEntity studyNoticeEntity :  studyNoticeEntites){
            NoticeListItem noticeListItem = new NoticeListItem(studyNoticeEntity);
            list.add(noticeListItem);
        }
        return list;
    }    

    
}
