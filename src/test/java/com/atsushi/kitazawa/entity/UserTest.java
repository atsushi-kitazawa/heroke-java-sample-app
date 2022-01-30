package com.atsushi.kitazawa.entity;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.hamcrest.Matchers;
import org.junit.Test;

public class UserTest {
    
    @Test
    public void testUserInstance() {
        User user = new User("aaa", "bbb");
        assertThat(user.name(), Matchers.is("aaa"));
        assertThat(user.password(), Matchers.is("bbb"));
    }

    @Test
    public void testUserEqauls() {
        User a1 = new User("aaa", "bbb");
        User a2 = new User("aaa", "bbb");
        assertEquals(a1, a2);
    }

    @Test
    public void testChangePassword() {
        User user = new User("aaa", "bbb");
        user.changePassword("BBB");
        assertThat(user.password(), Matchers.is("BBB"));
    }
}
