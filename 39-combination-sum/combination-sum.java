class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public int f(int i , int sum , int arr[] , List<Integer> list ){
        if(i == arr.length ){
            if(sum==0){
            ans.add(new ArrayList<>(list));
            }
            return 0;
        }
        if(sum < 0)return 0;
        // take 
        list.add(arr[i]);
        f(i , sum-arr[i] , arr , list);
        // not taken 
        list.remove(list.size()-1);
        f(i+1 , sum , arr, list);

        return 0;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        f(0 , target , candidates , new ArrayList<>());
        return ans;
    }
}