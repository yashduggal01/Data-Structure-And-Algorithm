class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int mday = days[n-1];
        int[] dp = new int[mday+1];
        Arrays.fill(dp,-1);
        boolean[] vis = new boolean[mday+1];
        for(int day : days){
            vis[day] = true;
        }
        return solve(days,costs,1,vis,dp);
    }
    public int solve(int[] days , int[] cost , int idx,boolean[] vis, int[] dp){
        if(idx>days[days.length-1]){
            return 0;
        }
        if(!vis[idx]){
            return solve(days,cost,idx+1,vis,dp);
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int d1 = cost[0]+solve(days,cost,idx+1,vis,dp);
        int d7 = cost[1]+solve(days,cost,idx+7,vis,dp);
        int d30 = cost[2]+solve(days,cost,idx+30,vis,dp);
        return dp[idx] = Math.min(d1,Math.min(d7,d30));
    }
}