class Solution {
    public int lengthOfLongestSubstring(String s) {
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