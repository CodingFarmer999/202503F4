package com.course.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute
    public void addCommonAttributes(Model model) {
        // 在這裡設定共用的模型屬性，例如 title
        model.addAttribute("title", "甜 時 ． Sweet");
    }
}
