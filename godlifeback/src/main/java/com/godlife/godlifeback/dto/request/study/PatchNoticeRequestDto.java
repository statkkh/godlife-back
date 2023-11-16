package com.godlife.godlifeback.dto.request.study;


import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatchNoticeRequestDto {

    @NotBlank
    private String noticeContent;
}
