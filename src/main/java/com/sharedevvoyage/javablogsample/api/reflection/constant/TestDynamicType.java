package com.sharedevvoyage.javablogsample.api.reflection.constant;

import com.sharedevvoyage.javablogsample.api.reflection.Model.EnumDynamicModel;

@EnumDynamicModel
public enum TestDynamicType {
    START("시작"),
    END("끝"),
    STOP("멈춤");

    private final String description;

    TestDynamicType(String description) {
        this.description = description;
    }
}
