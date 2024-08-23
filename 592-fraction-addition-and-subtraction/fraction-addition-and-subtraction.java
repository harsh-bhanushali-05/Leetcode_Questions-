class Solution {
    public int f(int a , int b ){
        int ans =1;
        for(int i = 2 ; i <=Math.min(a,b) ; i++){
            if(a%i == 0 && b%i == 0)
                ans = i;
        }
        return ans;
    }
    public String fractionAddition(String expression) {
        int d = 1;
        List<Integer> list = new ArrayList<>();
        List< Integer> den = new ArrayList<>();
        for(int i = 0 ; i < expression.length() ; i++){
            if(expression.charAt(i) == '/'){                    
                String ans = "";
                int index = i-1;
                while(index >= 0 && Character.isDigit(expression.charAt(index))){
                    ans = expression.charAt(index)+ans;
                    index--;
                }
                if(index>=0  && expression.charAt(index)!='-'){
                    list.add(Integer.parseInt(ans));
                    // list.add(Integer.parseInt(Character.toString (expression.charAt(i-1)))); // added the nuemerator 
                }
                else if(index>=0  && expression.charAt(index) =='-'){
                    list.add(-1*Integer.parseInt(ans)); // added the nuemerator      
                
                }
                else{
                    list.add(Integer.parseInt(ans)); // added the nuemerator      
                }
                ans = "";
                index = i+1 ;
                while(index < expression.length() && Character.isDigit(expression.charAt(index))){
                    ans+=expression.charAt(index);
                    index++;
                }
                d*=Integer.parseInt(ans);
                den.add(Integer.parseInt(ans));
            }
        }
        List<Integer> l = new ArrayList<>();
        for(int index = 0 ; index < list.size() ; index++){
            l.add((int)((list.get(index) * d)/ den.get(index)));
        }
        int sum = 0;
        for(int i : l){
            sum+=i;
        }
        if(sum == 0 )return "0/1";
        // sum / d is the answer 
        int gcd = f(Math.abs(sum) , d );
        String ret = Integer.toString((Math.abs(sum)/gcd)) + "/"+Integer.toString((d/gcd));
        if(sum < 0 ){
            ret = "-"+ret;
        }
        return ret;
    }
}