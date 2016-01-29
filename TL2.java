import java.util.concurrent.atomic.AtomicInteger;

public class TL2 {

    private static class MyThreadLocal<T> extends ThreadLocal<T> {
        public int myValue = 0;
    }
    
     // Thread local variable containing each thread's ID
     private static final MyThreadLocal<Integer> threadId =
         new MyThreadLocal<Integer>();

     public static void main(String[] args) throws InterruptedException {
         Thread t1 = new Thread() {
             public void run() {
                 threadId.set(1);
                 threadId.myValue = 15;
                 System.out.println(threadId + " " + threadId.get()
                                    + " " + threadId.myValue);
             }
         };
         Thread t2 = new Thread() {
             public void run() {
                 threadId.set(2);
                 threadId.myValue = 16;
                 System.out.println(threadId + " " + threadId.get()
                                    + " " + threadId.myValue);
             }
         };
         t1.start();
         t2.start();
         t1.join();
         t2.join();
         System.out.println(threadId + " " + threadId.get()
                            + " " + threadId.myValue);
     }
     
 }
