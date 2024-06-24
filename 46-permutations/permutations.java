class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public void f(List<Integer> avail , List<Integer> curr){
        if(avail.size()==0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i =0; i <  avail.size(); i++){
            curr.add(avail.get(i));
            int ele = curr.get(curr.size()-1);
            avail.remove(i);
            f(avail , curr);
            curr.remove(curr.size()-1);
            avail.add(i , ele);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i : nums ){
            list.add(i);
        }
        f(list , new ArrayList<>());
        return ans;
    }
}