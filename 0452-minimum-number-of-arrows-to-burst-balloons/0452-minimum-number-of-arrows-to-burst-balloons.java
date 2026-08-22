class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points,(a,b)-> Integer.compare(a[1],b[1]));
        int arrow = 1;
        int placed = points[0][1];
        for(int i = 1 ;i<n;i++){
            int nstart = points[i][0];
            int nend = points[i][1];
            if(nstart>placed){
                arrow++;
                placed = nend;
            }
        }
        return arrow;
    }
}