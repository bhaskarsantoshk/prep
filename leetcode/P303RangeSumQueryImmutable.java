package leetcode;

public class P303RangeSumQueryImmutable {
    int[] cumulativeSum;
    public P303RangeSumQueryImmutable(int[] nums) {
        if ( nums == null || nums.length == 0 ){
            return ;
        }
        int len = nums.length;
        cumulativeSum = new int[len];
        cumulativeSum[0] = nums[0];
        for ( int i=1; i<len; i++){
            cumulativeSum[i]= cumulativeSum[i-1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if ( cumulativeSum == null || cumulativeSum.length == 0 ){
            return 0;
        }
        if ( i == 0){
            return cumulativeSum[j];
        }
        return cumulativeSum[j]-cumulativeSum[i-1];
    }
}
