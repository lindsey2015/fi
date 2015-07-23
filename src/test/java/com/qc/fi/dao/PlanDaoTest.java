package com.qc.fi.dao;

import com.qc.fi.model.Plan;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring-mvc.xml",
        "file:src/main/resources/spring.xml"})
@ActiveProfiles("test")
@Transactional
public class PlanDaoTest extends TestCase {
    @Autowired
    PlanDao planDao;

    @Test
    public void testSave() {
        Plan p = new Plan();
        p.setCode("1236");
        p.setName("test3");
        p.setDescription("test3 desc");
        planDao.save(p);
        assertTrue(p.getId() > 0);
    }

    @Test
    public void testDelete() {
        planDao.delete(1);
        Plan p = planDao.findOne(1);
        assertNull(p);
    }

    @Test
    public void testUpdate() {
        Plan p = planDao.findOne(1);
        p.setName("Updated Name");
        p = planDao.update(p);
        assertEquals("Updated Name", p.getName());
    }

    @Test
    public void testFind() {
        Plan p = planDao.findOne(1);
        assertNotNull(p);
    }
}