class Solution {
    public int minInsertions(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int[] d : dp){
            Arrays.fill(d,Integer.MAX_VALUE);
        }
        return solve(s,0,s.length()-1 , dp);
    }
    public int solve(String s , int left , int right , int[][] dp){
        if(left>=right){
            return 0;
        }
        if(dp[left][right]!=Integer.MAX_VALUE){
            return dp[left][right];
        }
        if(s.charAt(left)==s.charAt(right)){
            return dp[left][right] = solve(s,left+1,right-1,dp);
        }
        else{
            int op1 = 1+solve(s,left,right-1,dp);
            int op2 = 1+solve(s,left+1,right,dp);
            return dp[left][right] = Math.min(op1,op2);
        }

    }
}