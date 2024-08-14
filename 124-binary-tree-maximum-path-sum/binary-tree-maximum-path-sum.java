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
    int ans = Integer.MIN_VALUE;
    public int f(TreeNode root){
        if(root == null)return 0;
        int right = f(root.right);
        int left = f(root.left);
        ans = Math.max(ans , Math.max(right , 0 ) + Math.max(left,0) + root.val );
        return Math.max(0,Math.max(right , left ))+root.val;
    }
    public int maxPathSum(TreeNode root) {
        f(root);
        return ans;
    }
}