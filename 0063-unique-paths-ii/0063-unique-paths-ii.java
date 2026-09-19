class Solution {
    static int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
     
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
           if(obstacleGrid[0][0]==1||obstacleGrid[row-1][col-1]==1) return 0;
        dp = new int[row+1][col+1];
        dp[1][1]=1;
        for(int i = 1; i<=row;i++){
            for(int j =1;j<=col;j++){
                if(i==1&&j==1) continue;
               if(obstacleGrid[i-1][j-1]==1) continue;
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[row][col];
    }
}