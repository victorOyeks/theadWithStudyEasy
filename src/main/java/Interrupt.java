public class Interrupt {
    static private int balance = 5000;

    public int withdrawal(int amount) {
        synchronized (this) {
            if (balance <= 0 || balance < amount) {
                try {
                    System.out.println("Waiting for balance update");
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Original balance: " + balance);
                    System.out.println("Withdrawal amount: " + amount);
                    balance -= amount;
                    System.out.println("Withdrawal successful and the current balance is: " + balance);
                }
            } else {
                System.out.println("Withdrawal of " + amount + " successful! Current balance is: " +(balance - amount));

            }return balance;
        }
    }

    public int deposit(int amount) {
           System.out.println("We are depositing " + amount +", and current balance is " + (balance + amount));
           return balance +=amount;
    }

    public static void main(String[] args) {

        Interrupt app = new Interrupt();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                app.withdrawal(1000);
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                app.deposit(2000);
                thread1.interrupt();
            }
        });
        thread2.start();
    }
}
