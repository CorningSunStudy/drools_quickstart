package com.corning.drools.entity;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;

@Slf4j
public class QueryTest extends DroolsBaseTest {

    @Test
    public void query1() {
        final Student student1 = new Student();
        student1.setAge(1);
        student1.setName("student1");
        kieSession.insert(student1);

        final Student student2 = new Student();
        student2.setAge(2);
        student2.setName("student2");
        kieSession.insert(student2);

        final QueryResults queryResults1 = kieSession.getQueryResults("query_student_age_less_10");
        log.info("queryResults1.size()={}", queryResults1.size());

        for (QueryResultsRow queryResultsRow : queryResults1) {
            final Student student = (Student) queryResultsRow.get("$student");
            log.info("student={}", student);
        }

        /*
        [main] INFO com.corning.drools.entity.DroolsBaseTest - Fri Oct 23 15:48:07 CST 2020 - kieSession init
        [main] INFO com.corning.drools.entity.QueryTest - queryResults1.size()=2
        [main] INFO com.corning.drools.entity.QueryTest - student=Student(id=0, name=student1, age=1)
        [main] INFO com.corning.drools.entity.QueryTest - student=Student(id=0, name=student2, age=2)
        [main] INFO com.corning.drools.entity.DroolsBaseTest - Fri Oct 23 15:48:07 CST 2020 - kieSession dispose
         */

    }


}
