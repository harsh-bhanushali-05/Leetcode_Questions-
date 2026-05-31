class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids); 
        long mass_long = (long)mass; 
        for(int i = 0 ; i < asteroids.length ; i++){
            if(asteroids[i] > mass_long ){
                return false;
            }
            else{
                mass_long+=asteroids[i];
            }
        }
        return true;
    }
}