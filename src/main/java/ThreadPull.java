public class ThreadPull extends Thread{
    private String name;

    public ThreadPull(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Starting thread:" + name);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
