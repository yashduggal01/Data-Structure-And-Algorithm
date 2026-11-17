class Solution {
    public int removeDuplicates(int[] nums) {
        int idx = 0;
        int i = 1;
        while(i<nums.length&&idx<nums.length){
            if(nums[idx]==nums[i]){
                i++;
            }
            else{
                nums[idx+1] = nums[i];
                idx++;
                i++;
            }
        }
        return idx+1;
    }
}