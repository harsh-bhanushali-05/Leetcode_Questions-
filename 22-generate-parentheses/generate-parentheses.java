class Solution {
    List<String> ans = new ArrayList<>();
    public void f(int n , String curr , int open , int close ){
        if( n == close ){
            ans.add(curr);
            return;
        }
        if(open < n ){
            f(n , curr+"(" , open+1 , close);
        }
        if(open > close ){
            f(n , curr+")" , open , close+1);
        }
    }
    public List<String> generateParenthesis(int n) {
        f(n , "" , 0 , 0 );
        return ans;
    }
}