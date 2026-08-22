class Solution {
    static class Pair{
        int e;
        int p;
        Pair(int e , int p){
            this.e =e;
            this.p = p;
        }
    }
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            if(a.e!=b.e){
                return Integer.compare(a.e,b.e);
            }
            else{
                return Integer.compare(a.p,b.p);
            }
        });
        for(int[] arr : trips){
            int pass = arr[0];
            int s = arr[1];
            int e = arr[2];
            pq.offer(new Pair(s,pass));
            pq.offer(new Pair(e,-pass));
        }
        int curr = 0;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int pass = p.p;
            if(curr+pass<=capacity){
                curr+=pass;
            }
            else{
                return false;
            }
        }
        return true;
    }
}