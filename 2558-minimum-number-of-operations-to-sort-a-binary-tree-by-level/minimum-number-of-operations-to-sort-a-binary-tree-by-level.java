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
    public void f(int level , HashMap<Integer , List<Integer>> map , TreeNode root ){
        if(root == null )return;
        if(map.containsKey(level) == false){
            map.put(level , new ArrayList<>());
        }
        map.get(level).add(root.val);
        f(level +1 , map , root.left);
        f(level +1 , map , root.right);
    }
    public int ans(List<Integer> list){
        List<Integer> sorted = new ArrayList<>(list);
        Collections.sort(sorted);
        HashMap<Integer , Integer > map = new HashMap<>(); // value , index
        for(int i = 0 ; i < list.size() ; i++){
            map.put(list.get(i) , i );
        }
        int ret =0;
        for(int i = 0 ; i < list.size() ; i++){
            if(list.get(i) == sorted.get(i)){
                continue;
            }
            else{
                int change = map.get(sorted.get(i)); // this is the index of the required element 
                map.put(list.get(i), change);
                list.set(change , list.get(i));
                ret++;
            }
        }
        return ret;

    }
    public int minimumOperations(TreeNode root) {
        HashMap<Integer , List<Integer>> map = new HashMap<>(); 
        f(0 , map , root );
        int ret = 0;
        for(int key : map.keySet()){
            ret+=ans(map.get(key));
        }
        return ret;
    }
}