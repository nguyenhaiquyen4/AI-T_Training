package com.manning.readinglist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ReadingListApplication.class, webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SimpleWebTest {

    @Value("${local.server.port}")
    private int port;

    @Test
    public void testSomething() throws Exception {

        RestTemplate test = new RestTemplate();
//        Cannot test with FIX PORT
        String s = test.getForObject("http://localhost:{port}", String.class, port);
        System.out.println(s);
    }

    @Test(expected=HttpClientErrorException.class)
    public void pageNotFound() {
        try {
            RestTemplate rest = new RestTemplate();
            rest.getForObject("http://localhost:{port}/bogusPage", String.class, port);
            fail("Should result in HTTP 404");
        } catch (HttpClientErrorException e) {
            assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
            throw e;
        }
    }
}
