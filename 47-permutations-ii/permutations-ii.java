class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    HashSet<List<Integer>> set = new HashSet<>();
    public void f(List<Integer> list , List<Integer> curr ){
        if(list.size()==0){
            if(set.contains(curr)==false){
                ans.add(new ArrayList<>(curr));
            }
            set.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0 ;i< list.size() ; i++){
            int temp = list.get(i);
            curr.add(list.get(i));
            list.remove(i);
            f(list , curr);
            list.add(i,temp);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> list = new ArrayList();
        for(int i : nums ){
            list.add(i);
        }
        f(list ,new ArrayList<>());
        return ans;
    }
}