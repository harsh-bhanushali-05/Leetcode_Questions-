class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public void f(int i , int k , int n , List<Integer> curr){
        if(i ==10){
            if( k == 0 && n == 0 ){
                list.add(new ArrayList<>(curr));
            }
            return;
        }
        curr.add(i);
        f(i+1 , k -1 , n-i , curr);
        curr.remove(curr.size()-1);
        f(i+1 , k , n , curr);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        // k numbers that add up to n. 
        f(1,  k , n , new ArrayList<>());
        return list;
    }
}