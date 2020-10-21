package com.corning.drools.entity;

import lombok.extern.slf4j.Slf4j;
import org.drools.core.base.RuleNameStartsWithAgendaFilter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

@Slf4j
public class DateEffectiveTest extends DroolsBaseTest {

    @Before
    public void setUP() {
        // 指定 date-effective 日期格式
        System.setProperty("drools.dateformat", "yyyy-MM-dd HH:mm:ss");
        super.setUP();
    }

    @Test
    public void ruleDateEffective() {

        kieSession.fireAllRules(new RuleNameStartsWithAgendaFilter("rule_dateEffective_"));

        /*
        [main] INFO com.corning.drools.entity.DroolsBaseTest - Wed Oct 21 11:28:19 CST 2020 - kieSession init
        [main] INFO com.corning.drools.entity.DroolsBaseTest - Wed Oct 21 11:28:19 CST 2020 - rule_dateEffective_1 occur
        [main] INFO com.corning.drools.entity.DroolsBaseTest - Wed Oct 21 11:28:19 CST 2020 - kieSession dispose
         */
    }



}
