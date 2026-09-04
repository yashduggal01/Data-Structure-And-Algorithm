class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int csum = 0 ; 
        int count = 0;
        map.put(0,1);
        for(int i = 0;i<nums.length;i++){
            csum+=nums[i];
            if(map.containsKey(csum-k)){
                count+=map.get(csum-k);
            }
            map.put(csum,map.getOrDefault(csum,0)+1);
        }
        return count;
    }
}