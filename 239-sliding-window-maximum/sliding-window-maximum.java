class Solution {
    class pair{
        int index;
        int value;
        public pair(int index , int value ){
            this.index = index;
            this.value = value;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)->b.value - a.value);
        for(int i = 0 ; i < k-1 ; i++){
            pq.offer(new pair(i , nums[i]));
        }
        int ans[] = new int[nums.length - k +1];
        for(int i = 0 ;i < ans.length ; i++){
            pq.offer(new pair(i+k-1 , nums[i+k-1]));
            while(pq.peek().index < i){
                pq.poll();
            }
            ans[i] = pq.peek().value;
        }
        return ans;
    }
}