class Solution {
    public int gcd(int a , int b ){
        if( b == 0 ){
            return a;
        }
        return gcd(b , a%b);
    }
    public int findGCD(int[] nums) {
        var s = Arrays.stream(nums).summaryStatistics(); 
        return gcd(s.getMax() , s.getMin() );  
    }
}