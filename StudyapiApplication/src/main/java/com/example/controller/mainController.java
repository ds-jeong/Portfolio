package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;


@Slf4j
@Controller
public class mainController {
    @RequestMapping(value="/")
    public static String main(String[] args, Model model) throws IOException{
        return "index";
    }
}
