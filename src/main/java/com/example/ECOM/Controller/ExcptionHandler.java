package com.example.ECOM.Controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExcptionHandler {
    @ExceptionHandler(Exception.class)
    public ModelAndView exception(Exception ex){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("error");
        mav.addObject("errors", ex.getMessage());
        return mav;
    }
}
