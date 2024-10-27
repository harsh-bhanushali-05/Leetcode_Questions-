class Solution {
    public int arrangeCoins(int n) {
        int left = 0, right = n;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long coins = (long) mid * (mid + 1) / 2; // Use long to prevent overflow
            
            if (coins == n) {
                return mid; // exact match
            } else if (coins < n) {
                left = mid + 1; // search in the right half
            } else {
                right = mid - 1; // search in the left half
            }
        }
        
        return right;
    }
}