class SmallestInfiniteSet {
    int cmin ;
    TreeSet<Integer> set;
    public SmallestInfiniteSet() {
        cmin = 1;
        set = new TreeSet<>();
    }
    
    public int popSmallest() {
        if(!set.isEmpty()){
            return set.pollFirst();
        }
        return cmin++;
    }
    
    public void addBack(int num) {
        if(num<cmin){
            set.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */