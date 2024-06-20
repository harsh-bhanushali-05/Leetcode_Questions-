class Solution {
    public int f(int mid , int position[]){
        int curr = position[0];
        int ans =1 ;
        for(int i : position){
            if(i-curr >=mid){
                curr = i;
                ans++;
            }
        }   
        return ans;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int s = 0;
        int e = -1;
        for(int i : position)
            e= Math.max(e , i );
        int mid = (e-s)/2+s;
        int ans = 0;
        while(s<=e){
            System.out.println("mid" +mid);
            if(f(mid , position) >= m){
                ans = mid;
                s=mid+1;
            }
            else{
                e= mid-1;
            }
            mid = (e-s)/2+s;
        }
        return ans;
    }
}