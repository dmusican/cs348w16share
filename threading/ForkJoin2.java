import java.util.*;
import java.util.concurrent.*;

class SumThread extends RecursiveTask<Integer> {

    public static final int CUTOFF = 1000;
    private int[] arr;
    private int lo;
    private int hi;
    private int ans;

    public SumThread(int[] arr, int lo, int hi) {
        this.arr = arr;
        this.lo = lo;
        this.hi = hi;
        ans = 0;
    }

    @Override
    public Integer compute() {
        if (hi - lo < CUTOFF) {
            for (int i=lo; i < hi; i++)
                ans += arr[i];
            return ans;
        }
        else {
            SumThread left = new SumThread(arr,lo,
                                           (lo+hi)/2);
            SumThread right = new SumThread(arr,
                                            (lo+hi)/2,
                                            hi);
            // Avoid making extra thread
            left.fork();
            int rightAns = right.compute();
            int leftAns = left.join();
            ans = leftAns + rightAns;
            return ans;
        }
    }
    
}

class ForkJoin2 {
    public static int sum(int[] arr) throws InterruptedException {
        SumThread t = new SumThread(arr,0,arr.length);
        return ForkJoinPool.commonPool().invoke(t);
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




    
