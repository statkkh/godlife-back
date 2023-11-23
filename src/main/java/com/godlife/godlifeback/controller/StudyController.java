package com.godlife.godlifeback.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.godlife.godlifeback.dto.request.study.PostNoticeRequestDto;
import com.godlife.godlifeback.dto.response.study.GetStudyNoticeListResponseDto;
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
        @AuthenticationPrincipal String userEmail
    ){
        ResponseEntity<? super PostNoticeResponseDto> response = studyService.postNotice(requestBody,studyNumber, userEmail);
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


}

