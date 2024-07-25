class Solution {
    public void merge(int s , int e , int m , int nums[]){
        int ans[] = new int[e-s+1];
        int i = s; 
        int j = m+1;
        int index = 0;
        while(i <m+1 && j <=e ){
            if(nums[i] < nums[j]){
                ans[index] = nums[i];
                i++;
                index++;
            }
            else{
                ans[index] = nums[j];
                j++;
                index++;
            }
        }
        while(i < m+1 ){
            ans[index]= nums[i];
            i++;
            index++;
        }
        while(j <= e){
            ans[index] = nums[j];
            j++;
            index++;
        }
        for(int a = s ; a<=e ; a++){
            nums[a] = ans[a-s];
        }
    }
    public void sort(int s , int e , int nums[] ){
        if(s>=e)return;
        int m = s+((e-s)/2);
        sort(s , m , nums);
        sort( m+1 , e , nums);
        merge(s , e ,  m , nums);
    }
    public int[] sortArray(int[] nums) {
        sort(0 , nums.length -1 , nums);
        return nums;
    }
}