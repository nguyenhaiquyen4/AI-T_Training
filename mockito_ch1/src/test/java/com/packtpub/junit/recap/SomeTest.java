package com.packtpub.junit.recap;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.fail;

public class SomeTest {
    @Test
    public void a() {
        fail();
    }

    @Category(CrazyTests.class)
    @Test
    public void b() {
    }
}