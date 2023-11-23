package com.godlife.godlifeback.common.object;

import java.util.ArrayList;
import java.util.List;

import com.godlife.godlifeback.repository.resultSet.StudyToDoListResultSet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ToDoListItem {
    
    private int studyListNumber;
    private int studyNumber;
    private String studyListContent;
    private Boolean studyListCheck; 


    public ToDoListItem(StudyToDoListResultSet resultSet){
        this.studyListNumber = resultSet.getStudyListNumber();
        this.studyNumber = resultSet.getStudyNumber();
        this.studyListContent = resultSet.getStudyListContent();
        this.studyListCheck = resultSet.getStudyListCheck();
        // this.userEmail = resultSet.userEmail();
    }

    public static List<ToDoListItem> getToDoList(List<StudyToDoListResultSet> resultSets){
        List<ToDoListItem> list = new ArrayList<>();

        for(StudyToDoListResultSet resultSet : resultSets){
            ToDoListItem toDoListItem = new ToDoListItem(resultSet);
            list.add(toDoListItem);
        }

        return list;
    }
}
