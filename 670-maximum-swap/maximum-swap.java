class Solution {
    public int maximumSwap(int num) {
        char c[] = Integer.toString(num).toCharArray();

        for(int i = 0 ; i < c.length ; i++){
            int max = i;
            for(int j = i+1 ; j < c.length ; j++){
                if(Integer.parseInt(Character.toString(c[i]))!=Integer.parseInt(Character.toString(c[j]))&& Integer.parseInt(Character.toString(c[j])) >= Integer.parseInt(Character.toString(c[max])))
                    max = j;
            }
            if(max!=i){
                char temp = c[i];
                c[i] = c[max];
                c[max] =temp;
                break;
            }
        }
        String str = "";
        for(char a : c ){
            str+=a;
        }
        return Integer.parseInt(str);
    }
}