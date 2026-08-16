class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int max=0;
        int sum=0;
        for(int i=0;i<n;i++){
            if(weights[i]>max){
                max=weights[i];
            }
        }
        for(int i=0;i<n;i++){
            sum=sum+weights[i];
        }
        int low=max;
        int high=sum;
        while(low<=high){
            int mid=(high+low)/2;
            int ndays=f(weights,mid);
            if(ndays<=days){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    public static int f(int[] weights,int mid){
        int days=1,load=0;
        for(int i=0;i<weights.length;i++){  
            if(load+weights[i]>mid){
                days=days+1;
                load=weights[i];
            }
            else{
                load+=weights[i];
            }
        }
        return days;
    }
}