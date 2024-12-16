class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        // change the smallest value 
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> nums[a] - nums[b]==0 ? a-b : nums[a] - nums[b]); 
        for(int i = 0 ; i <nums.length ; i++){
            pq.offer(i);
        }
        while(k -- > 0 ){
            int curr= pq.poll(); 
            nums[curr]*=multiplier;
            pq.offer(curr);
        }
        return nums;
    }
}