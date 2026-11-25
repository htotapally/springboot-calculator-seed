package com.aiops.governance.calculator.controller;

import com.aiops.governance.calculator.service.CalculatorService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/calc")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public record CalcRequest(Number a, Number b) {}

    @PostMapping("/add")
    public Map<String, Number> add(@RequestBody CalcRequest req) {
        return Map.of("result", calculatorService.add(req.a(), req.b()));
    }

    @PostMapping("/subtract")
    public Map<String, Number> subtract(@RequestBody CalcRequest req) {
        return Map.of("result", calculatorService.subtract(req.a(), req.b()));
    }

    @PostMapping("/multiply")
    public Map<String, Number> multiply(@RequestBody CalcRequest req) {
        return Map.of("result", calculatorService.multiply(req.a(), req.b()));
    }

    @PostMapping("/divide")
    public Map<String, Number> divide(@RequestBody CalcRequest req) {
        return Map.of("result", calculatorService.divide(req.a(), req.b()));
    }
}
