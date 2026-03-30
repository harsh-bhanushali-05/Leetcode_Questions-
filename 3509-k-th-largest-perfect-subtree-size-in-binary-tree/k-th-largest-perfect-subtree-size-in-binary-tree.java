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
    int num;
    PriorityQueue<Integer> minHeap;
    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        num = Integer.MIN_VALUE / 2;
        minHeap = new PriorityQueue<>();

        traverse(root, k);

        if(minHeap.size() < k) return -1;
        return minHeap.peek();
    }

    public int traverse(TreeNode root, int k) {
        if(root == null) return 0;

        int left = traverse(root.left, k);
        int right = traverse(root.right, k);

        int total = left + right + 1;

        if(left == right) {
            minHeap.offer(total);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
            return total;
        }

        return --num;
    }
}