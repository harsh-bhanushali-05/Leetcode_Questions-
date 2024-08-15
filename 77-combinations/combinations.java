class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public void f(int i , int k , int n , List<Integer> curr ){
        if(curr.size() == k ){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(i > n )return;
        // take 
        curr.add(i);
        f(i+1 , k , n ,curr);
        curr.remove(curr.size()-1);
        f(i+1 , k , n , curr);
    }
    public List<List<Integer>> combine(int n, int k) {
        f(1 , k , n , new ArrayList<>());
        return ans;
    }
}