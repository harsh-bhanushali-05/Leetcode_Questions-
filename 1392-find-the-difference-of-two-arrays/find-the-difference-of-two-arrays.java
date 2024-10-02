class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // nums1 but not in nums2 
        // nums2 but not in nums1 
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums2 ){
            set.add(i);
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        for(int i : nums1 ){
            if(set.contains(i)==false){
                sub.add(i);
                set.add(i);
            }
        }
        ans.add(new ArrayList<>(sub));
        set = new HashSet<>();
        for(int i : nums1 ){
            set.add(i);
        }
        sub = new ArrayList<>();
        for(int i : nums2 ){
            if(set.contains(i)==false){
                sub.add(i);
                set.add(i);
            }
        }
        ans.add(sub);
        return ans;
    }
}