class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public void f(int i, int arr[], int target, List<Integer> curr) {
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (i == arr.length || target < 0) {
            return;
        }

        for (int j = i; j < arr.length; j++) {
            if (j > i && arr[j] == arr[j - 1]) continue; 
            curr.add(arr[j]);
            f(j + 1, arr, target - arr[j], curr);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        f(0, candidates, target, new ArrayList<>());
        return ans;
    }
}