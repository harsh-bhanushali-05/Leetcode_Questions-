class Solution {
    public HashMap<Integer , List<Integer>> nodelist(int n , int arr[][] ){
        HashMap<Integer , List<Integer>> map = new HashMap<>(); 
        for(int i = 0; i < n ; i++){
            map.put(i , new ArrayList<>());
            map.get(i).add(i);
        }
        for(int i[] : arr){
            map.get(i[0]).add(i[1]);
            map.get(i[1]).add(i[0]);
        }
        return map; 
    }
    public boolean isSame(List<Integer> a , List<Integer> b ){
        if (a.size() != b.size()) {
            return true;
        }
        HashSet<Integer> setA = new HashSet<>(a);
        HashSet<Integer> setB = new HashSet<>(b);
        return !setA.equals(setB); 
    }
    public boolean isConnected(int i , HashMap<Integer , List<Integer>> map){
        List<Integer> curr = map.get(i);
        for(int nbr : curr){
            if(isSame(map.get(nbr) , curr)){
                return false;
            }
        }
        return true;
    }
    public int countCompleteComponents(int n, int[][] edges) {
        HashMap<Integer , List<Integer>> map = nodelist(n , edges );
        int ans = 0; 
        HashSet<Integer> set = new HashSet<>(); 
        for(int i =0 ; i < n ; i++){
            if(set.contains(i) == false && isConnected(i , map )){
                ans++;
            }
            for(int val : map.get(i)){
                set.add(val);
            }
        }
        return ans; 
    }
}