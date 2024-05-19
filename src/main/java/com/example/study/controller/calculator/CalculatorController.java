package com.example.study.controller.calculator;

import com.example.study.dto.calculator.CalculatorRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {
    @GetMapping("/calc")
    public String TwoNumbers(CalculatorRequest request)
    {
        int addResult = request.getNumber1() + request.getNumber2();
        int subResult = request.getNumber1() - request.getNumber2();
        int mulResult = request.getNumber1() * request.getNumber2();
        int divResult = request.getNumber1() / request.getNumber2();

        return String.format("{\n\"add\" : %d,\n\"minus\" : %d,\n\"multiply\" : %d,\n\"division\" : %d\n}",
                addResult, subResult, mulResult, divResult);
    }
}