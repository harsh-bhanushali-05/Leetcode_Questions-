class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize != 0 )return false;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : hand)
            pq.offer(i);
        while(pq.isEmpty()==false){
            int x = pq.poll();
            for(int i = 0 ; i < groupSize-1 ; i++){
                if(pq.remove(x+1)==false)return false;
                x++;
            }
        }
        return true;
    }
}