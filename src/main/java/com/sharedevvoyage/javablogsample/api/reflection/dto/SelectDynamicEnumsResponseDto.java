package com.sharedevvoyage.javablogsample.api.reflection.dto;

import com.sharedevvoyage.javablogsample.api.reflection.Model.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class SelectDynamicEnumsResponseDto {
    private String className;
    private List<EnumValue> names;
}
