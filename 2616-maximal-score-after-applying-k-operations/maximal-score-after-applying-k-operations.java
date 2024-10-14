class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        long score = 0;
        for(int i : nums )
            pq.offer(i);
        for(int i = 0 ; i< k ; i++){
            int n = pq.poll();
            score+=n;
            if(n%3 == 0 )
                pq.offer(n/3);
            else
                pq.offer(n/3 +1 );
        }
        return score;
    }
}