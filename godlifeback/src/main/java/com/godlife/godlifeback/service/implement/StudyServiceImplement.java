package com.godlife.godlifeback.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.godlife.godlifeback.dto.request.study.PatchNoticeRequestDto;
import com.godlife.godlifeback.dto.request.study.PostNoticeRequestDto;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.study.DeleteNoticeResponseDto;
import com.godlife.godlifeback.dto.response.study.PatchNoticeResponseDto;
import com.godlife.godlifeback.dto.response.study.PostNoticeResponseDto;
import com.godlife.godlifeback.entity.StudyNoticeEntity;
import com.godlife.godlifeback.repository.StudyNoticeRepository;
import com.godlife.godlifeback.service.StudyService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudyServiceImplement implements StudyService{
    
    private final StudyNoticeRepository studyNoticeRepository;

    @Override
    public ResponseEntity<? super PostNoticeResponseDto> postNotice(PostNoticeRequestDto dto, Integer noticeNumber) {

        StudyNoticeEntity studyNoticeEntity = null;
        // 
        try {
            studyNoticeEntity = studyNoticeRepository.findByNoticeNumber(noticeNumber);
            if(studyNoticeEntity == null) return PostNoticeResponseDto.notExistNotice();
            
            studyNoticeRepository.save(studyNoticeEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PostNoticeResponseDto.success(studyNoticeEntity);
    }

    @Override
    public ResponseEntity<? super PatchNoticeResponseDto> patchNotice(PatchNoticeRequestDto dto,Integer noticeNumber) {
        
        try {
            
            StudyNoticeEntity studyNoticeEntity = studyNoticeRepository.findByNoticeNumber(noticeNumber);
            if(studyNoticeEntity == null) return PatchNoticeResponseDto.notExistNotice();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PatchNoticeResponseDto.success();
        
    }

    @Override
    public ResponseEntity<? super DeleteNoticeResponseDto> deleteNotice(Integer noticeNumber) {
        
        try {

            StudyNoticeEntity studyNoticeEntity = studyNoticeRepository.findByNoticeNumber(noticeNumber);
            if(studyNoticeEntity == null) return DeleteNoticeResponseDto.notExistNotice();            
        
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return DeleteNoticeResponseDto.success();

    }

}
