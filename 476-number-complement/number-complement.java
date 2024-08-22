class Solution {
    public int findComplement(int num) {
       int n = num; 
       int ans = 0;
       while(n>0){
         ans = (ans<<1)+1; 
         n = n>>1;
       }
       return num^ans;
    }
}