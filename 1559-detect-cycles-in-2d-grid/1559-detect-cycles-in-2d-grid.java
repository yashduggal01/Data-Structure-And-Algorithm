class Solution {
    static class Pair{
        int cr;
        int cc;
        int pr;
        int pc;
        Pair(int cr , int cc , int pr , int pc){
            this.cr = cr;
            this.cc = cc;
            this.pr = pr;
            this.pc = pc;
        }
    }
    public boolean containsCycle(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] vis = new boolean[row][col];
        for(int i = 0;i<row ;i++){
            for(int j = 0;j<col;j++){
                if(!vis[i][j]){
                    if(bfs(grid,vis,i,j,grid[i][j])){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    static boolean bfs(char[][] grid , boolean[][] vis , int i , int j , char prev){
        vis[i][j] = true;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(i,j,-1,-1));
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};
        while(!q.isEmpty()){ 
            Pair p = q.poll();
            int cr = p.cr;
            int cc = p.cc;
            int pr = p.pr;
            int pc = p.pc;
            for(int k = 0;k<4;k++){
                int nr = cr+dr[k];
                int nc = cc+dc[k];
                if(nr>=0&&nc>=0&&nr<grid.length&&nc<grid[0].length&&grid[nr][nc]==prev){
                    if(!vis[nr][nc]){
                        vis[nr][nc] = true;
                        q.offer(new Pair(nr,nc,cr,cc));
                    }
                    else{
                        if(nr!=pr||nc!=pc){
                            return true;
                        }
                        else{
                            continue;
                        }
                    }
                }
            }
        }
        return false;
    }
}