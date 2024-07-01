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
    public boolean f(TreeNode root , TreeNode find){
        if(root==null)return false;
        if(root == find){
            return true;
        }
        return f(root.left , find)||f(root.right , find);
    }
    TreeNode ans = null;
    public void bfs(TreeNode root , TreeNode a , TreeNode b){
        if(root == null)return;
        if(f(root , a) && f(root , b)){
            ans = root;
        }
        bfs(root.left , a ,b );
        bfs(root.right ,a , b);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        bfs(root , p ,q );
        return ans;
    }
}