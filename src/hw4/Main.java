package hw4;

public class Main {

    private static Object mon = new Object();
    private static volatile int key = 1;
    private static int count = 5;

    public static void main(String[] args) {

        new Thread(() -> {
            try {
                for (int i = 0; i <count ; i++) {
                    synchronized (mon){
                        while (key != 1) {
                            mon.wait();
                        }
                        System.out.print("A");
                        key = 2;
                        mon.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i <count ; i++) {
                    synchronized (mon){
                        while (key != 2) {
                            mon.wait();
                        }
                        System.out.print("B");
                        key = 3;
                        mon.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i <count ; i++) {
                    synchronized (mon){
                        while (key != 3) {
                            mon.wait();
                        }
                        System.out.print("C");
                        key = 1;
                        mon.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
