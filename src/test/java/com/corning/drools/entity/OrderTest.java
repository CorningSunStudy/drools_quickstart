package com.corning.drools.entity;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import static org.junit.Assert.*;

@Slf4j
public class OrderTest {

    @Before
    public void setUp() throws Exception {
    }


    @Test
    public void bookDiscount1() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieClasspathContainer.newKieSession();

        Order order = new Order();
        order.setOriginalPrice(50D);

        log.info("source : " + order);

        kieSession.insert(order);

        kieSession.fireAllRules();

        log.info("result: " + order);

        /*
        [main] INFO com.corning.drools.entity.OrderTest - source: Order(originalPrice=50.0, realPrice=null)
        bookDiscount_1, Order(originalPrice=50.0, realPrice=50.0)
        [main] INFO com.corning.drools.entity.OrderTest - result: Order(originalPrice=50.0, realPrice=50.0)
        */
    }

}

