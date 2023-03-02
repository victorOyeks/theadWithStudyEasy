public class MyCounter extends Thread {

    private int threadNo;

    public MyCounter(int threadNo) {
        this.threadNo = threadNo;
    }

    @Override
    public void run() {
        countMe();
    }

    public void countMe() {
        for (int i = 0; i <= 9; i++) {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("The value of i is: " + i + " and the thread number is: " + threadNo);
        }
    }
}
