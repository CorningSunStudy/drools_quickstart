package com.corning.drools.service;

import com.corning.drools.entity.Calculation;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {

    @Autowired
    private KieBase kieBase;

    public Calculation calculate(Calculation calculation) {
        KieSession kieSession = kieBase.newKieSession();

        kieSession.insert(calculation);

        kieSession.fireAllRules();
        kieSession.dispose();

        return calculation;
    }
}
