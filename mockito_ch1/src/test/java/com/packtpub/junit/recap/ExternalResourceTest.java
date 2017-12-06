package com.packtpub.junit.recap;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;
import org.junit.rules.TestName;

public class ExternalResourceTest {
    Resource resource;

    @Rule
    public TestName name = new TestName();

    public @Rule
    ExternalResource rule = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            resource = new Resource();
            resource.open();
            System.out.println(name.getMethodName());
        }

        @Override
        protected void after() {
            resource.close();
            System.out.println("\n");
        }
    };

    @Test
    public void someTest() throws Exception {
        System.out.println(resource.get());
    }

    @Test
    public void someTest2() throws Exception {
        System.out.println(resource.get());
    }
}
