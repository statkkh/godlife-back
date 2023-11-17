package com.godlife.godlifeback.dto.response.study;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.common.object.ToDoListItem;
import com.godlife.godlifeback.dto.response.ResponseCode;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.ResponseMessage;
import com.godlife.godlifeback.entity.StudyToDoListEntity;

import lombok.Getter;

@Getter
public class GetToDoListResponseDto extends ResponseDto{
    
    private List<ToDoListItem> todoList;

    private GetToDoListResponseDto(String code, String message, List<StudyToDoListEntity> studyToDoListEntities){
        super(code, message);
        this.todoList = ToDoListItem.getToDoList(studyToDoListEntities);
    }

    public static ResponseEntity<GetToDoListResponseDto> success(List<StudyToDoListEntity> studyToDoListEntities){
        GetToDoListResponseDto result = new GetToDoListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, studyToDoListEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistToDoList(){
        ResponseDto result = new ResponseDto( ResponseCode.NOT_TODOLIST_EXISTS, ResponseMessage.NOT_TODOLIST_EXISTS);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
