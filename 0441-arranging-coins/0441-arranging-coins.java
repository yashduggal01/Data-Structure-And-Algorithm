class Solution {
    public int arrangeCoins(int n) {
        long low = 1;
        long high = n;
        long ans = 1;
        if(n==1){
            return 1;
        }
        while(low<=high){
            long mid = low+(high-low)/2;
            long cused = mid*(mid+1)/2;
            if(cused==n) return (int)mid;
           else if(cused<n){
                low = mid+1;
            }
            else{
                //ans = high;
                high = mid-1;
            }
        }
        return (int)high;
    }
}