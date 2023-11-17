package com.godlife.godlifeback.common.object;

import java.util.ArrayList;
import java.util.List;

import com.godlife.godlifeback.entity.StudyToDoListEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ToDoListItem {
    
    private int studyListNumber;
    private int studyNumber;
    private String studyListContent;
    private Boolean studyListCheck;  

    public ToDoListItem(StudyToDoListEntity studyToDoListEntity){
        this.studyListNumber = studyToDoListEntity.getStudyNumber();
        this.studyNumber = studyToDoListEntity.getStudyNumber();
        this.studyListContent = studyToDoListEntity.getStudyNoticeContent();

    }

    public static List<ToDoListItem> getToDoList(List<StudyToDoListEntity> studyToDoListEntities){
        List<ToDoListItem> todoList = new ArrayList<>();
        for(StudyToDoListEntity studyToDoListEntity : studyToDoListEntities){
            ToDoListItem toDoListItem = new ToDoListItem(studyToDoListEntity);
            todoList.add(toDoListItem);
        }
        return todoList;
    }
}
