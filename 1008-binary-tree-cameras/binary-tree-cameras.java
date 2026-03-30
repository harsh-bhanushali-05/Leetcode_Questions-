class Solution {
    // CHANGE 1: Added a cache. Top-down recursion requires this to pass LeetCode without a Time Limit Exceeded error.
    HashMap<String, Integer> memo = new HashMap<>();

    public int minCameraCover(TreeNode root) {
        return f(1, root, 0);
    }

    public int f(int parent, TreeNode root, int cov) {
        if(root == null){
            // CHANGE 2: If the parent demands a camera (parent == 0), a null node cannot provide it. 
            // We return a massive number (99999) to invalidate this path.
            return parent == 0 ? 99999 : 0;
        }

        String key = parent + "," + root.hashCode() + "," + cov;
        if(memo.containsKey(key)) return memo.get(key);

        // CHANGE 3: We must ALWAYS calculate the cost of placing a camera, even if covered.
        // This is your exact original line of code.
        int place = 1 + f(2, root.left, 1) + f(2, root.right, 1);
        int result = 0;

        if(parent == 0){
            // we have to add here 
            result = place;
        }
        else if(cov == 1){
            // parent has the camera 
            // CHANGE 4a: We take the Math.min between skipping (your original code) and placing.
            int skip = f(1, root.left, 0) + f(1, root.right, 0);
            result = Math.min(place, skip);
        }
        else if(cov == 0 && parent == 1){
            // CHANGE 4b: Your original code f(0...)+f(0...) forced BOTH children to place cameras.
            // We only need ONE child to place a camera to cover this node.
            int forceLeft = f(0, root.left, 0) + f(1, root.right, 0);
            int forceRight = f(1, root.left, 0) + f(0, root.right, 0);
            
            result = Math.min(place, Math.min(forceLeft, forceRight));
        }

        memo.put(key, result);
        return result;
    }
}