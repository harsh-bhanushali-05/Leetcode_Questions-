class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < numCourses ;i++){
            map.put(i , new ArrayList<>());
        }
        int in[] = new int[map.size()];
        for(int i = 0 ; i < prerequisites.length ; i++){
            map.get(prerequisites[i][1]).add(prerequisites[i][0]); // making an edge 
            in[prerequisites[i][0]]++; // indegree 
        }
        Queue<Integer> q = new ArrayDeque<>();
        int res = 0;
        for(int i = 0 ;  i < in.length ; i++){
            if(in[i] ==0 ){
                q.offer(i);
                res++;
            }
        }
        while(q.isEmpty()==false){
            int node = q.poll();
            for(int nbr : map.get(node)){
                in[nbr]--;
                if(in[nbr]==0){
                    q.offer(nbr);
                    res++;
                }
            }
        }
        return res == in.length;
    }
}