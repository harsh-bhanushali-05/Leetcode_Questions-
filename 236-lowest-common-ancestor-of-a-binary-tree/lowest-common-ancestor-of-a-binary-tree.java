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
    public boolean find(TreeNode root , TreeNode req ){
        if(root == null )return false;
        if(root == req )return true;
        return find(root.left , req ) || find(root.right , req );
    }
    public TreeNode ret(TreeNode curr , TreeNode a , TreeNode b ){
        if(curr == null)return null;
        boolean one = find(curr , a );
        boolean two = find(curr , b );
        TreeNode left = ret(curr.left , a , b );
        TreeNode right = ret(curr.right , a, b);
        if(left!= null)return left;
        if(right!=null)return right; 
        if(one && two )return curr;
        return null;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return ret(root , p , q );
    }
}