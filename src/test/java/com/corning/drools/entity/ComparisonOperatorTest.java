package com.corning.drools.entity;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

@Slf4j
public class ComparisonOperatorTest {

    @Test
    public void contains() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieClasspathContainer.newKieSession();

        ComparisonOperatorEntity fact = new ComparisonOperatorEntity();
        String zhangSan = "ZhangSan";
        String liSi = "LiSi";

        fact.setNames(zhangSan);
        fact.setList(Lists.newArrayList(zhangSan, liSi));

        kieSession.insert(fact);
        kieSession.fireAllRules();
        kieSession.dispose();

        /*
        comparison_operator_contains occur
         */
    }

    @Test
    public void memberOf() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieClasspathContainer.newKieSession();

        ComparisonOperatorEntity fact = new ComparisonOperatorEntity();
        String zhangSan = "ZhangSan";
        String liSi = "LiSi";

        fact.setNames(zhangSan);
        fact.setList(Lists.newArrayList(zhangSan, liSi));

        kieSession.insert(fact);
        kieSession.fireAllRules();
        kieSession.dispose();

        /*
        comparison_operator_memberOf occur
         */
    }

    @Test
    public void matches() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieClasspathContainer.newKieSession();

        ComparisonOperatorEntity fact = new ComparisonOperatorEntity();
        String zhangSan = "WangWu";

        fact.setNames(zhangSan);
        fact.setList(Lists.newArrayList(zhangSan));

        kieSession.insert(fact);
        kieSession.fireAllRules();
        kieSession.dispose();

        /*
        comparison_operator_matches occur
         */
    }
}
