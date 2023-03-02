public class WaitAndNotify {
    static private int balance;
    public void withdrawal(int amount) {
        synchronized (this)
        {
            if(balance<=0) {
                try {
                    System.out.println("Waiting for balance update");
                    wait(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        balance -=amount;
        System.out.println("Withdrawal successful and the current balance is: " + balance);
    }
    public void deposit(int amount) {
        System.out.println("We are depositing the amount");
        balance +=amount;
        synchronized (this)
        {
            notify();
        }
    }

    public static void main(String[] args) {

        WaitAndNotify app = new WaitAndNotify();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                app.withdrawal(1000);
            }
        });
//        thread1.setName("Thread 1");
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                app.deposit(2000);
            }
        });
//        thread1.setName("Thread 2");
        thread2.start();
    }
}
