import java.util.*;

class Solution {
    
    // YOUR EXACT LOGIC, JUST USING A MAP INSTEAD OF A LIST
    public TreeNode f(Map<Integer, TreeNode> map, TreeNode root ){
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            // This is the leaf node -> search in the MAP in O(1) time
            if (map.containsKey(root.val)) {
                TreeNode curr = map.get(root.val);
                map.remove(root.val); // O(1) removal
                return f(map, curr);
            }
            return root;
        }
        TreeNode left = f(map, root.left);
        TreeNode right = f(map, root.right);
        root.left = left; 
        root.right = right;
        return root;
    }

    public TreeNode canMerge(List<TreeNode> trees) {
        if (trees.size() == 1) {
            return isValidBST(trees.get(0), Long.MIN_VALUE, Long.MAX_VALUE) ? trees.get(0) : null;
        }
        
        HashSet<Integer> leaves = new HashSet<>();
        Map<Integer, TreeNode> map = new HashMap<>(); // NEW: Create a HashMap
        
        // 1. Find all leaves AND populate the HashMap
        for (TreeNode t : trees) {
            addLeaves(t, leaves); 
            map.put(t.val, t); 
        }

        // 2. Find the true starting root
        TreeNode startRoot = null;
        for (TreeNode t : trees) {
            if (!leaves.contains(t.val)) {
                startRoot = t;
                break;
            }
        }

        if (startRoot == null) return null;

        // Remove the starting root from the map so we don't merge it into itself
        map.remove(startRoot.val); 

        // 3. Call your 'f' function using the MAP
        TreeNode ans = f(map, startRoot);

        // 4. Check if we used all trees (map is empty) AND if the final tree is a valid BST
        if (!map.isEmpty() || !isValidBST(ans, Long.MIN_VALUE, Long.MAX_VALUE)) {
            return null;
        }

        return ans;
    }

    // --- YOUR EXACT HELPER METHODS ---

    private void addLeaves(TreeNode root, HashSet<Integer> leaves) {
        if (root == null) return;
        if (root.left == null && root.right == null) leaves.add(root.val);
        addLeaves(root.left, leaves);
        addLeaves(root.right, leaves);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}