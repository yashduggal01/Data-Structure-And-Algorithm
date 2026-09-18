class Solution {
    public int climbStairs(int n) {
        if(n<=1){
            return 1;
        }
        // int[] dp = new int[n+1]; // Storing the state for 0 to n steps.
        int a = 1;
        int b = 1;
        for(int i = 2;i<=n;i++){
          int c = a+b;
          a=b;
          b = c;
        }
        return b;
    }
}