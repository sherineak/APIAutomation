package org.example.Tests.misc.parallel;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainClass {
    @BeforeMethod
    public void beforeMethod(){
        Long id = Thread.currentThread().threadId();
        System.out.println("Before test - Method. Thread id is : "+ id + getClass());
    }
    @Test
    public void testMethodM1(){
        Long id = Thread.currentThread().threadId();
        System.out.println(" test - Method. Thread id is : "+ id + getClass());
    }
    @Test
    public void testMethodM2(){
        Long id = Thread.currentThread().threadId();
        System.out.println("test - Method. Thread id is : "+ id + getClass());
    }
    @Test
    public void testMethodM3(){
        Long id = Thread.currentThread().threadId();
        System.out.println("test - Method. Thread id is : "+ id + getClass());
    }
    @Test
    public void testMethodM4(){
        Long id = Thread.currentThread().threadId();
        System.out.println(" test - Method. Thread id is : "+ id + getClass());
    }
    @Test
    public void testMethodM5(){
        Long id = Thread.currentThread().threadId();
        System.out.println(" test - Method. Thread id is : "+ id + getClass());
    }
    @Test
    public void testMethodM6(){
        Long id = Thread.currentThread().threadId();
        System.out.println(" test - Method. Thread id is : "+ id + getClass());
    }

    @AfterTest
    public void afterMethod(){
        Long id = Thread.currentThread().threadId();
        System.out.println("After test - Method. Thread id is : "+ id + getClass());
    }

}
