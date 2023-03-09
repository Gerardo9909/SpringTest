package com.exam.springtest.service;

import com.exam.springtest.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserService userService;

    @Test
    void testGetUsers() {
        when(userService.getUsers()).thenReturn(
                List.of(
                        new User("test1", "sample1", new Date(1991, 01, 14), 'F'),
                        new User("test2", "sample2", new Date(1999, 06, 23), 'M'),
                        new User("test2", "sample2", new Date(1993, 03, 21), 'M')
                )
        );

        Assertions.assertEquals(3, userService.getUsers().size());
    }

    @Test
    void testPostUser() {
        User user = new User("test1", "sample1", new Date(1991, 01, 14), 'F');
        when(userService.saveUser(user)).thenReturn(user);
        Assertions.assertNotNull(userService.saveUser(user));
    }

    @Test
    void testPostExistingUser() {
        User user = new User("test1", "sample1", new Date(1991, 01, 14), 'F');
        when(userService.saveUser(user)).thenReturn(null);
        Assertions.assertNull(userService.saveUser(user));
    }

    @Test
    void testPutUser() {
        User user = new User("test1", "sample1", new Date(1991, 01, 14), 'F');
        when(userService.modifyUser(user)).thenReturn(user);
        Assertions.assertNotNull(userService.modifyUser(user));
    }

    @Test
    void testPutExistingUser() {
        User user = new User("test1", "sample1", new Date(1991, 01, 14), 'F');
        when(userService.modifyUser(user)).thenReturn(null);
        Assertions.assertNull(userService.modifyUser(user));
    }
}


