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
    int ans = Integer.MIN_VALUE ; 
    public int f(TreeNode root ){
        if(root == null )return 0;
        int left = f(root.left);
        int right = f(root.right);
        ans = Math.max(Math.max(right , 0 ) + Math.max(left , 0 ) + root.val , ans);
        return Math.max(Math.max(left , right ), 0 ) + root.val;
    }
    public int maxPathSum(TreeNode root) {
        f(root);
        return ans;
    }
}