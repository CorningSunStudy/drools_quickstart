package com.corning.drools.entity;

import lombok.extern.slf4j.Slf4j;
import org.drools.core.base.RuleNameStartsWithAgendaFilter;
import org.junit.Before;
import org.junit.Test;

@Slf4j
public class GlobalTest extends DroolsBaseTest {

    @Test
    public void ruleGlobal() {
        Integer count = 1;
        log.info("beforeRule count={}", count);

        // 全局包装类型，rule中修改的值只在当前rule有效
        kieSession.setGlobal("count", count);

        kieSession.fireAllRules(new RuleNameStartsWithAgendaFilter("rule_global_"));

        log.info("afterRule count={}", count); // 1

        /*
        [main] INFO com.corning.drools.entity.DroolsBaseTest - Wed Oct 21 14:27:00 CST 2020 - kieSession init
        [main] INFO com.corning.drools.entity.GlobalTest - beforeRule count=1
        [main] INFO com.corning.drools.entity.DroolsBaseTest - Wed Oct 21 14:27:00 CST 2020 rule_global_1 occur
        [main] INFO com.corning.drools.entity.DroolsBaseTest - rule_global_1 count=11
        [main] INFO com.corning.drools.entity.DroolsBaseTest - Wed Oct 21 14:27:00 CST 2020 rule_global_2 occur
        [main] INFO com.corning.drools.entity.DroolsBaseTest - rule_global_2 count=1
        [main] INFO com.corning.drools.entity.GlobalTest - afterRule count=1
        [main] INFO com.corning.drools.entity.DroolsBaseTest - Wed Oct 21 14:27:01 CST 2020 - kieSession dispose
         */
    }



}
