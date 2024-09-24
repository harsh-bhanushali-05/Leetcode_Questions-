class Solution {
    public class Pair {
        long time;  // Use long for time
        long mul;   // Use long for multiplier
        Pair(long time, long mul) {
            this.time = time;
            this.mul = mul;
        }
    }

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        // Priority queue to sort based on current work rate, ensuring no overflow
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> 
            Long.compare(a.time * (a.mul * (a.mul + 1) / 2), b.time * (b.mul * (b.mul + 1) / 2))
        );

        // Initialize the queue with all workers, each with multiplier 1
        for (int i : workerTimes) {
            pq.offer(new Pair((long) i, 1));  // Cast workerTimes[i] to long
        }

        long max = Long.MIN_VALUE;  // Track the maximum time taken by any worker

        // Assign tasks until the mountain height is reduced to 0
        while (mountainHeight > 0) {
            Pair x = pq.poll();  // Get the worker who can complete the next task the fastest
            long currTime = x.mul * x.time;  // Calculate the time spent by this worker
            
            // Update the max time taken by any worker during any task
            max = Math.max(max, x.time * (x.mul * (x.mul + 1) / 2));
            
            // Reinsert the worker with incremented multiplier, indicating they've completed another task
            pq.offer(new Pair(x.time, x.mul + 1));
            
            mountainHeight--;  // Reduce the mountain height
        }

        return max;  // Return the maximum time it took for any single task
    }
}