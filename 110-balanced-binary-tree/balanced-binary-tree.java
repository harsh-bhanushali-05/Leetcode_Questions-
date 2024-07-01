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
    boolean ans = true;
    public int f(TreeNode root){
        if(root==null)return 0;
        int left = f(root.left);
        int right = f(root.right);
        if(Math.abs(left-right)>1){
            ans=false;
        }
        return Math.max(left , right)+1;
    }
    public boolean isBalanced(TreeNode root) {
        f(root);
        return ans;
    }
}