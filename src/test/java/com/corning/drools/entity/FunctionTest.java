package com.corning.drools.entity;

import lombok.extern.slf4j.Slf4j;
import org.drools.core.base.RuleNameStartsWithAgendaFilter;
import org.junit.Before;
import org.junit.Test;

@Slf4j
public class FunctionTest extends DroolsBaseTest {

    @Before
    public void setUP() {
        super.setUP();

        final Student student1 = new Student();
        student1.setAge(100);
        student1.setName("student1");
        kieSession.insert(student1);

        final Student student2 = new Student();
        student2.setAge(2);
        student2.setName("student2");
        kieSession.insert(student2);
    }

    @Test
    public void function() {
        kieSession.fireAllRules(new RuleNameStartsWithAgendaFilter("rule_function_"));

        /*
        [main] INFO com.corning.drools.entity.DroolsBaseTest - Fri Oct 23 16:20:35 CST 2020 - kieSession init
        [main] INFO com.corning.drools.entity.DroolsBaseTest - helloMsg=[hello student1]
        [main] INFO com.corning.drools.entity.DroolsBaseTest - Fri Oct 23 16:20:35 CST 2020 - kieSession dispose
         */

    }



}
