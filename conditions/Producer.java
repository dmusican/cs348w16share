// Modifed from https://docs.oracle.com/javase/tutorial/essential/concurrency/guardmeth.html

public class Producer extends Thread {

    private Drop drop;
    private String id;
    
    public Producer(Drop drop, String id) {
        this.drop = drop;
        this.id = id;
    }

    public void run() {
        while (true) {
            try {
                double value = Math.random();
                drop.put(id + " "+value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}    
