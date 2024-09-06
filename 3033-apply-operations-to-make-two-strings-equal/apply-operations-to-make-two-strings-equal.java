class Solution {
    public int f(int i , int a[] , int b[] , int change , int x , int dp[][]){
        if(i == a.length)return change>=1? (int)1e9 : 0;
        if(dp[i][change]  != -1)return dp[i][change];
        if(a[i] == b[i]){
            return dp[i][change]  = f(i+1 , a,b , change , x , dp );
        }
        else{
            int next = (int)1e9;
            int not = (int)1e9;
            int done = (int)1e9;
            if(change>0 ){
                // we can change the current index without any extra charge 
                done = f(i+1 , a , b , change-1, x ,dp );
            }
            int ele = a[i];
            not = f(i+1 , a , b , change+1 ,x , dp ) + x;
            if(i == a.length-1)return dp[i][change] = Math.min(done , not );
            int ele2 = a[i+1];
            a[i] = a[i]==0?1:0;
            a[i+1] = a[i+1]==0?1:0;
            next = f(i+1 , a , b , change, x , dp )+1; // we are changing the curr and next element thus we incur 1 
            a[i]= ele;
            a[i+1] = ele2;
            return dp[i][change] = Math.min(not , Math.min(done , next));
        }
    }
    public int minOperations(String s1, String s2, int x) {
        // lets keep a variable i to keep the track 
        // change the next val 
        // or dont change the value 
        int a[] = new int[s1.length()];
        int b[] = new int[s2.length()];
        for(int i = 0 ;i < a.length ; i++){
            a[i] = Integer.parseInt(Character.toString(s1.charAt(i)));
            b[i] = Integer.parseInt(Character.toString(s2.charAt(i)));
        }
        int dp[][] = new int[s1.length()][s2.length()];
        for(int i[] : dp )
            Arrays.fill(i , -1 );
        int ans = f(0 , a , b , 0 , x , dp );
        return ans > (int)1e8? -1 : ans;
    }
}