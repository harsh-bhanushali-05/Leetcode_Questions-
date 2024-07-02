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
    public TreeNode rightMost(TreeNode root){
        if(root.right == null)return root;
        return rightMost(root.right);
    }
    public void f(TreeNode root){
        if(root == null )return ;
        if(root.left!=null){
        TreeNode temp = rightMost(root.left);
        temp.right = root.right;
        root.right = root.left;
        }
        root.left = null;
        f(root.right);
    }
    public void flatten(TreeNode root) {
        f(root);
    }
}