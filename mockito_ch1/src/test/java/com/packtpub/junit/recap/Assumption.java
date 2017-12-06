package com.packtpub.junit.recap;

import org.junit.Assume;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Assumption {
    boolean isSonarRunning = false;

    @Test
    public void very_critical_test() throws Exception {
        isSonarRunning = true;
        Assume.assumeFalse(isSonarRunning);
        assertTrue(true);
    }
}