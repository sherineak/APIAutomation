package org.example.Tests.misc.parallel;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainClass2 {
    @BeforeMethod
    public void beforeMethod1(){
        Long id = Thread.currentThread().threadId();
        System.out.println("Before test - Method. Thread id is : "+ id + getClass());
    }
    @Test
    public void testMethodMc1(){
        Long id = Thread.currentThread().threadId();
        System.out.println("Before test - Method. Thread id is : "+ id + getClass());
    }
    @Test
    public void testMethodMc2(){
        Long id = Thread.currentThread().threadId();
        System.out.println("Before test - Method. Thread id is : "+ id + getClass());
    }
    @Test
    public void testMethodMc3(){
        Long id = Thread.currentThread().threadId();
        System.out.println("Before test - Method. Thread id is : "+ id + getClass());
    }
    @Test
    public void testMethodMc4(){
        Long id = Thread.currentThread().threadId();
        System.out.println("Before test - Method. Thread id is : "+ id + getClass());
    }
    @Test
    public void testMethodMc5(){
        Long id = Thread.currentThread().threadId();
        System.out.println("Before test - Method. Thread id is : "+ id + getClass());
    }
    @Test
    public void testMethodMc6(){
        Long id = Thread.currentThread().threadId();
        System.out.println("Before test - Method. Thread id is : "+ id + getClass());
    }

    @Test
    public void afterMethod1(){
        Long id = Thread.currentThread().threadId();
        System.out.println("Before test - Method. Thread id is : "+ id + getClass());
    }

}
