class Solution {
    public int factorial(int n ){
        if(n==0 || n==1){
            return 1;
        }
        return n*factorial(n-1);
    }
    public String getPermutation(int n, int k) {
        int arr[] = new int[n];
        for(int i = 0 ; i < n  ;i++){
            arr[i] = i+1;
        }
        for(int i = 0 ; i < n ; i++){
            int curr=i;
            int fact = factorial(n-1-i);
            while(k>fact){
                k-=fact;
                curr++;
            }
            // swap curr and the ith index 
            int temp = arr[curr];
            arr[curr] = arr[i];
            arr[i] = temp;
            Arrays.sort(arr, i+1 , arr.length);
        }
        String str="";
        for(int i : arr){
            str+=Integer.toString(i);
        }
        return str;
    }
}