package com.godlife.godlifeback.dto.request.study;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@Getter
public class PatchNoticeRequestDto {

    @NotBlank @Size(min = 1)
    private String noticeContent;


}
