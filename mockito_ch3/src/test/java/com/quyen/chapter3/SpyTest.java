package com.quyen.chapter3;

import org.junit.Assert;
import org.junit.Test;

public class SpyTest {
    class Father {
        public String getHomeLand() {
            return "Long An";
        }
    }

    class FatherSpy extends Father {
        int count = 0;

        public String getHomeLand() {
            count++;
            return super.getHomeLand();
        }

        public int getCount() {
            return count;
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

    @Test
    public void count_the_number_of_invoke_getHomeLand() {
        FatherSpy spy = new FatherSpy();
        Student quyen = new Student("Quyen", spy);
        quyen.getHomeLand();
        quyen.getHomeLand();
        Assert.assertEquals(2, spy.getCount());
    }
}

