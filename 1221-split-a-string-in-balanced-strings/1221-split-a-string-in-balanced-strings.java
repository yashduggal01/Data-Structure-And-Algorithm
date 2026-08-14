class Solution {
    public int balancedStringSplit(String s) {
        int count = 0;
        int curr = 0;
        for(char c : s.toCharArray()){
            if(c=='R') curr++;
            if(c=='L') curr--;
            if(curr==0) count++;
        }
        return count;
    }
}