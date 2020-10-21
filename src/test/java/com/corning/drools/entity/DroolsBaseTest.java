package com.corning.drools.entity;

import lombok.extern.slf4j.Slf4j;
import org.drools.core.base.RuleNameStartsWithAgendaFilter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.Date;

@Slf4j
public class DroolsBaseTest {

    protected KieSession kieSession;

    @Before
    public void setUP() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        kieSession = kieClasspathContainer.newKieSession();
        kieSession.setGlobal("log", log);
        log.info("{} - kieSession init", new Date());
    }

    @After
    public void tearDown() {
        // 关闭会话
        kieSession.dispose();
        log.info("{} - kieSession dispose", new Date());
    }

}
