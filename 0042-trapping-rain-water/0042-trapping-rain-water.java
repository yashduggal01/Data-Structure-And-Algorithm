class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int lmax = 0;
        int rmax=0;
        for(int i = 0;i<n;i++){
            lmax=Math.max(lmax,height[i]);
            prefix[i] = lmax;
        }
        for(int i = n-1;i>=0;i--){
            rmax = Math.max(rmax,height[i]);
            suffix[i] = rmax;
        }
        int total = 0;
        for(int i = 0;i<n;i++){
            total+=Math.min(prefix[i],suffix[i])-height[i];
        }
        return total;
    }
}