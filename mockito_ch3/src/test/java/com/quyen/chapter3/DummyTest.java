package com.quyen.chapter3;

import org.junit.Assert;
import org.junit.Test;

public class DummyTest {
    class People {
        String name;
        Mother mother;
        public People(String name, Mother m){
            this.name = name;
            this.mother = m;
        }

        public void setName(String newName){
            this.name = newName;
        }

        public String getName() {
            return name;
        }
    }

    class Mother {
        String name;
    }

    @Test
    public void newName_must_be_changed(){
        Mother dummyMother = new Mother();
        People quyen = new People("Quyen", dummyMother);
        quyen.setName("Ken");
        Assert.assertEquals("Ken", quyen.getName());
    }
}

