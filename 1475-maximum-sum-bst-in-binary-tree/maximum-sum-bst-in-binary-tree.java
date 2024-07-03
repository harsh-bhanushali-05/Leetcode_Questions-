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
    int ans = 0;

    class Result {
        boolean isBST;
        int sum;
        int min;
        int max;

        Result(boolean isBST, int sum, int min, int max) {
            this.isBST = isBST;
            this.sum = sum;
            this.min = min;
            this.max = max;
        }
    }

    public Result helper(TreeNode root) {
        if (root == null) {
            return new Result(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Result left = helper(root.left);
        Result right = helper(root.right);

        if (left.isBST && right.isBST && root.val > left.max && root.val < right.min) {
            int sum = left.sum + right.sum + root.val;
            ans = Math.max(ans, sum);
            int min = Math.min(root.val, left.min);
            int max = Math.max(root.val, right.max);
            return new Result(true, sum, min, max);
        } else {
            return new Result(false, 0, 0, 0);
        }
    }

    public int maxSumBST(TreeNode root) {
        helper(root);
        return ans;
    }
}