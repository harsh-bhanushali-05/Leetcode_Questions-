/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode f(TreeNode root , TreeNode a , TreeNode b ){
        if(root == null )return null;
        if( (root.val <= a.val && root.val >= b.val)||(root.val >= a.val && root.val <= b.val))return root;
        if(root.val <= a.val || root.val <= b.val){
            return f(root.right , a , b );
        }
        return f(root.left , a , b);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return f(root , p , q );
    }
}