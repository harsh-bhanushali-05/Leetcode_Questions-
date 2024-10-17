class Solution {
    public boolean f(HashSet<Integer> set , int node , int jump , int target , HashMap<String , Boolean> memo ){
        if(target == node ){
            return true;
        }
        if(jump<0)return false;
        String key = Integer.toString(node)+","+Integer.toString(jump);
        if(set.contains(node)==false){
            memo.put(key , false);
            return false;
        }
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        set.remove(node);
        boolean ans =  f(set , node+(jump-1) , jump-1,target , memo ) || f(set , node+(jump) , jump ,target,memo) ||f(set , node+(jump+1) , jump+1,target,memo) ; 
        set.add(node);
        memo.put(key , ans);
        return ans;
    }
    public boolean canCross(int[] stones) {
        HashSet<Integer > set = new HashSet<>();
        for(int i : stones){
            set.add(i) ;
        }
        return f(set , stones[0] , 0 , stones[stones.length-1] , new HashMap<>());
    }
}