class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int i = 0;
        int j = arr.length-k; 
        int mid = i+ (j-i)/2;
        while(i < j ){
            if(x - arr[mid] > arr[mid+k]-x){
                i=mid+1;
            }
            else{
                j = mid;
            }
            mid = i+(j-i)/2;
        }
        List<Integer> ans = new ArrayList<>();
        int till = i+k;
        for(; i < till ; i++)
            ans.add(arr[i]);
        return ans;
    }
}