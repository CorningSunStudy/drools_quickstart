package com.corning.drools.controller;

import com.corning.drools.entity.Calculation;
import com.corning.drools.service.CalculationService;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author corning
 */
@RestController
@RequestMapping("/calculate")
public class CalculationController {

    @Autowired
    private CalculationService ruleService;

    @GetMapping("/{wage}")
    public Calculation calculate(@PathVariable("wage") double wage) {
        Preconditions.checkArgument(wage > 0, "税前工资必须为正数");
        Calculation calculation = new Calculation();
        calculation.setWage(wage);
        return ruleService.calculate(calculation);
    }

}
