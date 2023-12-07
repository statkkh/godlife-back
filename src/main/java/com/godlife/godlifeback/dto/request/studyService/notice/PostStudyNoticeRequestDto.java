package com.godlife.godlifeback.dto.request.studyService.notice;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostNoticeRequestDto {
    @NotBlank @Size(min = 1)
    private String noticeContent;
}
