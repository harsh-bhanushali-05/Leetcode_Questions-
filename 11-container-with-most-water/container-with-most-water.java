class Solution {
    public int maxArea(int[] a) {
        int i = 0; 
        int j = a.length-1; 
        int ans = 0; 
        while(i<j){
            ans = Math.max(Math.min(a[i],a[j])*(j-i) , ans );
            if(a[i]<a[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return ans;
    }
}