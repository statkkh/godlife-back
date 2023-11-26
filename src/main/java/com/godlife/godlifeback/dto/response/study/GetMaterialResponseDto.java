package com.godlife.godlifeback.dto.response.study;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.common.object.MaterialListItem;
import com.godlife.godlifeback.dto.response.ResponseCode;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.ResponseMessage;
import com.godlife.godlifeback.entity.StudyMaterialEntity;
import com.godlife.godlifeback.repository.resultSet.StudyMaterialListResultSet;

import lombok.Getter;

@Getter
public class GetMaterialResponseDto extends ResponseDto{
    
    private List<MaterialListItem> materialList;

    private GetMaterialResponseDto(String code, String message, List<StudyMaterialListResultSet> resultSets){
        super(code, message);   
        this.materialList = MaterialListItem.getMaterialList(resultSets);
    }

    public static ResponseEntity<GetMaterialResponseDto> success(List<StudyMaterialListResultSet> resultSets){
        GetMaterialResponseDto result = new GetMaterialResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, resultSets);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    public static ResponseEntity<ResponseDto> notExistMaterial(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_STUDY_MATERIAL, ResponseMessage.NOT_EXIST_STUDY_MATERIAL);
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
