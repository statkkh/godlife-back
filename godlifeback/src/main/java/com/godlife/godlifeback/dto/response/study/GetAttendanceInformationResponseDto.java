package com.godlife.godlifeback.dto.response.study;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.common.object.UserAttendanceInformationListItem;
import com.godlife.godlifeback.dto.response.ResponseCode;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.ResponseMessage;
import com.godlife.godlifeback.entity.UserAttendanceInformationEntity;

import lombok.Getter;

@Getter
public class GetAttendanceInformationResponseDto  extends ResponseDto{
    
    private List<UserAttendanceInformationListItem> attendanceList;

    // private GetAttendanceInformationResponseDto(String code, String message, List<UserAttendanceInformationEntity> userAttendanceInformationEntities){
    //     super(code, message);
    //     this.attendanceList = UserAttendanceInformationListItem.get
    // }
    private GetAttendanceInformationResponseDto(String code ,String message, List<UserAttendanceInformationEntity> userAttendanceInformationEntities){
        super(code, message);
        this.attendanceList = UserAttendanceInformationListItem.getUserAttendanceInformationList(userAttendanceInformationEntities);
    }
    
    public static ResponseEntity<GetAttendanceInformationResponseDto> success(List<UserAttendanceInformationEntity> userAttendanceInformationEntities){
        GetAttendanceInformationResponseDto result = new GetAttendanceInformationResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, userAttendanceInformationEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
        
    }
}
