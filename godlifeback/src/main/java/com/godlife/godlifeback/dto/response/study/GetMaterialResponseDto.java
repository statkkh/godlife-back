package com.godlife.godlifeback.dto.response.study;


import com.godlife.godlifeback.dto.response.ResponseDto;

import lombok.Getter;

@Getter
public class GetMaterialResponseDto extends ResponseDto{
    
    private int studyMaterialNumber;
    private int studyNumber;
    private String studyMaterialName;
    private String studyMaterialImageUrl;
    private String studyMaterialWriter;
    private String studyMaterialDatetime;

    private GetMaterialResponseDto(String code, String message){
        
    }

}
