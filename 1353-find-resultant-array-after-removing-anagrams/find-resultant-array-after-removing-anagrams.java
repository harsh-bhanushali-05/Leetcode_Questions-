class Solution {
    public String f(String str ){
        char arr[] = str.toCharArray(); 
        Arrays.sort(arr); 
        StringBuilder sb = new StringBuilder(); 
        for(char c : arr){
            sb.append(c);
        }
        return sb.toString(); 
    }
    public List<String> removeAnagrams(String[] words) {
        String last = f(words[0]); 
        List<String> ans = new ArrayList<>(); 
        ans.add(words[0]);
        for(String str : words){
            String curr = f(str);
            // System.out.println(str + " " + curr + " "+ last); 
            if(curr.equals(last)==false){
                last = curr; 
                ans.add(str);
            }
        }
        return ans;
    }
}