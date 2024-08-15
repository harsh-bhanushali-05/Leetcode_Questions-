class Solution {
    public double f(double x , int n ){
        if(n==0)return 1 ; 
        double k = f(x,n/2);
        if(n%2==0){
            return k*k;
        }
        else return k*k*x;
    }
    public double myPow(double x, int n) {
         if(n<0){
            return 1/f(x,n*-1);
        }
        return f(x,n);
    }
}