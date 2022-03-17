//package com.zzj.servicefeign.util;
//
//
//import lombok.Data;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
///**
// * @author zhaozj37918
// * @date 2022年03月04日 16:58
// */
//
//@Slf4j
//@RestControllerAdvice
//@Data
//public class GlobalExceptionHandler {
//    private String code;
//    private String Msg;
//
//    @ResponseBody
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public NotValidR notValidR(MethodArgumentNotValidException e)
//    {
//        NotValidR notValid = new NotValidR();
//        notValid.setCode("400");
//        notValid.setMsg(e.getBindingResult().getFieldError().getDefaultMessage());
//        return notValid;
//    }
//}
