class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int arr[] = new int[energy.length];
        int ans = Integer.MIN_VALUE; 
        for(int i = 1; i<=k;i++){
            int j = energy.length-i; 
            int curr =0;
            while(j >= 0){
                curr+=energy[j]; 
                arr[j] = curr; 
                j-=k;
                ans = Math.max(ans , curr);
            }
        }
        for(int i : arr){
            System.out.println(i);
        }
        return ans;
    }
}