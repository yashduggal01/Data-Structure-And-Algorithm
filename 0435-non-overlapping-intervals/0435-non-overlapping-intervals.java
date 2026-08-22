class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int prev = Integer.MIN_VALUE;
        int count = 0;
        for(int[] arr : intervals){
            if(prev==Integer.MIN_VALUE || arr[0]>=prev){
                count++;
                prev = arr[1];
            }
            else{
                continue;
            }
        }
        return n-count;
    }
}