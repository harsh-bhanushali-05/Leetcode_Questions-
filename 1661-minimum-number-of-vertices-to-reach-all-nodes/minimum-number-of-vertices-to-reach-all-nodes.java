class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i< n ; i++){
            set.add(i);
        }
        for(List<Integer> i : edges){
            if(set.contains(i.get(1)))
                set.remove(i.get(1));
        }
        for(int i = 0 ; i < n ; i++){
            if(set.contains(i))
                list.add(i);
        }
        return list;    
    }
}