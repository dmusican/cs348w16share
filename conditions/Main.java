public class Main {
    public static void main(String[] args) {
        Drop drop = new Drop();
        (new Producer(drop,"A")).start();
        (new Producer(drop,"B")).start();
        (new Consumer(drop)).start();
    }
}
