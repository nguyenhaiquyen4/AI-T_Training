package com.quyen.chapter3;

import org.junit.Assert;
import org.junit.Test;

public class StubTest {
    class Father {
        public String getHomeLand() {
            return "";
        }
    }

    class FatherStub extends Father {
        public String getHomeLand() {
            return "Long An";
        }
    }

    class Student {
        String name;
        Father father;
        public Student(String name, Father father){
            this.name = name;
            this.father = father;
        }
        public String getHomeLand(){
            return father.getHomeLand();
        }
    }

    @Test
    public void connect_must_be_established_after_connect() {
        Student quyen = new Student("Quyen", new FatherStub());
        Assert.assertEquals("Long An", quyen.getHomeLand());
    }
}
