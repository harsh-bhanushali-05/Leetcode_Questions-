class Solution {
    public int f(String a , String b ,int i , int j , int dp[][]){
        if(a.length() <= i || b.length() <= j )return 0; 
        if(dp[i][j]!=-1)return dp[i][j];
        if(a.charAt(i) == b.charAt(j) ){
            return dp[i][j] = 1+f(a,b,i+1,j+1 ,dp);
        }
        int one = f(a , b, i+1,j,dp);
        int two = f(a , b, i , j+1,dp);
        return dp[i][j] = Math.max(one , two);
    }
    public int longestStrChain(String[] words) {
        // largest substring (a,b) shud be a itself then we can get it 
        // sort the words list based on the length of the words in it 
        if(words.length == 0 )return 0;
        Arrays.sort(words, (a,b)->a.length() - b.length());
        int ans[] = new int[words.length];
        int ret = 1 ;
        for(int i = 0 ; i < words.length ; i++){
            ans[i] = 1; 
            for(int j = i-1 ; j >=0 ; j--){
                if(words[i].length() - words[j].length() == 1 ){
                    // chk if they are connecting 
                    int dp[][] = new int[words[i].length()+1][words[j].length()+1];
                    for(int k[] : dp ){
                        Arrays.fill(k , -1 );
                    }
                    int len = f(words[i] , words[j] , 0 , 0 ,dp);
                    if(len == words[j].length()){
                        ans[i] = Math.max(ans[i] , ans[j]+1);
                        ret = Math.max(ret , ans[i]);
                    }
                }
            }
        }
        return ret;
    }
}