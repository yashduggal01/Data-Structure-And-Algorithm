class Solution {
    static int[][] dp ;
    public int longestIncreasingPath(int[][] matrix) {
        int mpath = 1;
        int m = matrix.length;
        int n = matrix[0].length;
        dp = new int[m+1][n+1];
        for(int[] d : dp){
            Arrays.fill(d,-1);
        }
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                mpath = Math.max(mpath, solve(matrix,i,j,m,n,-1));
            }
        }
        return mpath;
    }
    static int solve(int[][] matrix , int i ,int j ,int m , int n ,int prev){
        if(i<0||j<0||i>=m||j>=n||matrix[i][j]<=prev) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int left =  1 + solve(matrix,i,j-1,m,n,matrix[i][j]);
        int right = 1 + solve(matrix,i,j+1,m,n,matrix[i][j]);
        int up = 1+ solve(matrix,i-1,j,m,n,matrix[i][j]);
        int down = 1+solve(matrix,i+1,j,m,n,matrix[i][j]);
        return dp[i][j] = Math.max(Math.max(left,right),Math.max(up,down));
    }

}