class Solution {
    public boolean opcount(String str){
        for(int curr : str.toCharArray()){
             if(curr == '-' || curr == '+' || curr == '*' || curr == '/'){
                return false;
            }
        }
        return true;
    }
    public List<Integer> diffWaysToCompute(String expression) {
        if(opcount(expression)){
            List<Integer> ans = new ArrayList<>();
            ans.add(Integer.parseInt(expression));
            return ans;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i <expression.length() ; i++){
            char curr = expression.charAt(i);
            if(curr == '-' || curr == '+' || curr == '*' || curr == '/'){
                List <Integer> one = diffWaysToCompute(expression.substring(0 , i));
                List <Integer> two = diffWaysToCompute(expression.substring(i+1 , expression.length()));
                for(int a : one){
                    for(int b : two ){
                        if(curr == '-')
                            ans.add(a-b);
                        if(curr == '+')
                            ans.add(a+b);
                        if(curr == '*')
                            ans.add(a*b);
                        if(curr == '/')
                            ans.add(a/b);
                    }
                }
            }
        }
        return ans;
    }
}