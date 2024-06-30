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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null)return list;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        TreeNode curr = root;
        while(st.isEmpty() == false || curr!=null){
            if(curr!=null){
                list.add(curr.val);
                if(curr.left!=null)
                    st.push(curr.left);
                curr = curr.left;
            }
            else{
                curr = st.pop();
                if(curr.right!=null)
                    st.push(curr.right);
                curr = curr.right;
            }
        }
        return list;
    }
}