class ExampleThread extends Thread {

    private int num;

    public ExampleThread(int num) {
        this.num = num;
    }
    
    public void run() {
        long total = 0;
        for (long j = 0; j < 100000000000l; j++)
            total += j;
        System.out.println("Hi" + num + total);
    }
    
}

class RunItAll {
    public static void main(String[] args) {
        for (int i=0; i < 8; i++) {
            ExampleThread t = new ExampleThread(i);
            t.start();
        }
    }
}
