import java.util.*;

class Solution {
    public void dfs(String node, Map<String, List<String>> adj, List<String> ans) {
        Collections.sort(adj.getOrDefault(node , new ArrayList<>()), Collections.reverseOrder());
        while (adj.containsKey(node) && !adj.get(node).isEmpty()) {
            String temp = adj.get(node).remove(adj.get(node).size() - 1);
            dfs(temp, adj, ans);
        }
        ans.add(node);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> adj = new HashMap<>();
        for (List<String> ticket : tickets) {
            adj.putIfAbsent(ticket.get(0), new ArrayList<>());
            adj.get(ticket.get(0)).add(ticket.get(1));
        }
        List<String> ans = new ArrayList<>();
        dfs("JFK", adj, ans);
        Collections.reverse(ans);
        return ans;
    }
}