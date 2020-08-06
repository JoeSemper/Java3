package hw7;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main (String[] args) {

        try {
            TestExecutor.start(Test1.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
