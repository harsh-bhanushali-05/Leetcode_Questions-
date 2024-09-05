class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int carry = 0 ;
        List<Integer> list = new ArrayList<>();
        for(int i = num.length-1; i>=0 ; i--){
            int digit = carry+ num[i] + (k%10);
            k = k /10;
            carry = digit/10;
            digit = digit%10;
            list.add(digit); 
        }
        if(k > 0 ){
            carry+=k;
        }
        while(carry > 0 ){
            list.add(carry%10);
            carry/=10;
        }
        Collections.reverse(list);
        return list;
    }
}