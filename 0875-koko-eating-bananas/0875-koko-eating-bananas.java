class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low  = 1 ;
        int high = 0;
        int ans = high;
        for(int p : piles){
            high = Math.max(p,high);
        }
        while(low<=high){
            int mid = low+(high-low)/2;
           // if(piles[mid]==0) continue;
            if(feasible(piles,h,mid)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    static boolean feasible(int[] arr , int h , int p){
        long total = 0 ;
        for(int pile : arr){
            total+=pile/p;
            if(pile%p!=0){
                total++;
            }
        }
        return total<=h;
    }
}