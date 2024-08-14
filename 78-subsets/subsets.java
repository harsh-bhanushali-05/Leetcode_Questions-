class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public void f(List<Integer> list , int i , int arr[] ){
        if(i == arr.length ){
            ans.add(new ArrayList<>(list));
            return;
        }
        // take 
        list.add(arr[i]);
        f(list, i+1 , arr);
        // not take 
        list.remove(list.size()-1);
        f(list , i+1 , arr);
    }
    public List<List<Integer>> subsets(int[] nums) {
        f(new ArrayList<>(), 0 , nums);
        return ans;
    }
}