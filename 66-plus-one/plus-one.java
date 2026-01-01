class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int index = digits.length-1;
        while(carry >0){
            if(index==-1){
                int ans[] = new int[digits.length+1]; 
                ans[0] = carry;
                for(int i = 0; i < digits.length ; i++){
                    ans[i+1] = digits[i];
                }
                return ans;
            }
            digits[index]++;
            carry = digits[index]/10;
            digits[index] = digits[index] %10;
            index--;
        }
        return digits;
    }
}