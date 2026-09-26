class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[][] dp = new int[n1+1][n2+1];
        for(int[] d : dp){
            Arrays.fill(d,-1);
        }
        return solve(nums1,nums2,0,0,dp); 
    }
    public int solve(int[] nums1 , int[] nums2 , int idx1 , int idx2,int[][] dp){
        if(idx1>=nums1.length||idx2>=nums2.length){
            return 0;
        }
        if(dp[idx1][idx2]!=-1){
            return dp[idx1][idx2];
        }
        if(nums1[idx1]==nums2[idx2]){
            return dp[idx1][idx2] = 1+solve(nums1,nums2,idx1+1,idx2+1,dp);
        }
        int s1 = solve(nums1,nums2,idx1+1,idx2,dp);
        int s2 = solve(nums1,nums2,idx1,idx2+1,dp);
        return dp[idx1][idx2]=Math.max(s1,s2);
    }
}