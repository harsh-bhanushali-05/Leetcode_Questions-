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
    public int f(TreeNode root , int max){
        if(root==null)return 0;
        int ans =0;
        if(root.val >=max){
            ans++;
        }
        ans+=(f(root.left,Math.max(max , root.val))+f(root.right , Math.max(max , root.val)));
        return ans;
    }
    public int goodNodes(TreeNode root) {
        return f(root , Integer.MIN_VALUE);
    }
}