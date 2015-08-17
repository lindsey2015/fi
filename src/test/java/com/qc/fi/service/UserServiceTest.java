package com.qc.fi.service;

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
        "file:src/main/resources/spring.xml" })
@ActiveProfiles("test")
@Transactional
public class UserServiceTest extends TestCase {
    @Autowired
    UserService userService;

    @Test
    public void testAdd() {
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

        userService.add(user);
        assertTrue(user.getId() > 0);
    }

    @Test
    public void testDelete() {
        userService.delete(1);
        User user = userService.getById(1);
        assertNull(user);
    }

    @Test
    public void testUpdate() {
        User user = userService.getById(1);
        user.setUserName("newname");
        user = userService.update(user);
        assertEquals("newname", user.getUserName());
    }

    @Test
    public void testList() {
        List<User> users = userService.list();
        assertNotNull(users);
        assertEquals(1, users.size());
    }

    @Test
    public void testGetById() {
        User user = userService.getById(1);
        assertNotNull(user);
    }

    @Test
    public void testGetByUserNamePassword() {
        User user = userService.getByUserNamePwd("test", "password");
        assertNotNull(user);
    }
}
