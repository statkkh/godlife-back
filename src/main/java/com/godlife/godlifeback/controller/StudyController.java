package com.godlife.godlifeback.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.godlife.godlifeback.dto.request.study.PatchNoticeRequestDto;
import com.godlife.godlifeback.dto.request.study.PostMaterialRequestDto;
import com.godlife.godlifeback.dto.request.study.PostNoticeRequestDto;
import com.godlife.godlifeback.dto.response.study.DeleteNoticeResponseDto;
import com.godlife.godlifeback.dto.response.study.GetStudyNoticeListResponseDto;
import com.godlife.godlifeback.dto.response.study.PatchNoticeResponseDto;
import com.godlife.godlifeback.dto.response.study.PostMaterialResponseDto;
import com.godlife.godlifeback.dto.response.study.PostNoticeResponseDto;
import com.godlife.godlifeback.service.StudyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/service")
@RequiredArgsConstructor
public class StudyController {
    
    private final StudyService studyService;

    @PostMapping("/{studyNumber}/notice")
    public ResponseEntity<? super PostNoticeResponseDto> postNotice(
        @RequestBody @Valid  PostNoticeRequestDto  requestBody,
        @PathVariable("studyNumber") Integer studyNumber,
        @AuthenticationPrincipal String createStudyUserEmail
    ){
        ResponseEntity<? super PostNoticeResponseDto> response = studyService.postNotice(requestBody,studyNumber, createStudyUserEmail);
        return response;
    }

    @GetMapping("/{studyNumber}/notice")
    public ResponseEntity<? super GetStudyNoticeListResponseDto> getNotice(
        @PathVariable("studyNumber")  Integer studyNumber,
        @AuthenticationPrincipal String userEmail
    ){
        ResponseEntity<? super  GetStudyNoticeListResponseDto> response = studyService.getNotice(studyNumber, userEmail);
        return response;
    }

    @PatchMapping("/{studyNumber}/notice/{studyNoticeNumber}")
    public ResponseEntity<? super PatchNoticeResponseDto> patchNotice(
        @RequestBody @Valid  PatchNoticeRequestDto  requestBody,
        @PathVariable("studyNumber") Integer studyNumber,
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNoticeNumber") Integer studyNoticeNumber        
    ){
        ResponseEntity<? super PatchNoticeResponseDto> response = studyService.patchNotice(requestBody, studyNumber,createStudyUserEmail,studyNoticeNumber);
        return response;
    }

    @DeleteMapping("/{studyNumber}/notice/{studyNoticeNumber}")
    public ResponseEntity<? super DeleteNoticeResponseDto> deletNotice(
        @PathVariable("studyNumber") Integer studyNumber,
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNoticeNumber") Integer studyNoticeNumber 
    ){
        ResponseEntity<? super DeleteNoticeResponseDto> response = studyService.deleteNotice(studyNumber, createStudyUserEmail, studyNoticeNumber);
        return response;                
    }
    

    @PostMapping("/{studyNumber}/material")
    public ResponseEntity<? super PostMaterialResponseDto> postMaterial(
        @RequestBody @Valid  PostMaterialRequestDto  requestBody,
        @PathVariable("studyNumber") Integer studyNumber,
        @AuthenticationPrincipal String createStudyUserEmail,
        @RequestParam("studyMaterialImageUrl") String studyMaterialImageUrl
    ){
        ResponseEntity<? super PostMaterialResponseDto>  response = studyService.postMaterial(requestBody,studyNumber, createStudyUserEmail,studyMaterialImageUrl);
        return response;
    }

}

