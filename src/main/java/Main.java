import javax.crypto.spec.PSource;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        MyCounter myCounter1 = new MyCounter(1);
//        MyCounter myCounter2 = new MyCounter(2);
//
//        Thread thread1 = new Thread(new MyCounter2(1));
//        Thread thread2 = new Thread(new MyCounter2(2));
//
//        thread1.start();
//        thread2.start();

        Brackets bracket = new Brackets();

        new Thread(new Runnable() {
            @Override
            public void run() {
                long startTime = System.currentTimeMillis();
                for (int i=1; i<=5; i++) {
                    bracket.generate();
                }
                long endTime = System.currentTimeMillis();
                long thread1Time = endTime-startTime;
                System.out.println("Time required for thread 1: " + thread1Time);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                long startTime = System.currentTimeMillis();
                for (int i=1; i<=5; i++) {
                    bracket.generate();
                }
                long endTime = System.currentTimeMillis();
                long thread2Time = endTime-startTime;
                System.out.println("Time required for thread 2: " + thread2Time);
            }
        }).start();
    }
}
