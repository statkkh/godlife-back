package com.godlife.godlifeback.dto.response.study;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.common.object.StudyToDoListItem;
import com.godlife.godlifeback.dto.response.ResponseCode;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.ResponseMessage;
import com.godlife.godlifeback.repository.resultSet.StudyToDoListResultSet;

import lombok.Getter;

@Getter
public class GetToDoListResponseDto extends ResponseDto{
    
    private List<StudyToDoListItem> todoList;

    private GetToDoListResponseDto(String code, String message, List<StudyToDoListResultSet> resultSets){
        super(code, message);
        this.todoList = StudyToDoListItem.getToDoList(resultSets);
    }

    public static ResponseEntity<GetToDoListResponseDto> success(List<StudyToDoListResultSet> resultSets){
        GetToDoListResponseDto result = new GetToDoListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, resultSets);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistsUser(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_USER, ResponseMessage.NOT_EXIST_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
    
    public static ResponseEntity<ResponseDto> notExistToDoList(){
        ResponseDto result = new ResponseDto( ResponseCode.NOT_EXIST_TODOLIST, ResponseMessage.NOT_EXIST_TODOLIST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistStudy(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_STUDY_ROOM, ResponseMessage.NOT_EXIST_STUDY_ROOM);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    public static ResponseEntity<ResponseDto> noPermission(){
        ResponseDto result = new ResponseDto(ResponseCode.NO_PERMISSION, ResponseMessage.NO_PERMISSION);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }    
}
