package com.sharedevvoyage.javablogsample.api.reflection.controller;

import com.sharedevvoyage.javablogsample.api.reflection.dto.SelectDynamicEnumsResponseDto;
import com.sharedevvoyage.javablogsample.api.reflection.service.BindingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/binding")
public class BindingController {

    private final BindingService bindingService;

    @GetMapping("/dynamic")
    public ResponseEntity<List<SelectDynamicEnumsResponseDto>> getDynamicBinding() {
        return ResponseEntity.ok(bindingService.getDynamicEnums());
    }
}
