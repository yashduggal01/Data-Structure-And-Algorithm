class Solution {
    public int maximumGain(String s, int x, int y) {
        int total = 0 ;
        String p1 = x>y?"ab":"ba";
        String p2 = x>y?"ba":"ab";
        int fs = Math.max(x,y);
        int ss = Math.min(x,y);
        StringBuilder sb1 = new StringBuilder();
        for(char c : s.toCharArray()){
            int len = sb1.length();
            if(len>0&&sb1.charAt(len-1)==p1.charAt(0)&&c==p1.charAt(1)){
                sb1.deleteCharAt(len-1);
                total+=fs;
            }
            else{
                sb1.append(c);
            }
        }
        StringBuilder sb2 = new StringBuilder();
        for(int i = 0;i<sb1.length();i++){
            char c = sb1.charAt(i);
            int len = sb2.length();
            if(len>0&&sb2.charAt(len-1)==p2.charAt(0)&&c==p2.charAt(1)){
                sb2.deleteCharAt(len-1);
                total+=ss;
            }
            else{
                sb2.append(c);
            }
        }
        return total;
    }
}