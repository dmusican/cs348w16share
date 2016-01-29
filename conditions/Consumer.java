// Modifed from https://docs.oracle.com/javase/tutorial/essential/concurrency/guardmeth.html

public class Consumer extends Thread {

    private Drop drop;
    private String id;

    public Consumer(Drop drop) {
        this.drop = drop;
    }

    public void run() {
        while (true) {
            try {
                System.out.println("                                     Taking: " + drop.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}    
