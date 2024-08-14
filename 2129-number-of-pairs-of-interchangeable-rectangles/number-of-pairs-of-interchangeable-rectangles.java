class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double , Integer> map = new HashMap<>();
        for(int i[] : rectangles){
            double key = (double)i[0]/(double)i[1];
            map.put(key, map.getOrDefault(key,0)+1);
        }
        long count = 0 ;
        for(double key : map.keySet()){
            long n = map.get(key);
            count+=(long)((n*(n-1))/2);
        }
        return count;
    }
}