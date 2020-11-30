package com.corning.drools.service;

import com.corning.drools.entity.InsuranceInfo;
import com.corning.drools.utils.KieSessionUtils;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RuleService {

    public List<String> insuranceInfoCheck(InsuranceInfo insuranceInfo) throws Exception {
        String path = getClass().getResource("/").getPath() + "rules/insuranceInfoCheck.xls";
        KieSession session = KieSessionUtils.getKieSessionFromXLS(path);
        session.getAgenda().getAgendaGroup("sign").setFocus();

        session.insert(insuranceInfo);

        List<String> listRules = new ArrayList<>();
        session.setGlobal("listRules", listRules);

        session.fireAllRules();

        return listRules;
    }
}
