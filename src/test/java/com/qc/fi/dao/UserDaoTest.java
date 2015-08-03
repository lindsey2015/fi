package com.qc.fi.dao;

import com.qc.fi.model.User;
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
public class UserDaoTest extends TestCase{
    @Autowired
    UserDao userDao;
    @Test
    public void testSave(){
        User u=new User();
        u.setCellPhone("123456789");
        u.setChannelContact("hhh");
        u.setChannelContactType("ddd");
        u.setChannelName("sss");
        u.setCompanyName("wwww");
        u.setUserName("test");
        u.setEmail("aaa@xxx.com");
        u.setPassword("123");
        u.setPhone("99999999");
        u.setUserType("ddd");
        u.setContact("sss");
        userDao.save(u);
        assertTrue(u.getId()>0);

    }
    @Test
    public void testDelete(){
        userDao.delete(1);
        User u=userDao.findOne(1);
        assertNull(u);

    }
    @Test
    public void testUpdate(){
        User u=userDao.findOne(1);
        u.setUserName("newname");
        u=userDao.update(u);
        assertEquals("newname",u.getUserName());

    }
    @Test
    public void testFind(){
        User u=userDao.findOne(1);
        assertNotNull(u);

    }

}

