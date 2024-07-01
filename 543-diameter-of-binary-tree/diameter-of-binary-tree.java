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
    int ans = 0;
    public int f(TreeNode root){
        if(root==null)return 0;
        int right = f(root.right);
        int left = f(root.left);
        ans = Math.max(left + right , ans );
        return Math.max(left , right )+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        f(root);
        return ans ;
    }
}