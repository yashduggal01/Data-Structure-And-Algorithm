class Solution {
    static int[][] dp ;
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        dp = new int[l1+1][l2+1];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        return solve(word1,word2,0,0);
    }
    static int solve(String s1 , String s2 , int i , int j){
        if(i==s1.length()) return s2.length()-j;
        if(j==s2.length()) return s1.length()-i;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) return solve(s1,s2,i+1,j+1);
        int insert = solve(s1,s2,i+1,j);
        int delete = solve(s1,s2,i,j+1);
        int replace =solve(s1,s2,i+1,j+1);
        return dp[i][j] = 1+Math.min(insert,Math.min(delete,replace));
    }
}