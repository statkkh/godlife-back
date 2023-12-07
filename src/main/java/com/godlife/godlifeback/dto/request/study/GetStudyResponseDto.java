package com.godlife.godlifeback.dto.response.study;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.dto.response.ResponseCode;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.ResponseMessage;
import com.godlife.godlifeback.entity.StudyEntity;

import lombok.Getter;

@Getter
public class GetStudyResponseDto extends ResponseDto{
    
    private int studyNumber;
    private String studyName;
    private String studyStartDate;
    private String studyEndDate;
    private int studyPersonal;
    private String studyCategory1;
    private String studyCategory2;
    private String studyCategory3;
    private boolean studyPublicCheck;
    private String studyPrivatePassword;
    private String studyCoverImageUrl;
    private String studyNextStartDatetime;
    private String StudyNextEndDatetime;
    private int studyTotalDay;
    private String createStudyUserEmail;

    private GetStudyResponseDto(String code, String message,StudyEntity studyEntity){
        super(code, message);
        this.studyNumber = studyEntity.getStudyNumber();
        this.studyName = studyEntity.getStudyName();
        this.studyStartDate = studyEntity.getStudyStartDate();
        this.studyEndDate = studyEntity.getStudyEndDate();
        this.studyPersonal = studyEntity.getStudyPersonal();
        this.studyCategory1 = studyEntity.getStudyCategory1();
        this.studyCategory2 = studyEntity.getStudyCategory2();
        this.studyCategory3 = studyEntity.getStudyCategory3();

        this.studyPrivatePassword = studyEntity.getStudyPrivatePassword();
        this.studyCoverImageUrl = studyEntity.getStudyCoverImageUrl();
        this.studyNextStartDatetime = studyEntity.getStudyNextStartDatetime();
        this.StudyNextEndDatetime = studyEntity.getStudyNextEndDatetime();
        this.studyTotalDay = studyEntity.getStudyTotalDay();
        this.createStudyUserEmail = studyEntity.getCreateStudyUserEmail();
    }

    public static ResponseEntity<GetStudyResponseDto> success(StudyEntity studyEntity) {
        GetStudyResponseDto result = new GetStudyResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS,studyEntity);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }       

    public static ResponseEntity<ResponseDto> notExistUser() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_USER, ResponseMessage.NOT_EXIST_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }    

    public static ResponseEntity<ResponseDto> notExistStudy() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_STUDY, ResponseMessage.NOT_EXIST_STUDY);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }       
}
