public class Brackets {
    synchronized public void generate() {
            for (int i = 1; i <= 10; i++) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (i<=5) {
                    System.out.print("[");
                } else {
                    System.out.print("]");
                }
            }
            System.out.println();


        for(int j = 0; j<=10; j++) {
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


