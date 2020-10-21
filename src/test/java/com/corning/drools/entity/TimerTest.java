package com.corning.drools.entity;

import lombok.extern.slf4j.Slf4j;
import org.drools.core.base.RuleNameStartsWithAgendaFilter;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

@Slf4j
public class TimerTest {

    @Test
    public void testTimer() throws InterruptedException {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieClasspathContainer.newKieSession();
        kieSession.setGlobal("log", log);

        log.info("fireUntilHaltStart");
        new Thread(() -> kieSession.fireUntilHalt(new RuleNameStartsWithAgendaFilter("rule_timer_")))
                .start();

        Thread.sleep(10000);

        // 结束规则引擎
        kieSession.halt();
        log.info("kieSession halt");

        // 关闭会话
        kieSession.dispose();
        log.info("kieSession dispose");

        /*
        [main] INFO com.corning.drools.entity.TimerTest - fireUntilHaltStart
        [Thread-0] INFO com.corning.drools.entity.TimerTest - rule_timer_1 occur
        [Thread-0] INFO com.corning.drools.entity.TimerTest - rule_timer_1 occur
        [main] INFO com.corning.drools.entity.TimerTest - kieSession halt
        [main] INFO com.corning.drools.entity.TimerTest - kieSession dispose
         */

    }


}
