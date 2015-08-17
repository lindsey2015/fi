package com.qc.fi.dao;

import com.qc.fi.model.User;
import com.qc.fi.model.UserType;
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
        "file:src/main/resources/spring.xml"})
@ActiveProfiles("test")
@Transactional
public class UserDaoTest extends TestCase {
    @Autowired
    UserDao userDao;

    @Test
    public void testSave() {
        User user = new User();
        user.setCellPhone("123456789");
        user.setChannelContact("hhh");
        user.setChannelContactType("ddd");
        user.setChannelName("sss");
        user.setCompanyName("wwww");
        user.setUserName("test");
        user.setEmail("aaa@xxx.com");
        user.setPassword("123");
        user.setPhone("99999999");
        user.setUserType(UserType.NORMAL.getCode());
        user.setContact("sss");

        userDao.save(user);
        assertTrue(user.getId() > 0);
    }

    @Test
    public void testDelete() {
        userDao.delete(1);
        User user = userDao.findOne(1);
        assertNull(user);
    }

    @Test
    public void testUpdate() {
        User user = userDao.findOne(1);
        user.setUserName("newname");
        user = userDao.update(user);
        assertEquals("newname", user.getUserName());
    }

    @Test
    public void testFindOneById() {
        User user = userDao.findOne(1);
        assertNotNull(user);
    }

    @Test
    public void testFindOneByUserNamePassword() {
        User user = userDao.findOne("test", "password");
        assertNotNull(user);
    }

    @Test
    public void testFindAllNormalUser() {
        List<User> users = userDao.findAllNormalUsers();
        assertNotNull(users);
        assertTrue(users.size() > 0);
        for (User user : users) {
            assertNotNull(user);
            assertEquals(user.getUserType(), UserType.NORMAL.getCode());
        }
    }
}

