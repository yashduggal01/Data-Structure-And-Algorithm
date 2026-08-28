class Solution {
    public int lengthOfLongestSubstring(String s) {
        // int mlength = 0;
        // for(int i =0;i<s.length();i++){
        //     HashSet<Character> set = new HashSet<>();
        //     int count = 0;
        //     for(int j = i;j<s.length();j++){
        //         if(set.contains(s.charAt(j))) break;
        //         set.add(s.charAt(j));
        //         count++;
        //     }
        //     mlength = Math.max(count,mlength);
        // }
     int left = 0;
     int right = 0;
     HashSet<Character> set = new HashSet<>();
     int mlength = 0;
     int n = s.length();
     while(right<n){
        while(set.contains(s.charAt(right))&&left<n){
            set.remove(s.charAt(left));
            left++;
        }
        set.add(s.charAt(right));
        mlength = Math.max(mlength,right-left+1);
        right++;
     }
     return mlength;
    }
}