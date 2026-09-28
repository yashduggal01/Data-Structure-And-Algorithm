class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[m+1][n+1][strs.length+1];
        for(int i = 0;i<m+1;i++){
            for(int j = 0;j<n+1;j++){
                for(int k = 0;k<strs.length+1;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return solve(strs,m,n,0,dp);
    }
    public int solve(String[] strs , int m ,int n , int idx,int[][][] dp){
        if(idx>=strs.length||m<0||n<0){
            return 0;
        }
        if(dp[m][n][idx]!=-1){
            return dp[m][n][idx];
        }
        int skip = solve(strs,m,n,idx+1,dp);
        int take = 0;
        int one = 0;
        for(char c : strs[idx].toCharArray()){
            if(c=='1'){
                one++;
            }
        }
        int zero = strs[idx].length()-one;
        if(m>=zero&&n>=one){
            take = 1 + solve(strs,m-zero,n-one,idx+1,dp);
        }
        return dp[m][n][idx] = Math.max(take,skip);
    }
}