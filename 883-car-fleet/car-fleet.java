class Solution {
    class Pair {
        int speed;
        int pos; 
        Pair(int speed, int pos) {
            this.speed = speed;
            this.pos = pos;
        }
    }
    
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;
        
        Pair[] cars = new Pair[n];
        for (int i = 0; i < n; i++) {
            cars[i] = new Pair(speed[i], position[i]);
        }
        
        Arrays.sort(cars, (a, b) -> b.pos - a.pos);
        
        double[] time = new double[n];
        for (int i = 0; i < n; i++) {
            time[i] = (double) (target - cars[i].pos) / cars[i].speed;
        }
        
        int fleets = 1;
        double lastTime = time[0];
        for (int i = 1; i < n; i++) {
            if (time[i] > lastTime) {
                fleets++;
                lastTime = time[i];
            }
        }
        
        return fleets;
    }
}