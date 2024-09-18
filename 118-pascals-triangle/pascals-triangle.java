class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0 ; i < numRows ; i++){
            List<Integer> sub = new ArrayList<>();
            if(i == 0){
                sub.add(1);
                ans.add(new ArrayList<>(sub));
                continue;
            }
            for(int j = 0 ; j <= ans.get(ans.size()-1).size() ; j++){
                int one = j-1 < 0? 0: ans.get(ans.size()-1).get(j-1) ;
                int two = j >= ans.get(ans.size()-1).size() ? 0 : ans.get(ans.size()-1).get(j);
                sub.add( one +two );
            }
            ans.add(new ArrayList<>(sub));
        }
        return ans;
    }
}