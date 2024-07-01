/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class pair{
        int value , level;
        pair(int value , int level){
            this.value = value;
            this.level = level;
        }
    }
    public void f(TreeMap<Integer , List<pair>> map , TreeNode root , int x , int level){
        if(root == null)return;
        if(map.containsKey(x)==false){
            map.put(x,new ArrayList<>());
        }
        map.get(x).add(new pair(root.val , level));
        f(map , root.left , x-1 ,level+1);
        f(map , root.right , x+1 ,level+1);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer , List<pair>> map = new TreeMap<>();
        f(map , root, 0 ,1 );
        List<List<Integer>> ans = new ArrayList<>();
        for(int i : map.keySet()){
            List<Integer> sub = new ArrayList<>();
            Collections.sort(map.get(i) , (a , b)-> a.level==b.level? a.value - b.value:a.level-b.level);
            for(pair temp : map.get(i)){
                sub.add(temp.value);
            }
            ans.add(new ArrayList<>(sub));
        }
        return ans;
    }
}