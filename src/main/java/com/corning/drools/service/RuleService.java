package com.corning.drools.service;

import com.corning.drools.entity.CreditCardApplyInfo;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RuleService {

    @Autowired
    private KieBase kieBase;

    public CreditCardApplyInfo creditCardApply(CreditCardApplyInfo creditCardApplyInfo) {
        KieSession kieSession = kieBase.newKieSession();

        kieSession.insert(creditCardApplyInfo);

        kieSession.fireAllRules();
        kieSession.dispose();

        return creditCardApplyInfo;
    }
}
