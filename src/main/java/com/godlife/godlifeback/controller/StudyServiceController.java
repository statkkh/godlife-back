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


import com.godlife.godlifeback.dto.response.studyService.PostStudyUserListResponseDto;

import com.godlife.godlifeback.dto.request.study.PatchNoticeRequestDto;
import com.godlife.godlifeback.dto.request.study.PostMaterialRequestDto;

import com.godlife.godlifeback.dto.response.study.GetStudyNoticeListResponseDto;
import com.godlife.godlifeback.dto.response.study.PostNoticeResponseDto;
import com.godlife.godlifeback.dto.response.study.PatchNoticeResponseDto;
import com.godlife.godlifeback.dto.response.study.DeleteNoticeResponseDto;

import com.godlife.godlifeback.dto.request.studyService.todo.PostStudyTodoListRequestDto;
import com.godlife.godlifeback.dto.request.studyService.PatchStudyTodoListRequestDto;

import com.godlife.godlifeback.dto.response.studyService.todo.GetStudyTodoListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.todo.PostStudyTodoListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.todo.PatchStudyTodoListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.todo.DeleteStudyTodoListResponseDto;

import com.godlife.godlifeback.dto.request.studyService.material.PostMaterialRequestDto;

import com.godlife.godlifeback.dto.response.studyService.material.GetStudyMaterialListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.material.PostStudyMaterialResponseDto;
import com.godlife.godlifeback.dto.response.studyService.material.DeleteStudyMaterialResponseDto;

import com.godlife.godlifeback.dto.request.studyService.materialComment.PostMaterialCommentRequestDto;
import com.godlife.godlifeback.dto.request.studyService.materialComment.PatchMaterialCommentReqeuestDto;

import com.godlife.godlifeback.dto.response.studyService.materialComment.GetStudyMaterialCommentListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.materialComment.PostMaterialCommentResponseDto;
import com.godlife.godlifeback.dto.response.studyService.materialComment.PatchMaterialCommentResponseDto;
import com.godlife.godlifeback.dto.response.studyService.materialComment.DeleteStudyMaterialCommentResponseDto;


import com.godlife.godlifeback.service.StudyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/service")
@RequiredArgsConstructor
public class StudyController {
    
    private final StudyService studyService;

    @PostMapping("/{studyNumber}/user-list/{studyGrade}")
    ResponseEntity<? super PostStudyUserListResponseDto> postStudyUserList(
        @PathVariable("studyNumber") Integer studyNumber,
        @PathVariable("studyGrade") String studyGrade,
        @AuthenticationPrincipal String userEmail   
    ) {
        ResponseEntity<? super PostStudyUserListResponseDto> response = studyService.postStudyUserList(studyNumber, studyGrade, userEmail);
        return response;
    }

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
    
    @GetMapping("/{studyNumber}/todo-list")
    public ResponseEntity<? super GetStudyTodoListResponseDto> getTodolist(
        @AuthenticationPrincipal String userEmail,
        @PathVariable("studyNumber")  Integer studyNumber
    ){
        ResponseEntity<? super GetStudyTodoListResponseDto> response = studyService.getTodolist(userEmail, studyNumber);
        return response;
    }        

    @PostMapping("/{studyNumber}/todo-list")
    public ResponseEntity<? super PostStudyTodoListResponseDto> postTodo(
        @RequestBody @Valid  PostStudyTodoListRequestDto requestBody,
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNumber")  Integer studyNumber
    ){
        ResponseEntity<? super  PostStudyTodoListResponseDto> response = studyService.postTodo(requestBody, createStudyUserEmail, studyNumber);
        return response;
    }     
    
    @PatchMapping("/{studyNumber}/todo-list")
    public ResponseEntity<? super PatchStudyTodoListResponseDto> postTodo(
        @RequestBody @Valid  PatchStudyTodoListRequestDto requestBody,
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNumber")  Integer studyNumber
    ){
        ResponseEntity<? super  PatchStudyTodoListResponseDto> response = studyService.patchTodo(requestBody, createStudyUserEmail, studyNumber);
        return response;
    }          

    @DeleteMapping("/{studyNumber}/todo-list/{studyListNumber}")
    public ResponseEntity<? super DeleteStudyTodoListResponseDto> postTodo(
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNumber")  Integer studyNumber,
        @PathVariable("studyListNumber")  Integer studyListNumber
    ){
        ResponseEntity<? super  DeleteStudyTodoListResponseDto> response = studyService.deleteTodo( createStudyUserEmail, studyNumber, studyListNumber);
        return response;
    }    

    @GetMapping("{studyNumber}/material")
    public ResponseEntity<? super GetStudyMaterialListResponseDto> getMaterialList(
        @AuthenticationPrincipal String userEmail,
        @PathVariable("studyNumber")  Integer studyNumber        
    ){
        ResponseEntity<? super GetStudyMaterialListResponseDto> response = studyService.getMaterialList(userEmail, studyNumber);
        return response;
    }

    @PostMapping("{studyNumber}/material")
    public ResponseEntity<? super PostStudyMaterialResponseDto> postMaterial(
        @RequestBody @Valid PostStudyMaterialRequestDto requestBody,
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNumber")  Integer studyNumber
    ){
        ResponseEntity<? super PostStudyMaterialResponseDto> response = studyService.postMaterial(requestBody, createStudyUserEmail, studyNumber);
        return response;
    }



    @DeleteMapping("/{studyNumber}/material/{studyMaterialNumber}")
    public ResponseEntity<? super DeleteStudyMaterialResponseDto> deleteMaterial(
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNumber")  Integer studyNumber,
        @PathVariable("studyMaterialNumber")  Integer studyMaterialNumber                  
    ){
        ResponseEntity<? super DeleteStudyMaterialResponseDto> response = studyService.deleteMaterial(createStudyUserEmail, studyNumber, studyMaterialNumber);
        return response;
    }

    @GetMapping("/{studyNumber}/{studyMaterialNumber}/material-comment")
    public ResponseEntity<? super GetStudyMaterialCommentListResponseDto> getMaterialComment(
        @AuthenticationPrincipal String userEmail,
        @PathVariable("studyNumber")  Integer studyNumber,
        @PathVariable("studyMaterialNumber")  Integer studyMaterialNumber
    ){
        ResponseEntity<? super GetStudyMaterialCommentListResponseDto> response = studyService.getMaterialCommentList(userEmail, studyNumber,studyMaterialNumber);
        return response;
    }

    @PostMapping("/{studyNumber}/{studyMaterialNumber}/material-comment")
    public ResponseEntity<? super PostStudyMaterialCommentResponseDto> postMaterialComment(
        @RequestBody @Valid PostStudyMaterialCommentRequestDto requestBody,
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNumber")  Integer studyNumber,
        @PathVariable("studyMaterialNumber")  Integer studyMaterialNumber        
    ){
        ResponseEntity<? super PostStudyMaterialCommentResponseDto> response = studyService.postMaterialComment(requestBody, createStudyUserEmail, studyNumber,studyMaterialNumber);
        return response;
    }

    @PatchMapping("/{studyNumber}/{studyMaterialNumber}/material-comment")
    public ResponseEntity<? super PatchStudyMaterialCommentResponseDto> patchMaterialComment(
        @RequestBody @Valid PatchStudyMaterialCommentRequestDto requestBody,
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNumber")  Integer studyNumber,
        @PathVariable("studyCommentNumber")  Integer studyMaterialNumber
    ){
        ResponseEntity<? super PatchStudyMaterialCommentResponseDto> response = studyService.patchMaterialComment(requestBody, createStudyUserEmail, studyNumber, studyMaterialNumber);
        return response;
    }

    @DeleteMapping("/{studyNumber}/{studyMaterialNumber}/material-comment/{studyCommentNumber}")
    public ResponseEntity<? super DeleteStudyMaterialCommentResponseDto> deleteMaterialComment(
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNumber")  Integer studyNumber,
        @PathVariable("studyMaterialNumber")  Integer studyMaterialNumber,
        @PathVariable("studyCommentNumber")  Integer studyCommentNumber
    ){
        ResponseEntity<? super DeleteStudyMaterialCommentResponseDto> response = studyService.deleteMaterialComment(createStudyUserEmail, studyNumber, studyMaterialNumber,studyCommentNumber);
        return response;
    }

}

