package com.godlife.godlifeback.common.object;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import com.godlife.godlifeback.repository.resultSet.StudyToDoListResultSet;

@Getter
@Setter
public class StudyTodoListItem {
    private int studyListNumber;
    private int studyNumber;
    private String studyListContent;
    private Boolean studyListCheck;

    public StudyTodoListItem(StudyToDoListResultSet resultSet){
        this.studyListNumber = resultSet.getStudyListNumber();
        this.studyNumber = resultSet.getStudyNumber();
        this.studyListContent = resultSet.getStudyListContent();
        this.studyListCheck = resultSet.getStudyListCheck();
    }

    public static List<StudyTodoListItem> getToDoList(List<StudyToDoListResultSet> resultSets){
        List<StudyTodoListItem> list = new ArrayList<>();

        for(StudyToDoListResultSet resultSet :  resultSets){
            StudyTodoListItem studyToDoListItem = new StudyTodoListItem(resultSet);
            list.add(studyToDoListItem);
        }

        return list;
    }
}
