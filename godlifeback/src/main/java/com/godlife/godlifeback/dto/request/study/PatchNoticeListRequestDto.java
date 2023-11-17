package com.godlife.godlifeback.dto.request.study;


import java.util.List;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NotBlank
@Setter
@NoArgsConstructor
public class PatchNoticeListRequestDto {

    @NotBlank
    private List<String> noticeContentList;
    
    @NotBlank
    public  String getNoticeContent() {
        return null;
    }

    
}
