package com.quyen.chapter3;

import org.junit.Assert;
import org.junit.Test;

public class DummyTest2 {
    class People {
        String name;

        public People(String name) {
            this.name = name;
        }
    }

    @Test
    public void newName_must_be_changed() {
        People dummy = new People("dummy");
        Assert.assertNotNull(dummy);
    }
}
