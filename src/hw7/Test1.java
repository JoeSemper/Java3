package hw7;

import hw7.annotations.AfterSuite;
import hw7.annotations.BeforeSuite;
import hw7.annotations.Test;

import java.util.Random;

public class Test1 {

    private static int a;
    private static int b;
    private static int c;


    @BeforeSuite
    public static void before() {
        Random random = new Random();
        a = random.nextInt(100);
        b = random.nextInt(100);
        c = random.nextInt(100);
        System.out.println("Before");
    }


    @Test(priority = 4)
    public static void test1() {
        System.out.println("Test1: " + a * b * c);
    }

    @Test(priority = 7)
    public static void test2() {
        System.out.println("Test2: " + (a + b + c));
    }

    @Test(priority = 5)
    public static void test3() {
        System.out.println("Test3: " + a + b * c);
    }



    @AfterSuite
    public static void after(){
        System.out.println("After");
    }


}
