class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        // int total = 0;
        // for (int len = low; len <= high; len++) {
        //     total += solve(zero, one, len);
        // }
        // return total;
        int mod = 1_000_000_007;
        int[] dp = new int[high+1];
        dp[0]=1;
        int tc = 0;
        for(int i = 1;i<=high;i++){
            if(i>=zero){
                dp[i] = (dp[i]+dp[i-zero])%mod;
            }
            if(i>=one){
                dp[i]=(dp[i]+dp[i-one])%mod;
            }
            if(i>=low){
                tc = (tc+dp[i])%mod;
            }
        }
        return tc;
    }
}

//     public int solve(int zero, int one, int len) {
//         List<String> strings = new ArrayList<>();
//         StringBuilder sb = new StringBuilder();
//         helper(zero, one, len, sb, strings, 0);
//         return strings.size();
//     }

//     public void helper(int zero, int one, int len, StringBuilder sb, List<String> list, int idx) {
//         if (idx > len) {
//             return;
//         }

//         if (idx == len) {
//             String s = sb.toString();
//             if (!list.contains(s)) {
//                 list.add(s);
//             }
//             return;
//         }

//         sb.append("0".repeat(zero));
//         helper(zero, one, len, sb, list, idx + zero);
//         sb.setLength(sb.length() - zero);

//         sb.append("1".repeat(one));
//         helper(zero, one, len, sb, list, idx + one);
//         sb.setLength(sb.length() - one);
//     }
// }