class Solution {
    public List<List<Integer>> f(int nums[] , int i , int target){
        int j = nums.length-1;
        int curr = i-1;
        List<List<Integer>> ans = new ArrayList<>();
        while(j > i ){
            int sum = nums[i]+nums[j];
            if(sum  == target ){
                List<Integer> list = new ArrayList<>();
                list.add(nums[curr]);
                list.add(nums[i]);
                list.add(nums[j]);
                ans.add(new ArrayList<>(list));
            }
            if(sum < target ){
                i++;
            }
            else{
                j--;
            }
        }
        return ans;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++){
            List<List<Integer>> list = f(nums , i+1 , nums[i] *-1 );
            for(List<Integer> sub : list){
                if(set.contains(sub)==false)
                ans.add(new ArrayList<>(sub));
                set.add(sub);
            }
        }
        return ans;
    }
}