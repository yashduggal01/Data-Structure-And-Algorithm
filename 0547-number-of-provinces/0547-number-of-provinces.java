class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> graph = new ArrayList<>();
        int n = isConnected.length;
        for(int i = 0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(isConnected[i][j]==1){
                    graph.get(i).add(j);
                }
            }
        }
        boolean[] vis = new boolean[n];
        int count = 0;
        for(int i = 0;i<n;i++){
            if(!vis[i]){
                count++;
                solve(graph,i,vis);
            }
        }
        return count;
    }
    static void solve(List<List<Integer>> graph , int node,boolean[] vis){
        vis[node] = true;
        for(int neigh : graph.get(node)){
            if(!vis[neigh]){
                solve(graph,neigh,vis);
            }
        }
    }
}