package hw7;

import hw7.annotations.AfterSuite;
import hw7.annotations.BeforeSuite;
import hw7.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TestExecutor {


    public static void start(Class test) throws InvocationTargetException, IllegalAccessException {

        Method[] methods = test.getDeclaredMethods();

        int numOfBefore = 0;
        int numOfAfter = 0;

        for (Method mt : methods) {

            if (mt.isAnnotationPresent(BeforeSuite.class)) {
                numOfBefore++;
            }
            if (mt.isAnnotationPresent(AfterSuite.class)) {
                numOfAfter++;
            }

        }

        if (numOfBefore > 1 || numOfAfter > 1) {
            throw new RuntimeException("Аннотаций Before или After больше 1");
        }


        for (Method mt : methods) {
            if (mt.isAnnotationPresent(BeforeSuite.class)) {
                mt.invoke(test);
            }

        }

        for (int i = 10; i > 0 ; i--) {

            for (Method mt : methods) {
                if (mt.isAnnotationPresent(Test.class) && mt.getAnnotation(Test.class).priority() == i) {
                    mt.invoke(test);
                }
            }
        }

        for (Method mt : methods) {
            if (mt.isAnnotationPresent(AfterSuite.class)) {
                mt.invoke(test);
            }

        }
    }
}
