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
    public boolean f(TreeNode node , long max , long min ){
        if(node ==null)return true;
        if(node.val <=min || node.val>= max){
            return false;
        }
        return f(node.right , max , node.val) && f(node.left , node.val , min );
    }
    public boolean isValidBST(TreeNode root) {
        return f(root , (long)Integer.MAX_VALUE +2, (long)Integer.MIN_VALUE -2);
    }
}