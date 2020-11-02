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

    @Test
    public void rhsWorkingMemory() {
        kieSession.fireAllRules(new RuleNameStartsWithAgendaFilter("rule_rhs_workingMemory_"));

        /*
        [main] INFO com.corning.drools.entity.DroolsBaseTest - Mon Nov 02 16:19:01 CST 2020 - kieSession init
        [main] INFO com.corning.drools.entity.DroolsBaseTest - rule_rhs_workingMemory_1 occur
        [main] INFO com.corning.drools.entity.DroolsBaseTest - workingMemory=KieSession[0]
        [main] INFO com.corning.drools.entity.DroolsBaseTest - Mon Nov 02 16:19:01 CST 2020 - kieSession dispose
         */

    }

    @Test
    public void rhsGetRule() {
        kieSession.fireAllRules(new RuleNameStartsWithAgendaFilter("rule_rhs_getRule_"));

        /*
        [main] INFO com.corning.drools.entity.DroolsBaseTest - Mon Nov 02 16:27:14 CST 2020 - kieSession init
        [main] INFO com.corning.drools.entity.DroolsBaseTest - rule_rhs_getRule_1 occur
        [main] INFO com.corning.drools.entity.DroolsBaseTest - rule=[Rule name=rule_rhs_getRule_1, agendaGroup=MAIN, salience=0, no-loop=false]
        [main] INFO com.corning.drools.entity.DroolsBaseTest - id=rule_rhs_getRule_1, autoFocus=false, dateExpires=null
        [main] INFO com.corning.drools.entity.DroolsBaseTest - Mon Nov 02 16:27:14 CST 2020 - kieSession dispose
         */

    }


}
