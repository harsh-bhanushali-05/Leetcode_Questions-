class Solution {
    public void f(int n , String str , List<String> list){
        if(n==0){
            list.add(str);
            return;
        }
        f(n-1 , str +"1" , list);
        if(str.length()==0 || str.charAt(str.length()-1)=='1'){
            f(n-1 , str+"0",list);
        }
    }

    public List<String> validStrings(int n) {
        List<String> ans = new ArrayList<>();
        f(n , "" , ans);
        Collections.sort(ans);
        return ans;
    }
}