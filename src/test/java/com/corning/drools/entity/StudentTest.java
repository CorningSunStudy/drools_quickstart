package com.corning.drools.entity;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

@Slf4j
public class StudentTest {

    @Test
    public void t1() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieClasspathContainer.newKieSession();

        Student student = new Student();
        student.setId(1);
        student.setName("ZhangSan");
        student.setAge(5);

        log.info("source : " + student);

        kieSession.insert(student);

        kieSession.fireAllRules();

        log.info("result: " + student);

        kieSession.dispose();

        /*
        [main] INFO com.corning.drools.entity.StudentTest - source : Student(id=1, name=ZhangSan, age=5)
        student.age<10 occur
        student.age>10 and student.age<20 occur
        student.age>20 occur
        [main] INFO com.corning.drools.entity.StudentTest - result: Student(id=1, name=ZhangSan, age=30)
         */

    }

}
