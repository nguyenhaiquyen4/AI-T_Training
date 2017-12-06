package com.packtpub.junit.recap;

import static com.packtpub.junit.recap.LessThanOrEqual.lessThanOrEqual;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class AssertThatTest {
    @Test
    public void verify_Matcher() throws Exception {
        int age = 30;
        assertThat(age, equalTo(30));
        assertThat(age, is(30));
        assertThat(age, not(equalTo(33)));
        assertThat(age, is(not(33)));
    }

    @Test
    public void verify_multiple_values() throws Exception {
        double marks = 100.00;
        assertThat(marks, either(is(100.00)).or(is(90.9)));
        assertThat(marks, both(not(99.99)).and(not(60.00)));
        assertThat(marks, anyOf(is(100.00), is(1.00), is(55.00),
                is(88.00), is(67.8)));
        assertThat(marks, not(anyOf(is(0.00), is(200.00))));
        assertThat(marks, not(allOf(is(1.00), is(100.00), is(30.00))));
    }

    @Test
    public void verify_collection_values() throws Exception {
        List<Double> salary = Arrays.asList(50.0, 200.0, 500.0);
        assertThat(salary, hasItem(50.00));
        assertThat(salary, hasItems(50.00, 200.00));
        assertThat(salary, not(hasItem(1.00)));
    }

    @Test
    public void verify_Strings() throws Exception {
        String name = "John Jr Dale";
        assertThat(name, startsWith("John"));
        assertThat(name, endsWith("Dale"));
        assertThat(name, containsString("Jr"));
        assertThat(name, allOf(is("John Jr Dale"), not("Da")));
    }

    @Test
    public void lessthanOrEquals_custom_matcher() throws
            Exception
    {
        int actualGoalScored = 2;
        assertThat(actualGoalScored, lessThanOrEqual(4));
        assertThat(actualGoalScored, lessThanOrEqual(2));
        double originalPI = 3.14;
        assertThat(originalPI, lessThanOrEqual(9.00));
        String authorName = "Sujoy";
        assertThat(authorName, lessThanOrEqual("Zachary"));
    }
}