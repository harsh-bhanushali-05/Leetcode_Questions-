class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public void f(int nums[] , int i , List<Integer> list ){
        if(i==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        // Take 
        list.add(nums[i]);
        f(nums , i+1 , list);
        // Not Take 
        list.remove(list.size()-1);
        f(nums , i+1 , list);
    }
    public List<List<Integer>> subsets(int[] nums) {
        f(nums , 0 , new ArrayList<>());
        return ans;
    }
}