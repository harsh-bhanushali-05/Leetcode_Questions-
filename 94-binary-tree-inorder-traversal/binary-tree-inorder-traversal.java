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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null)return list;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        TreeNode curr = root;
        while(st.isEmpty()==false || curr!=null ){
            if(curr!=null){
                if(curr.left!=null){
                    st.push(curr.left);
                }
                curr = curr.left;
                continue;
            }
            else{
               curr = st.pop();
               list.add(curr.val);
               if(curr.right!=null)
                st.push(curr.right); 
                curr = curr.right;
            }
        }
        return list;
    }
}