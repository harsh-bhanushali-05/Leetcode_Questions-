class Solution {
    public boolean isHappy(int n) {
        if(n==2 || n==3 || n== 4 || n==5 || n ==6 || n == 8 || n==9)return false;
        if(n==1)return true;
        int ans = 0;
        while(n>0){
            int digit = n%10;
            ans+=(digit*digit);
            n/=10;
        }
        return isHappy(ans);
    }
}