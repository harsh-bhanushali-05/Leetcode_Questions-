class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int size ;
    public KthLargest(int k, int[] nums) {
        // to get the largest value we need a min heap 
        size = k;
        for(int i : nums ){
        pq.offer(i);
        if(pq.size() > k )
            pq.poll();
        }
    }
    public int add(int val) {
        pq.offer(val);
        if(pq.size() > size )
            pq.poll();
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */