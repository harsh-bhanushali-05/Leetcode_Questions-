/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public void f(Node node ,HashSet<Node> vis , HashMap<Node , Node> map ){
        if(vis.contains(node))return;
        vis.add(node);
        Node naya = new Node(node.val);
        map.put(node , naya);
        for(Node nbr : node.neighbors){
            f(nbr , vis , map);
        }
    }
    public void link(Node node ,HashMap<Node , Node> map ,HashSet<Node> vis){
        if(vis.contains(node))return;
        vis.add(node);
        for(Node nbr : node.neighbors){
            map.get(node).neighbors.add(map.get(nbr));
            link(nbr , map , vis);

        }
        // for(Node nbr : node.neighbors){
            // link(nbr , map , vis);
        // }
    }
    public Node cloneGraph(Node node) {
        if(node == null)return node;
        HashMap<Node , Node>  map = new HashMap<>(); // old , new node 
        HashSet<Node> vis = new HashSet<>();
        f(node , vis , map); // assigns old node to new node 
        link(node , map ,new HashSet<>());
        return map.get(node);
    }
}