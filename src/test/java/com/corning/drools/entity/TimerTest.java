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
public class TimerTest {

    private KieSession kieSession;

    @Before
    public void setUP() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        kieSession = kieClasspathContainer.newKieSession();
        kieSession.setGlobal("log", log);
    }

    @After
    public void setDown() {
        // 结束规则引擎
        kieSession.halt();
        log.info("kieSession halt");

        // 关闭会话
        kieSession.dispose();
        log.info("kieSession dispose");
    }

    @Test
    public void testTimer1() throws InterruptedException {

        log.info("fireUntilHaltStart");
        new Thread(() -> kieSession.fireUntilHalt(new RuleNameStartsWithAgendaFilter("rule_timer_1")))
                .start();

        Thread.sleep(10000);
        /*
        [main] INFO com.corning.drools.entity.TimerTest - fireUntilHaltStart
        [Thread-0] INFO com.corning.drools.entity.TimerTest - rule_timer_1 occur
        [Thread-0] INFO com.corning.drools.entity.TimerTest - rule_timer_1 occur
        [main] INFO com.corning.drools.entity.TimerTest - kieSession halt
        [main] INFO com.corning.drools.entity.TimerTest - kieSession dispose
         */
    }

    @Test
    public void testTimer2() throws InterruptedException {
        log.info("fireUntilHaltStart");
        new Thread(() -> kieSession.fireUntilHalt(new RuleNameStartsWithAgendaFilter("rule_timer_2")))
                .start();

        Thread.sleep(10000);

        /*
        [main] INFO com.corning.drools.entity.TimerTest - fireUntilHaltStart
        [Thread-0] INFO com.corning.drools.entity.TimerTest - rule_timer_2 occur at Wed Oct 21 11:02:10 CST 2020
        [Thread-0] INFO com.corning.drools.entity.TimerTest - rule_timer_2 occur at Wed Oct 21 11:02:12 CST 2020
        [Thread-0] INFO com.corning.drools.entity.TimerTest - rule_timer_2 occur at Wed Oct 21 11:02:14 CST 2020
        [Thread-0] INFO com.corning.drools.entity.TimerTest - rule_timer_2 occur at Wed Oct 21 11:02:16 CST 2020
        [Thread-0] INFO com.corning.drools.entity.TimerTest - rule_timer_2 occur at Wed Oct 21 11:02:18 CST 2020
        [main] INFO com.corning.drools.entity.TimerTest - kieSession halt
        [main] INFO com.corning.drools.entity.TimerTest - kieSession dispose
         */
    }

}
