class NumArray {
    private int[] segmentTree;
    private int n;

    public NumArray(int[] nums) {
        n = nums.length;
        if (n > 0) {
            segmentTree = new int[2 * n];
            buildTree(nums);
        }
    }

    private void buildTree(int[] nums) {
        // Insert leaf nodes in the second half of the segment tree array
        for (int i = 0; i < n; i++) {
            segmentTree[n + i] = nums[i];
        }
        // Build the rest of the tree by calculating the sum of child nodes
        for (int i = n - 1; i > 0; i--) {
            segmentTree[i] = segmentTree[2 * i] + segmentTree[2 * i + 1];
        }
    }

    public void update(int index, int val) {
        // Update the value in the leaf node
        index += n;
        segmentTree[index] = val;
        // Recalculate the sum for parent nodes
        while (index > 1) {
            index /= 2;
            segmentTree[index] = segmentTree[2 * index] + segmentTree[2 * index + 1];
        }
    }

    public int sumRange(int left, int right) {
        // Query the sum in the range [left, right]
        left += n;
        right += n;
        int sum = 0;
        while (left <= right) {
            // If left is a right child, take it into the sum and move to the next node
            if ((left % 2) == 1) {
                sum += segmentTree[left];
                left++;
            }
            // If right is a left child, take it into the sum and move to the previous node
            if ((right % 2) == 0) {
                sum += segmentTree[right];
                right--;
            }
            // Move to the next level in the tree
            left /= 2;
            right /= 2;
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */