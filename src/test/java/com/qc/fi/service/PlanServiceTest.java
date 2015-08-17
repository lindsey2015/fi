package com.qc.fi.service;

import com.qc.fi.model.Plan;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring-mvc.xml",
        "file:src/main/resources/spring.xml" })
@ActiveProfiles("test")
@Transactional
public class PlanServiceTest extends TestCase {
    @Autowired
    PlanService planService;

    @Test
    public void testFindAll() {
        List<Plan> plans = planService.findAll();
        assertNotNull(plans);
        assertEquals(2, plans.size());
    }
}