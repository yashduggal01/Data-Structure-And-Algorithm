class Solution {
    public int[] searchRange(int[] nums, int target) {
        int fidx = solve(nums,target,true);
        if(fidx==-1){
            return new int[]{-1,-1};
        }
        int sidx = solve(nums,target,false);
        return new int[]{fidx,sidx};
    }
    static int solve(int[] nums , int target , boolean flag ){
        int low = 0;
        int high = nums.length-1;
        int ans= -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                ans = mid;
                if(flag){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else if(nums[mid]<target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }
}