class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<3){
            return 0;
        }
        int count = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            for(int j = i+2;j<n;j++){
                if(solve(nums,i,j,n)){
                    count++;
                }
                else{
                    break;
                }
            }
        }
        return count;
    }
    static boolean solve(int[] nums , int i ,int j, int n){
        if(i>=n||j>=n){
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        boolean flag = true;
        for(int k = i+1;k<=j;k++){
            int diff = nums[k]-nums[k-1];
            if(set.isEmpty()){
                set.add(diff);
            }
            else{
            if(!set.contains(diff)){
                flag = false;
                break;
            }
            }
        }
        return flag;
    }
}