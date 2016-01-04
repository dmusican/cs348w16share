class ExampleThread extends Thread {

    private int num;

    public ExampleThread(int num) {
        this.num = num;
    }
    
    public void run() {
        System.out.println("Hi" + num);
    }

}

class RunItAll {
    public static void main(String[] args) {
        for (int i=0; i < 5; i++) {
            ExampleThread t = new ExampleThread(i);
            t.start();
        }
    }
}
