package com.corning.drools.entity;

import lombok.extern.slf4j.Slf4j;
import org.drools.core.base.RuleNameStartsWithAgendaFilter;
import org.junit.Before;
import org.junit.Test;

@Slf4j
public class DateExpiresTest extends DroolsBaseTest {

    @Test
    public void ruleDateEffective() {

        kieSession.fireAllRules(new RuleNameStartsWithAgendaFilter("rule_dateExpires_"));

        /*
        [main] INFO com.corning.drools.entity.DroolsBaseTest - Wed Oct 21 11:36:14 CST 2020 - kieSession init
        [main] INFO com.corning.drools.entity.DroolsBaseTest - Wed Oct 21 11:36:14 CST 2020 - rule_dateExpires_2 occur
        [main] INFO com.corning.drools.entity.DroolsBaseTest - Wed Oct 21 11:36:14 CST 2020 - kieSession dispose
         */
    }



}
