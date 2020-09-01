package com.corning.drools.entity;

import lombok.extern.slf4j.Slf4j;
import org.drools.core.base.RuleNameStartsWithAgendaFilter;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

@Slf4j
public class NoloopTest {

    @Test
    public void testNoloop() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieClasspathContainer.newKieSession();

        Student student = new Student();
        student.setId(1);
        student.setName("ZhangSan");
        student.setAge(50);

        kieSession.insert(student);

        kieSession.fireAllRules(new RuleNameStartsWithAgendaFilter("noloop_student"));

        kieSession.dispose();

        /*
        noloop_student.age==50 occur
         */

    }



}
