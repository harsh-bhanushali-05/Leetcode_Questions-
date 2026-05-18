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
    public void inorder(TreeNode root , List<Integer> list ){
        if(root == null){
            return; 
        }
        inorder(root.left , list);
        list.add(root.val);
        inorder(root.right , list);
    }
    public TreeNode f(List<Integer> list , int start , int end ){
        if(end < start ){
            return null; 
        }
        if(end == start ){
            return new TreeNode(list.get(end));
        }
        int mid = start + (end - start) / 2;
        TreeNode curr = new TreeNode(list.get(mid));
        curr.left = f(list , start , mid -1 );
        curr.right = f(list , mid+1 , end);
        return curr; 
    }
    public TreeNode balanceBST(TreeNode root) {
      // this is essentially re-rooting the subtree to fix the issue 
      List<Integer> list = new ArrayList<>(); 
      inorder(root , list);
      return f(list , 0 , list.size()-1);
    }
}