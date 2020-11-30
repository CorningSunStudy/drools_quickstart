package com.corning.drools.controller;

import com.corning.drools.entity.CreditCardApplyInfo;
import com.corning.drools.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author corning
 */
@RestController
@RequestMapping("/rule")
public class RuleController {

    @Autowired
    private RuleService ruleService;

    @PostMapping("/creditCardApply")
    public CreditCardApplyInfo creditCardApply(@RequestBody CreditCardApplyInfo creditCardApplyInfo) {
        return ruleService.creditCardApply(creditCardApplyInfo);
    }

}
