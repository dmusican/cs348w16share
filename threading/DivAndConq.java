import java.util.*;

class SumThread extends Thread {

    public static final int CUTOFF = 1000;
    private int[] arr;
    private int lo;
    private int hi;
    int ans;

    public SumThread(int[] arr, int lo, int hi) {
        this.arr = arr;
        this.lo = lo;
        this.hi = hi;
        ans = 0;
    }

    @Override
    public void run() {
        try {
            if (hi - lo < CUTOFF) {
                for (int i=lo; i < hi; i++)
                    ans += arr[i];
            }
            else {
                SumThread left = new SumThread(arr,lo,
                                               (lo+hi)/2);
                SumThread right = new SumThread(arr,
                                                (lo+hi)/2,
                                                hi);
                // Avoid making extra thread
                left.start();
                right.run();
                left.join();
                ans = left.ans + right.ans;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}

class DivAndConq {
    public static int sum(int[] arr) throws InterruptedException {
        SumThread t = new SumThread(arr,0,arr.length);
        t.run();
        return t.ans;
    }
    
    public static void main(String[] args) throws InterruptedException {
        int[] nums = new int[10000000];
        for (int i=0; i < nums.length; i++)
            nums[i] = i;
        System.out.println(sum(nums));
        // int supertotal = 0;
        // for (int i=0; i < 1000; i++)
        //     supertotal += sum(nums);
        // System.out.println(supertotal);
    }
}




    
