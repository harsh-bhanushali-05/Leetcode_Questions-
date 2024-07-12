import java.util.*;

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        // Map to store the adjacency list
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        
        // Build the graph
        for (List<String> ticket : tickets) {
            map.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            map.get(ticket.get(0)).offer(ticket.get(1));
        }
        
        List<String> result = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        
        // Use iterative DFS to construct the path
        while (!stack.isEmpty()) {
            String node = stack.peek();
            if (map.containsKey(node) && !map.get(node).isEmpty()) {
                stack.push(map.get(node).poll());
            } else {
                result.add(0, stack.pop());
            }
        }
        
        return result;
    }
}