package com.corning.drools.entity;

import lombok.extern.slf4j.Slf4j;
import org.drools.core.base.RuleNameStartsWithAgendaFilter;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

@Slf4j
public class AgendaGroupTest {

    @Test
    public void testAgendaGroup() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieClasspathContainer.newKieSession();

        // 获取焦点且 when 条件为 true 才会执行
        kieSession.getAgenda().getAgendaGroup("agendaGroup2").setFocus();

        kieSession.fireAllRules(new RuleNameStartsWithAgendaFilter("agendaGroup_"));

        kieSession.dispose();

        /*
        agendaGroup_4 occur
         */

        /*
        agendaGroup_1 occur
        agendaGroup_2 occur
        agendaGroup_4 occur
         */

    }



}
