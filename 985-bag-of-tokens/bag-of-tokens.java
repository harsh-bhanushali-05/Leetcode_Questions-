class Solution {
    public int bagOfTokensScore(int[] arr, int power) {
        int i = 0; 
        Arrays.sort(arr);
        int j = arr.length-1;
        int score = 0;
        int ans = 0;
        while(j>=i){
            if(power < arr[i]){
                if(score > 0 ){
                    power+=arr[j];
                    j--;
                    score--;
                }
                else{
                    break;
                }
            }
            else{
                score++;
                power-=arr[i];
                i++;
            }
            ans = Math.max(ans , score );
        }
        return ans;
    }
}