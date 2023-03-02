public class MyCounter2 implements Runnable {
    private int threadNo;

    public MyCounter2(int threadNo) {
        this.threadNo = threadNo;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 9; i++) {
            if (threadNo == 1) {
                System.out.println(ThreadColor.ANSI_BLUE + "The value of i is: " + i + " and the thread number is: " + threadNo);
            } else {
                System.out.println(ThreadColor.ANSI_RED + "The value of i is: " + i + " and the thread number is: " + threadNo);
            }
        }
    }
}
