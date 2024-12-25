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
    public void f(int level , List<Integer> list , TreeNode root){
        if(root == null )return;
        if(list.size() <=level ){
            list.add(root.val);
        }
        else{
            int val = Math.max(root.val , list.get(level));
            list.set(level , val);
        }
        f(level +1 , list ,root.left);
        f(level +1 , list ,root.right);
    }
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        f(0 , list , root);
        return list;
    }
}