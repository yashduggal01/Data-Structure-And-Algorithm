class Solution {
    static class Pair{
        int r;
        int c ;
        int time ;
        Pair(int r , int c , int time){
            this.r=r;
            this.c=c;
            this.time = time;
        }
}
    public int orangesRotting(int[][] grid) {
        int mtime = 0;
        int row = grid.length;
        int col = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i,j,0));
                }
            }
        }
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int sr = p.r;
            int sc = p.c;
            int time = p.time;
            mtime = Math.max(mtime,time);
            for(int i = 0;i<4;i++){
                int nr = sr+dr[i];
                int nc = sc+dc[i];
                if(nr>=0&&nc>=0&&nr<row&&nc<col&&grid[nr][nc]==1){
                    grid[nr][nc] = 2;
                    q.offer(new Pair(nr,nc,time+1));
                }
                else{
                    continue;
                }
                }
        }
        for(int i=0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return mtime;
    }
}