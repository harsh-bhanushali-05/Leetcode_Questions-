class Solution {
    List<List<String>> ans = new ArrayList<>();
    public void f(HashSet<Integer> col , HashSet<Integer> pos , HashSet<Integer> neg , List<String> sub , int i , int n ){
        if(i==n){
            ans.add(new ArrayList<>(sub));
            return;
        }
        for(int k = 0 ; k<n ; k++){
            if(col.contains(k)==false && neg.contains(i-k) == false && pos.contains(i+k)==false){
                col.add(k);
                neg.add(i-k);
                pos.add(i+k);
                String str = "";
                for(int a=0;a<k;a++){
                    str+='.';
                }
                str+='Q';
                for(int a=k+1;a<n;a++){
                    str+='.';
                }
                sub.add(str);
                f(col , pos, neg , sub , i+1 , n );
                sub.remove(sub.size()-1);
                col.remove(k);
                neg.remove(i-k);
                pos.remove(i+k);
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        f(new HashSet<>() ,new HashSet<>() ,new HashSet<>() ,new ArrayList<>(),0,n );
        return ans;
    }
}