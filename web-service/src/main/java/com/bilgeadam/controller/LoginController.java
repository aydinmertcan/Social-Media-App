package com.bilgeadam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public class LoginController {
    // localhost/login
    @GetMapping("login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        /**
         * template altındaki html page ile aynı olmalıdır.
         * public altında ki html file'ları KULLANILAMAZ
         */
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
