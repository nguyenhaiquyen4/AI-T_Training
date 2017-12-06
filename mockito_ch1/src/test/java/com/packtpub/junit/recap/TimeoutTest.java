package com.packtpub.junit.recap;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.concurrent.TimeUnit;

public class TimeoutTest {
    @Test(timeout = 10)
    public void forEver() throws Exception {
        Thread.sleep(100);
    }

    @Rule
    public Timeout globalTimeout = new Timeout(20, TimeUnit.MILLISECONDS);

    @Test
    public void testInfiniteLoop1() throws InterruptedException {
        Thread.sleep(30);
    }

    @Test
    public void testInfiniteLoop2() throws InterruptedException {
        Thread.sleep(30);
    }
}

