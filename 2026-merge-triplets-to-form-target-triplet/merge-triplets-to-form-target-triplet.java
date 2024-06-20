class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int a = 0; 
        int b = 0;
        int c = 0;
        for(int i[] : triplets){
            int am = Math.max(a , i[0]);
            int bm = Math.max(b , i[1]);
            int cm = Math.max(c, i[2]);
            if(target[0]>=am && target[1]>=bm && target[2]>=cm ){
                a=am;
                b=bm;
                c=cm;
            }
        }
        return a == target[0] && b==target[1] && c== target[2];
    }
}