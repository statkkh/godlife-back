package com.godlife.godlifeback.dto.response.study;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.common.object.StudyUserListItem;
import com.godlife.godlifeback.dto.response.ResponseCode;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.ResponseMessage;
import com.godlife.godlifeback.entity.StudyUserListEntity;

import lombok.Getter;

@Getter
public class GetUserListResponseDto extends ResponseDto{

    private List<StudyUserListItem> studyUserList;
    
    private GetUserListResponseDto(String code, String message, List<StudyUserListEntity> studyUserListEntities){
        super(code, message);
        this.studyUserList = StudyUserListItem.getUserList(studyUserListEntities);
    }

    public static  ResponseEntity<GetUserListResponseDto> success( List<StudyUserListEntity> studyUserListEntities){
        GetUserListResponseDto result = new GetUserListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, studyUserListEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static  ResponseEntity<ResponseDto> notUserList(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_USER_LIST, ResponseMessage.NOT_EXIST_USER_LIST);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }    
}
