package com.sharedevvoyage.javablogsample.api.reflection.service;

import com.sharedevvoyage.javablogsample.api.reflection.Model.EnumDynamicModel;
import com.sharedevvoyage.javablogsample.api.reflection.Model.EnumValue;
import com.sharedevvoyage.javablogsample.api.reflection.dto.SelectDynamicEnumsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BindingService {

    private final String BASE_PACKAGE = "com.sharedevvoyage.javablogsample.api";

    public List<SelectDynamicEnumsResponseDto> getDynamicEnums() {
        Reflections reflections = new Reflections(BASE_PACKAGE);
        Set<Class<?>> enumClasses = reflections.getTypesAnnotatedWith(EnumDynamicModel.class);

        return enumClasses.stream()
                .map(enumClass -> new SelectDynamicEnumsResponseDto(enumClass.getSimpleName(), convertEnumValueList(enumClass)))
                .toList();
    }

    private List<EnumValue> convertEnumValueList(Class<?> enumClass) {
        if(!enumClass.isEnum()) {
            throw new IllegalArgumentException("Enum 만 읽어올 수 있습니다.: " + enumClass.getName());
        }

        Object[] enumConstants = enumClass.getEnumConstants();
        enumConstants.getClass().getName();

        return Arrays.stream(enumConstants).map(e -> new EnumValue(e.toString())).toList();
    }

}
