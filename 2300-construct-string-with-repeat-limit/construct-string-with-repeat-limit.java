class Solution {
    class Node{
        char c; 
        int freq; 
        Node(char c , int freq ){
            this.c= c ; 
            this.freq = freq;
        }
    }
    public String repeatLimitedString(String s, int repeatLimit) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a ,b ) -> b.c - a.c); 
        HashMap<Character , Integer> map = new HashMap<>(); 
        for(char c : s.toCharArray()){
            map.put(c , map.getOrDefault(c , 0 )+1); 
        }
        for(char key : map.keySet()){
            pq.offer(new Node(key , map.get(key)));
        }
        String ans = ""; 
        int count = 0; 
        while(pq.isEmpty()==false){
            Node curr = pq.poll(); 
            if(curr.freq > repeatLimit ){
                String temp = ""; 
                for(int i = 0 ; i < repeatLimit ; i++){
                    temp+=curr.c;
                }
                ans+=temp; 
                if(pq.isEmpty())
                    break;
                Node next = pq.poll();
                ans+=next.c;
                if(next.freq-1 > 0 )
                    pq.offer(new Node(next.c , next.freq - 1 )); 
                if(curr.freq - repeatLimit > 0 ){
                    pq.offer(new Node(curr.c , curr.freq - repeatLimit )); 
                }
            }
            else{
                String temp = ""; 
                for(int i = 0 ; i < curr.freq ; i++){
                    temp+=curr.c;
                }
                ans+=temp;
            }
        }
        return ans;
    }
}