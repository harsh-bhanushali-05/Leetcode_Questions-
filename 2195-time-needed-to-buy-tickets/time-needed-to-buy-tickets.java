class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        int i = 0 ;
        while(true){
            if(tickets[k] == 0 )return time;
            if(tickets[i%tickets.length] == 0 ){i++;
                continue;
            }
            tickets[i%tickets.length]--;
            time++;
            i++;
        }
    }
}