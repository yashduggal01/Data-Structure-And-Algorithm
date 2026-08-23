class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[][] matrix = new int[n+1][2];
        for(int i = 0 ; i<n;i++){
            matrix[i] = intervals[i];
        }
        matrix[n] = newInterval;
        Arrays.sort(matrix,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> list = new ArrayList<>();
        list.add(matrix[0]);
        for(int i = 1;i<n+1;i++){
            int[] curr = matrix[i];
            int[] last = list.get(list.size()-1);
            if(curr[0]>last[1]){
                list.add(curr);
            }
            else{
                last[1] = Math.max(last[1],curr[1]);
            }
        }
        int len = list.size();
        int[][] res = new int[len][2];
        for(int i =0;i<len;i++){
            res[i] = list.get(i);
        }
        return res;
    }
}