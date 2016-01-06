import java.util.*;

class SumThread extends Thread {

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
        for (int i=lo; i < hi; i++)
            ans += arr[i];
    }
    
}

class SumItAll {
    public static int sum(int[] arr) throws InterruptedException {
        SumThread[] ts = new SumThread[8];
        for (int i=0; i < 8; i++) {
            ts[i] = new SumThread(arr, (i*arr.length)/8,
                                  ((i+1)*arr.length)/8);
            ts[i].start();
        }
        // total answers across all threads
        int ans = 0;
        for (int i=0; i < 8; i++) {
            ts[i].join();
            ans += ts[i].ans;
        }
        return ans;
    }
    
    public static void main(String[] args) throws InterruptedException {
        int[] nums = new int[100000000];
        for (int i=0; i < nums.length; i++)
            nums[i] = i;
        System.out.println(sum(nums));
        int supertotal = 0;
        for (int i=0; i < 1000; i++)
            supertotal += sum(nums);
        System.out.println(supertotal);
    }
}




    
