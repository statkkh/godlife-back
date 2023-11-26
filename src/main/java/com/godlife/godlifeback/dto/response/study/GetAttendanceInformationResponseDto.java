package com.godlife.godlifeback.dto.response.study;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.common.object.UserAttendanceInformationListItem;
import com.godlife.godlifeback.dto.response.ResponseCode;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.ResponseMessage;
import com.godlife.godlifeback.repository.resultSet.UserAttendanceInformationResultset;

import lombok.Getter;

@Getter
public class GetAttendanceInformationResponseDto  extends ResponseDto{
    
    private List<UserAttendanceInformationListItem> userAttendanceInformationList;


    private GetAttendanceInformationResponseDto(String code ,String message, List<UserAttendanceInformationResultset> resultsets){
        super(code, message);
        this.userAttendanceInformationList = UserAttendanceInformationListItem.getUserAttendanceInformationList(resultsets);
    }
    
    public static ResponseEntity<GetAttendanceInformationResponseDto> success(List<UserAttendanceInformationResultset> resultsets){
        GetAttendanceInformationResponseDto result = new GetAttendanceInformationResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, resultsets);
        return ResponseEntity.status(HttpStatus.OK).body(result);
        
    }

    public static ResponseEntity<ResponseDto> notExistUserAttendanceInformation(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_USER_ATTENDANCE_INFORMATION, ResponseMessage.NOT_EXIST_USER_ATTENDANCE_INFORMATION);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }    


    public static ResponseEntity<ResponseDto> notExistUser(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_USER, ResponseMessage.NOT_EXIST_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistStudy(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_STUDY_ROOM, ResponseMessage.NOT_EXIST_STUDY_ROOM);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
