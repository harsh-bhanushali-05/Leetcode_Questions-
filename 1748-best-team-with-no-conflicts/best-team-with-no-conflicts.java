class Solution {
    class Node{
        int age ; 
        int score ;
        Node(int age , int score ){
            this.age=age;
            this.score =score;
        }
    }
    public int f(int age[] , int score[] , int i , int prev, int dp[][] ){
        if(score.length == i )return 0;
        // condition to pick up 
        if(dp[i][prev+1]!=-1)return dp[i][prev+1];
        if(prev == -1 || age[prev] == age[i]  || score[prev] <= score[i]){   
            int pick = f(age , score , i+1 , i , dp  ) + score[i];
            int not = f(age , score , i+1 , prev ,dp);
            return dp[i][prev+1] = Math.max(pick , not );
        }
        return dp[i][prev+1] = f(age , score , i+1 , prev , dp);
    }
    public int bestTeamScore(int[] scores, int[] ages) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.age - b.age == 0 ? a.score - b.score : a.age - b.age );
        for(int i = 0 ; i < ages.length ; i++){
            pq.offer(new Node(ages[i] , scores[i]));
        }
        for(int i = 0 ; i < ages.length ; i++){
            Node curr = pq.poll();
            scores[i] = curr.score;
            ages[i] = curr.age;
        }
        int dp[][] = new int[ages.length][ages.length+1];
        for(int i[] : dp){
            Arrays.fill(i , -1 );
        }
        return f(ages , scores , 0 , -1 , dp );
    }
}