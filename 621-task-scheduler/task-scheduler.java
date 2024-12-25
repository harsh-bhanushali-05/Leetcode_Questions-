class Solution {
    class Node{
        char process;
        int freq; 
        int time; 
        Node(char process , int freq , int time ){
            this.process = process;
            this.time = time;
            this.freq = freq;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        int time = 0;
        HashMap<Character , Integer> map = new HashMap<>(); 
        for(char c : tasks ){
            map.put(c , map.getOrDefault(c , 0 )+1);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)-> a.time - b.time == 0 ? b.freq - a.freq : a.time-b.time);
        for(char key : map.keySet()){
            pq.offer(new Node(key , map.get(key) , 0 ));
        }
        int ans = 0 ;
        while(true){
            if(pq.size() == 0 ){
                return ans;
            }
            Node curr = pq.peek(); 
            if(curr.time > ans){
                ans++;
                continue;
            }
            // we can process it right now 
            pq.poll(); 
            if(curr.freq > 1 ){
                Node naya = new Node(curr.process , curr.freq -1 , curr.time + n + 1);
                pq.offer(naya);
            }
            ans++;
        }
    }
}