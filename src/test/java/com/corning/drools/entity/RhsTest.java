package com.corning.drools.entity;

import lombok.extern.slf4j.Slf4j;
import org.drools.core.base.RuleNameStartsWithAgendaFilter;
import org.junit.Before;
import org.junit.Test;

@Slf4j
public class RhsTest extends DroolsBaseTest {


    @Test
    public void rhsHalt() {
        kieSession.fireAllRules(new RuleNameStartsWithAgendaFilter("rule_rhs_halt_"));

        /*
        [main] INFO com.corning.drools.entity.DroolsBaseTest - Mon Nov 02 16:11:12 CST 2020 - kieSession init
        [main] INFO com.corning.drools.entity.DroolsBaseTest - rule_rhs_halt_1 occur
        [main] INFO com.corning.drools.entity.DroolsBaseTest - Mon Nov 02 16:11:12 CST 2020 - kieSession dispose
         */

    }


}
