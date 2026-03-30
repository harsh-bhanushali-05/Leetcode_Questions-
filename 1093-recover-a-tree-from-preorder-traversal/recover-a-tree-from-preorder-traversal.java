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
    public TreeNode recoverFromPreorder(String traversal) {
        HashMap<Integer , TreeNode> map = new HashMap<>(); 
        int i = 0 ;
        while(i < traversal.length() && traversal.charAt(i)!='-'){
            i++;
        }
        map.put(0 , new TreeNode(Integer.parseInt(traversal.substring(0,i))));
        int curr = 0; 
        for(;  i < traversal.length() ; i++){
            if(traversal.charAt(i) == '-'){
                curr++;
            }
            else{
                int c = 0;
                int temp = i;
                while(i < traversal.length() &&  traversal.charAt(i)!='-'){
                    c++;
                    i++;
                }
                i--;
                int val = 0;
                
                if(i == traversal.length()){
                    val = Integer.parseInt(traversal.substring(temp,i));
                }
                val = Integer.parseInt(traversal.substring(temp,i+1));
                if(map.get(curr-1).left == null){
                    map.get(curr-1).left = new TreeNode(val);
                    map.put(curr , map.get(curr-1).left );
                }
                else{
                    map.get(curr-1).right = new TreeNode(val);
                    map.put(curr , map.get(curr-1).right );
                }
                curr = 0;
            }
        }
        return map.get(0);
    }
}