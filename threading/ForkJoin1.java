import java.util.*;
import java.util.concurrent.*;

class SumThread extends RecursiveAction {

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
    public void compute() {
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
            left.fork();
            right.compute();
            left.join();
            ans = left.ans + right.ans;
        }
    }
    
}

class ForkJoin1 {
    public static int sum(int[] arr) throws InterruptedException {
        SumThread t = new SumThread(arr,0,arr.length);
        ForkJoinPool.commonPool().invoke(t);
        return t.ans;
    }
    
    public static void main(String[] args) throws InterruptedException {
        int[] nums = new int[100000000];
        for (int i=0; i < nums.length; i++)
            nums[i] = i;
        System.out.println(sum(nums));
        // int supertotal = 0;
        // for (int i=0; i < 1000; i++)
        //     supertotal += sum(nums);
        // System.out.println(supertotal);
    }
}




    
