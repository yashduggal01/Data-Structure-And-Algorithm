class Solution {
    public int deleteAndEarn(int[] nums) {
        int mval = 0;
        for(int num : nums){
            mval = Math.max(num,mval);
        }
        int n = nums.length;
        int[] points = new int[mval+1];
        for(int num : nums){
            points[num]+=num;
        }
        Integer[] memo = new Integer[mval+1];
        return solve(mval,memo,points);
    }
    public int solve(int mval , Integer[] memo , int[] points){
        if(mval<=0){
            return 0;
        }
        if(memo[mval]!=null){
            return memo[mval];
        }
        int take = points[mval]+ solve(mval-2,memo,points);
        int skip = solve(mval-1,memo,points);
        return memo[mval] = Math.max(take,skip);
    }
}