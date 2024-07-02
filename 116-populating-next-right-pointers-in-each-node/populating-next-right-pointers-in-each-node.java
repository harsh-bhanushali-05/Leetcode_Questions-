/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public void f(HashMap<Integer, List<Node>> map , Node root , int level){
        if(root==null)return;
        if(map.containsKey(level)==false)map.put(level , new ArrayList<>());
        map.get(level).add(root);
        f(map , root.left , level+1);
        f(map, root.right , level+1);
    }
    public Node connect(Node root) {
        HashMap<Integer , List<Node>> map = new HashMap<>();
        f(map , root , 1);
        for(int i : map.keySet()){
            for(int j = 0; j < map.get(i).size()-1 ; j++){
                map.get(i).get(j).next = map.get(i).get(j+1);
            }
        }
        return root;
    }
}