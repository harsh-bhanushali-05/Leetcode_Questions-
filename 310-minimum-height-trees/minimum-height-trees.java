import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // Special case: if there's only one node
        if (n == 1) {
            return Collections.singletonList(0);
        }

        // Step 1: Build the adjacency list and calculate degrees
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] degree = new int[n];
        
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        // Step 2: Initialize the queue with all leaf nodes (degree == 1)
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }

        // Step 3: Perform BFS-like trimming of leaf nodes
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result = new ArrayList<>(); // Reset result to store the current level
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                result.add(node); // Add current leaf to the result
                for (int neighbor : map.get(node)) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) { // If it becomes a leaf, add to queue
                        queue.offer(neighbor);
                    }
                }
            }
        }

        // Step 4: Return the last level of nodes as MHT roots
        return result;
    }
}