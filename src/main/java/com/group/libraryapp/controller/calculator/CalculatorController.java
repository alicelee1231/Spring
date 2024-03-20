//package com.group.libraryapp.controller.calculator;
//
//import com.group.libraryapp.dto.calculator.request.CaculatorMultiplyRequest;
//import com.group.libraryapp.dto.calculator.request.CalculatorAddRequest;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
////before making API, consider points : Http method, Http Path and etc.
//@RestController
//public class CalculatorController {
//
//    @GetMapping("/add") // Http Method (Http Path )
//    public int addTwoNumbers(CalculatorAddRequest request){
//        return request.getNumber1() + request.getNumber2();
//    }
//    @PostMapping("/multiply") //RequestBody -> http body에 담겨있는 json을 CaculatorMultiplyRequest 객체로 변화시킬 수 있음
//    public int multiplyTwoNumbers(@RequestBody  CaculatorMultiplyRequest request){
//        return request.getNumber1() * request.getNumber2();
//    }
//}
