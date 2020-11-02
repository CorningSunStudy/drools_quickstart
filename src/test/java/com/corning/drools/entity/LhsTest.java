package com.corning.drools.entity;

import lombok.extern.slf4j.Slf4j;
import org.drools.core.base.RuleNameStartsWithAgendaFilter;
import org.junit.Before;
import org.junit.Test;

@Slf4j
public class LhsTest extends DroolsBaseTest {

    @Before
    public void setUP() {
        super.setUP();

        final Student student1 = new Student();
        student1.setAge(10);
        student1.setName("student1");
        kieSession.insert(student1);

        final Student student2 = new Student();
        student2.setAge(20);
        student2.setName("student2");
        kieSession.insert(student2);
    }

    @Test
    public void lhs() {
        kieSession.fireAllRules(new RuleNameStartsWithAgendaFilter("rule_lhs_"));

        /*
        [main] INFO com.corning.drools.entity.DroolsBaseTest - Fri Oct 23 16:30:07 CST 2020 - kieSession init
        [main] INFO com.corning.drools.entity.DroolsBaseTest - rule_lhs_1 occur, $student=Student(id=0, name=student1, age=1)
        [main] INFO com.corning.drools.entity.DroolsBaseTest - rule_lhs_2 occur, $student=Student(id=0, name=student2, age=2)
        [main] INFO com.corning.drools.entity.DroolsBaseTest - Fri Oct 23 16:30:08 CST 2020 - kieSession dispose
         */

    }

    @Test
    public void lhsEval() {
        kieSession.fireAllRules(new RuleNameStartsWithAgendaFilter("rule_lhs_eval_"));

        /*
        [main] INFO com.corning.drools.entity.DroolsBaseTest - Tue Oct 27 15:59:34 CST 2020 - kieSession init
        [main] INFO com.corning.drools.entity.DroolsBaseTest - rule_lhs_eval_1 occur
        [main] INFO com.corning.drools.entity.DroolsBaseTest - Tue Oct 27 15:59:34 CST 2020 - kieSession dispose
         */

    }

    @Test
    public void lhsNot() {
        kieSession.fireAllRules(new RuleNameStartsWithAgendaFilter("rule_lhs_not_"));

        /*
        [main] INFO com.corning.drools.entity.DroolsBaseTest - Tue Oct 27 15:53:41 CST 2020 - kieSession init
        [main] INFO com.corning.drools.entity.DroolsBaseTest - Tue Oct 27 15:53:41 CST 2020 - kieSession dispose
         */

    }

    @Test
    public void lhsExist() {
        kieSession.fireAllRules(new RuleNameStartsWithAgendaFilter("rule_lhs_exist_"));

        /*
        [main] INFO com.corning.drools.entity.DroolsBaseTest - Tue Oct 27 16:05:12 CST 2020 - kieSession init
        [main] INFO com.corning.drools.entity.DroolsBaseTest - rule_lhs_exist_1 occur
        [main] INFO com.corning.drools.entity.DroolsBaseTest - rule_lhs_exist_1 occur
        [main] INFO com.corning.drools.entity.DroolsBaseTest - rule_lhs_exist_2 occur
        [main] INFO com.corning.drools.entity.DroolsBaseTest - Tue Oct 27 16:05:12 CST 2020 - kieSession dispose
         */

    }


    @Test
    public void lhsExtends() {

        kieSession.fireAllRules(new RuleNameStartsWithAgendaFilter("rule_lhs_extends_"));
        // TODO rule_lhs_extends_2 继承的条件并没有生效
        /*
        [main] INFO com.corning.drools.entity.DroolsBaseTest - Mon Nov 02 15:59:54 CST 2020 - kieSession init
        [main] INFO com.corning.drools.entity.DroolsBaseTest - rule_lhs_extends_1 occur
        [main] INFO com.corning.drools.entity.DroolsBaseTest - rule_lhs_extends_2 occur
        [main] INFO com.corning.drools.entity.DroolsBaseTest - Mon Nov 02 15:59:54 CST 2020 - kieSession dispose
         */

    }

}
