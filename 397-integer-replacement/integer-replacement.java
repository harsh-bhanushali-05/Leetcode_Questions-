class Solution {
    public int integerReplacement(int n) {
        if (n == 1) return 0;
        
        // Use Long to handle Integer.MAX_VALUE + 1
        Queue<Long> queue = new LinkedList<>();
        // Our "DP Table" is a Set to keep track of numbers we've already solved
        Set<Long> visited = new HashSet<>();
        
        queue.add((long)n);
        visited.add((long)n);
        
        int steps = 0;
        
        // This loop acts as our "Table Filling" mechanism level by level
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                long curr = queue.poll();
                
                if (curr == 1) return steps;
                
                if (curr % 2 == 0) {
                    long next = curr / 2;
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                } else {
                    // These are the two "sub-problems" for an odd number
                    long plus = curr + 1;
                    long minus = curr - 1;
                    
                    if (!visited.contains(plus)) {
                        visited.add(plus);
                        queue.add(plus);
                    }
                    if (!visited.contains(minus)) {
                        visited.add(minus);
                        queue.add(minus);
                    }
                }
            }
            steps++; // Move to the next "step" in our DP table
        }
        
        return steps;
    }
}