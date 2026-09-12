class Solution {
    public long totalCost(int[] cost, int k, int candidates) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        int left = 0;
        int right = cost.length-1;
        while(left<candidates&&left<=right){
            pq1.offer(cost[left++]);
        }
        while(right>=cost.length-candidates&&left<=right){
            pq2.offer(cost[right--]);
        }
        long tcost = 0;
        while(k>0){
            int lval = pq1.isEmpty()?Integer.MAX_VALUE:pq1.peek();
            int rval = pq2.isEmpty()?Integer.MAX_VALUE:pq2.peek();
            if(lval<=rval){
                tcost+=pq1.poll();
                if(left<=right){
                pq1.offer(cost[left++]);
                }
            }
            else{
                tcost+=pq2.poll();
                if(left<=right){
                    pq2.offer(cost[right--]);
                }
            }
            k--;
        }
        return tcost;
    }
}