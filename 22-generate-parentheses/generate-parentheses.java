class Solution {
    public void f(int n , int o , String curr , List<String> ans){
        if(n==0){
            ans.add(curr);
            return;
        }
        if(o<n){
            // open a bracket
            f(n , o+1 , curr+"(" , ans);
        }
        if(o >0){
            // we can close as well
            f(n-1 , o-1 , curr+")" , ans);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        f(n , 0 , "" , list);
        return list;
    }
}