class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] pair = new int[nums1.length][2];
        for(int i = 0 ; i<nums2.length;i++){
            pair[i][0] = nums1[i];
            pair[i][1]=nums2[i];
        }
        Arrays.sort(pair,(a,b)->Integer.compare(b[1],a[1]));
        long csum = 0;
        long mscore = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] p : pair){
            int val1 = p[0];
            int val2  = p[1];
            csum += val1;
            pq.offer(val1);
            if(pq.size()>k){
                csum -= pq.poll();
            }
            if(pq.size()==k){
                mscore = Math.max(mscore,csum*val2);
            }
        }
        return mscore;
    }
}