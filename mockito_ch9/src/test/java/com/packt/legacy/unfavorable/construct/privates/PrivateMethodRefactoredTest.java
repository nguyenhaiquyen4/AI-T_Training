package com.packt.legacy.unfavorable.construct.privates;

import org.junit.Before;
import org.junit.Test;

public class PrivateMethodRefactoredTest {
    PrivateMethodRefactored privateMethod;

    @Before
    public void setUp() {
        privateMethod = new PrivateMethodRefactored() {
            protected void showError(String msg) {
            }
        };
    }

    @Test
    public void validate() throws Exception {
        privateMethod.validate(null);
    }
}
