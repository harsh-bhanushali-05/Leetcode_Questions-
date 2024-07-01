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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)return ans;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(q.isEmpty()==false){
            int level = q.size();
            List<Integer> sub = new ArrayList<>();
            for(int i = 0 ; i < level ; i++){
                TreeNode temp = q.poll();
                sub.add(temp.val);
                if(temp.left != null)
                    q.offer(temp.left);
                if(temp.right != null)
                    q.offer(temp.right);
            }
            ans.add(new ArrayList<>(sub));
        }
        return ans;
    }
}