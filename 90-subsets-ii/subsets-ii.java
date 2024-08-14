class Solution {
    HashSet<List<Integer>> set = new HashSet<>();
    List<List<Integer>> ans = new ArrayList<>();
    public void f(int nums[], int i , List<Integer> list){
        if(i == nums.length ){  
            Collections.sort(list);
            if(set.contains(list)==false)
                ans.add(new ArrayList<>(list));
            set.add(new ArrayList<>(list));
            return;
        }
        // take ->
        list.add(nums[i]);
        f(nums , i+1 , list);
        // not take -> 
        list.remove(list.size()-1);
        f(nums , i+1 , list);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        f(nums, 0 , new ArrayList<>());
        return ans;
    }
}