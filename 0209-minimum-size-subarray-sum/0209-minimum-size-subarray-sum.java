class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left  = 0;
       //int right = 0;
        int sum = 0;
        int total = 0;
        for(int x : nums){
            total+=x;
        }
        if(total<target) return 0;
        int mlength= Integer.MAX_VALUE;
        for(int right = 0;right<nums.length;right++){
             sum+=nums[right];
            while(sum>=target){
                 mlength = Math.min(mlength,right-left+1);
                sum-=nums[left];
                left++;
            }
           
        }
        return mlength;
    }
}