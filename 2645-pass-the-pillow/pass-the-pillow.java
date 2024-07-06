class Solution {
    public int f(int curr , int direction , int n , int time ){
        if(time == 0 ){
            return curr;
        }
        if(n == curr){
            return f(curr-1 , 0 , n , time-1);
        }
        if(curr == 1 ){
            return f(curr +1 , 1 , n , time-1);
        }
        if(direction == 1){
            // move right 
            return f(curr+1 , 1 , n , time-1);
        }
        else {
            return f(curr -1 , 0 , n , time-1);
        }
    }
    public int passThePillow(int n, int time) {
        return f(1 , 1 , n , time);
    }
}