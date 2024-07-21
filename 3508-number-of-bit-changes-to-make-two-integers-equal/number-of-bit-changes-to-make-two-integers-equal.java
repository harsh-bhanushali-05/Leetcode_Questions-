class Solution {
    public int minChanges(int n, int k) {
        // there are four cases 00->T +0 10->T but +1  01->F -1 11->T +0
        int ans = 0;
        while(n>0){
            if((n&1) == (k&1)){
                n=n>>1;
                k=k>>1;
            }
            else if((n&1)==1 && (k&1) == 0){
                ans++;
                n=n>>1;
                k=k>>1;
            }
            else{
                return -1;
            }
        }
        return n==k? ans:-1;
    }
}