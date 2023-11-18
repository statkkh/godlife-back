package com.godlife.godlifeback.dto.response.study;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.common.object.MaterialListItem;
import com.godlife.godlifeback.dto.response.ResponseCode;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.ResponseMessage;
import com.godlife.godlifeback.entity.StudyMaterialEntity;

import lombok.Getter;

@Getter
public class GetMaterialResponseDto extends ResponseDto{
    
    // private int studyMaterialNumber;
    // private int studyNumber;
    // private String studyMaterialName;
    // private String studyMaterialImageUrl;
    // private String studyMaterialWriter;
    // private String studyMaterialDatetime;

    private List<MaterialListItem> materialList;

    private GetMaterialResponseDto(String code, String message, List<StudyMaterialEntity> studyMaterialEntities){
        super(code, message);   
        this.materialList = MaterialListItem.getMaterialList(studyMaterialEntities);
    }

    public static ResponseEntity<GetMaterialResponseDto> success(List<StudyMaterialEntity> studyMaterialEntities){
        GetMaterialResponseDto result = new GetMaterialResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, studyMaterialEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    public static ResponseEntity<ResponseDto> notExistMaterial(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_STUDY_MATERIAL, ResponseMessage.NOT_EXIST_STUDY_MATERIAL);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result); 
    }



}
