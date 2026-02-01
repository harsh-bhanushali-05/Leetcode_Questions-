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
    int ans =Integer.MIN_VALUE;
    public int f(TreeNode root){
        if(root ==null){
            return 0; 
        }
        int left = f(root.left); 
        int right = f(root.right); 
        ans = Math.max(ans , left + right + root.val); 
        if(left+root.val < 0  && right+root.val < 0 ){
            return 0; 
        }
        if(left+root.val < 0 ){
            return root.val + right;
        }
        return Math.max(left , right) + root.val;
    }
    public int maxPathSum(TreeNode root) {
        f(root); 
        return ans;
    }
}