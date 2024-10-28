class Solution {
    public int mySqrt(int x) {
        int i = 0;
        int j = x;
        while (j >= i) {
            int mid = i + (j - i) / 2;
            long square = (long) mid * mid; // cast to long to prevent overflow

            if (square == x) return mid;
            if (square > x) j = mid - 1;
            else i = mid + 1;
        }
        return j;
    }
}