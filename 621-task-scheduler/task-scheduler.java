class Solution {
    class task{
        char val;
        int freq; 
        int time;
        task(char val , int freq , int time ){
            this.val = val;
            this.freq = freq;
            this.time = time;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer>  map = new HashMap<>();
        for(char c : tasks)
            map.put( c , map.getOrDefault(c,0)+1);
        PriorityQueue<task> pq= new PriorityQueue<>((a,b)->a.time-b.time); // sort with smallest time first 
        for(char c : map.keySet()){
            task temp = new task(c , map.get(c) , 0 );
            pq.offer(temp);
        }
        for(int i = 0 ; ; i++){
            if(pq.isEmpty()){
                return i;
            }
            if(i<pq.peek().time)
                continue;
            task temp = pq.poll();
            temp.freq-=1;
            temp.time = temp.time+ n + 1;
            if(temp.freq!=0){
                pq.offer(temp);
            }
        }
    }
}