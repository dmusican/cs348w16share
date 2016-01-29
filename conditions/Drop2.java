// Modified from https://docs.oracle.com/javase/tutorial/essential/concurrency/guardmeth.html

public class Drop {
    private String message;
    private boolean empty = true;

    public synchronized String take() throws InterruptedException {
        while (empty)
            wait();
        empty = true;
        notify();
        return message;
    }

    public synchronized void put(String message) throws InterruptedException {
        while (!empty)
            wait();
        empty = false;
        System.out.println("Putting: " + message);
        this.message = message;
        notify();
    }
}
