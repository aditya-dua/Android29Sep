package com.adityadua.testingdemo;

import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    int a = 10;

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void multiplcation_check() throws Exception{

        assertEquals("Maybe you are multiplying the wrong Numbers",a, 4*5);
    }

    @Before
    public void beforeTesting() throws Exception{

        a = 20;
    }

    @Test
    public void passWordValidation() throws Exception{
        assertEquals("aditya","aditya");
    }

    @After
    public void afterTesting(){
        //Log.d("Testing Done","Testing Done! Gud to close");
    }



}