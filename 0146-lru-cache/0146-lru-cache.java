class LRUCache {
    int capacity = 0;
    HashMap<Integer,Integer> map ;
    Queue<Integer> queue;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        queue = new LinkedList<>();
    }
    
    public int get(int key) {
      //  System.out.println(map);
        if(map.containsKey(key)){
            queue.remove(key);
            queue.offer(key);
            return map.get(key);

        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            queue.remove(key);
        }
        else if(map.size()==capacity){
            int ekey = queue.poll();
            map.remove(ekey);
        }
        map.put(key,value);
        queue.offer(key);
    }
}
