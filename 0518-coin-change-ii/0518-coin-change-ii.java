class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[amount+1][n+1];
        for(int[] d : dp){
            Arrays.fill(d,-1);
        }
        return solve(amount , coins , 0,dp);
    }
    public int solve(int amount , int[] coins , int idx,int[][] dp){
        if(idx>=coins.length){
            return 0;
        }
        if(amount==0){
            return 1;
        }
        if(dp[amount][idx]!=-1){
            return dp[amount][idx];
        }
        int count = solve(amount,coins , idx+1,dp);
        if(amount-coins[idx]>=0){
            count+=solve(amount-coins[idx],coins,idx,dp);
        }
        return dp[amount][idx] = count;
    }
}