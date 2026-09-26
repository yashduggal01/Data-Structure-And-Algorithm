class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(s,0,dp);
    }
    public int solve(String s ,int idx, int[] dp){
        if(idx==s.length()){
            return 1;
        }
        if(s.charAt(idx)=='0'){
            return 0 ;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int count = solve(s,idx+1,dp);
        if(idx+1<s.length()){
            if(s.charAt(idx)=='1'||(s.charAt(idx)=='2'&&s.charAt(idx+1)<='6')){
                count+=solve(s,idx+2,dp);
            }
        }
        return dp[idx]=count;
    }
}