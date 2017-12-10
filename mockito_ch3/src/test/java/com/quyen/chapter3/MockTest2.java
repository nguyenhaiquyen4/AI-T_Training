package com.quyen.chapter3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class MockTest2 {
    class Father {
        public String getHomeLand() {
            return "";
        }
    }

    class Student {
        String name;
        Father father;

        public Student(String name, Father father) {
            this.name = name;
            this.father = father;
        }

        public String getHomeLand() {
            return father.getHomeLand();
        }
    }

    @Mock
    Father father;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void connect_must_be_established_after_connect() {
        Student quyen = new Student("Quyen", father);
        when(father.getHomeLand()).thenReturn("Long An");
        Assert.assertEquals("Long An", quyen.getHomeLand());
    }
}
