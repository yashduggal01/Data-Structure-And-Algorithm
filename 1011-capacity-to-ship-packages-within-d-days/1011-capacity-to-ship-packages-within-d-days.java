class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 1;
        int total = 0;
        for(int i = 0 ;i<weights.length;i++){
            total+=weights[i];
            low = Math.max(low,weights[i]);
        }
        int high = total;
        int ans = high;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(feasible(weights,days,mid)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    static boolean feasible(int[] arr , int days , int cap){
        int curr = 0;
        int total = 1;
        for(int num : arr){
            if(num>cap) return false;
            if(curr+num>cap){
                curr = num;
                total++;
            }
            else{
                curr+=num;
            }
        }
        return total<=days;
    }
}