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
    public void f(int level , TreeNode root , HashMap<Integer , List<Integer>> map ){
        if(root == null)return; 
        if(map.containsKey(level) == false){
            map.put(level , new ArrayList<>());
        }
        map.get(level).add(root.val); 
        // if(level%2==0){
        //     // this level is odd next wala reverse hona chaiyeh 
        //     f(level +1 , root.right , map );
        //     f(level+1 , root.left , map ); 
        // }
        // else{
            f(level+1 , root.left , map ); 
            f(level+1 , root.right , map ); 
        // }
    }
    public void val(TreeNode root , int level , HashMap<Integer , List<Integer>> map ){
        if(root == null)return;
        root.val = map.get(level).get(0);
        map.get(level).remove(0);
        val(root.left , level +1 , map );
        val(root.right , level +1 , map );
    }
    public TreeNode reverseOddLevels(TreeNode root) {
        HashMap<Integer , List<Integer>> map = new HashMap<>();
        f(0 , root , map ); 
        for(int key : map.keySet()){
            if(key %2==1){
                Collections.reverse(map.get(key));
            }
        }
        val(root , 0 , map );
        return root;
    }
}