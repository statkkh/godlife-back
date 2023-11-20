package com.godlife.godlifeback.dto.response.study;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.common.object.MaterialCommentListItem;
import com.godlife.godlifeback.dto.response.ResponseCode;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.ResponseMessage;
import com.godlife.godlifeback.repository.resultSet.StudyCommentListResultSet;

import lombok.Getter;

@Getter
public class GetMaterialCommentResponseDto extends ResponseDto{

    
    private List<MaterialCommentListItem> materialCommentList; 

    private GetMaterialCommentResponseDto(String code, String message, List<StudyCommentListResultSet> resultSets){
        super(code, message);
        this.materialCommentList = MaterialCommentListItem.getMaterialCommentList(resultSets);
    }

    public static ResponseEntity<GetMaterialCommentResponseDto> success(List<StudyCommentListResultSet> resultSets){
        GetMaterialCommentResponseDto result = new GetMaterialCommentResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, resultSets);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    

}
