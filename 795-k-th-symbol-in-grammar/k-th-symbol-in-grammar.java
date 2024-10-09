class Solution {
    public int kthGrammar(int n, int k) {
        int count = 0 ;
        k-=1;
        n--;
        while(n-->0){
            if(k%2==0){
                k/=2;
            }
            else{
                count++;
                k/=2;
            }
        }
        return count%2==0?0:1;
    }
}