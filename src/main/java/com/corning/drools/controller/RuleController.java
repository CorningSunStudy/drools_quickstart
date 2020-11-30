package com.corning.drools.controller;

import com.corning.drools.entity.InsuranceInfo;
import com.corning.drools.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author corning
 */
@RestController
@RequestMapping("/rule")
public class RuleController {

    @Autowired
    private RuleService ruleService;

    @PostMapping("/insuranceInfoCheck")
    public Map<String, Object> insuranceInfoCheck(@RequestBody InsuranceInfo insuranceInfo) throws Exception {
        Map<String, Object> map = new HashMap<>();

        List<String> list = ruleService.insuranceInfoCheck(insuranceInfo);
        if (list != null && list.size() > 0) {
            map.put("checkResult", false);
            map.put("msg", "准入失败");
            map.put("detail", list);
        } else {
            map.put("checkResult", true);
            map.put("msg", "准入成功");
        }
        return map;
    }

}
