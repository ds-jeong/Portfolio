package com.example.StudyPopupApiApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PopupApiController {

    @RequestMapping(value = "/jusoPopup")
    public static String callPopup(String[] args) {
        return "popup/jusoPopup";
    }
    @RequestMapping(value = "/")
    public static String main(String[] args) {
        return "sample";
    }
}
