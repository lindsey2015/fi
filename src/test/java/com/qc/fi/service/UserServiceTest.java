package com.qc.fi.service;


import com.qc.fi.model.User;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceTest extends TestCase{

    @Autowired
    UserService userService;
    @Test
    public void testFindAll(){
        List<User> users=userService.findAll();
        assertNotNull(users);
        assertEquals(2,users.size());
    }

    @Test
    public void testDelete(){
        userService.delete(1);


    }
    @Test
    public void testUpdate(){

    }
    @Test
    public void testAdd(){

    }
    @Test
    public void testFindById(){

    }
}
