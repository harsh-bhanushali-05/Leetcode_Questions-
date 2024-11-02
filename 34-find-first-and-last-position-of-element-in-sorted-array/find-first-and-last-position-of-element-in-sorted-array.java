class Solution {
    public int right(int arr[], int target ){
        int i = 0 ; 
        int ans = -1;
        int j = arr.length-1; 
        while(i <= j ){
            int mid = (j-i)/2+i;
            if(arr[mid] == target ){
                ans = mid; 
                i = mid+1; // to give the right most value 
            }
            else if(arr[mid] < target ){
                // the answer is in the right half of the array 
                i = mid+1;
            }
            else{
                j = mid-1;
            }
        }
        return ans;
    }
    public int left(int arr[] , int target ){
        int i = 0 ;
        int ans = -1;
        int j = arr.length-1; 
        while(i <= j ){
            int mid = (j-i)/2+i; 
            if(arr[mid] == target ){
                ans = mid;
                j = mid-1;
            }
            else if(arr[mid] < target ){
                i = mid+1;
            }
            else{
                j = mid-1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int arr[] = new int[2];
        arr[0] = left(nums , target );
        arr[1] = right(nums , target );
        return arr;
    }
}