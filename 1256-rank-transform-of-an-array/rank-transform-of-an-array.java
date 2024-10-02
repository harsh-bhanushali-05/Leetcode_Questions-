class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int ans[] = new int[arr.length];
        for(int i =0 ; i < arr.length ; i++){
            ans[i] = arr[i];
        }
        Arrays.sort(arr);
        HashMap<Integer , Integer > map = new HashMap<>();
        int count = 1;
        for(int i = 0 ; i < arr.length ; i++){
            if(map.containsKey(arr[i]) == false ){
                map.put(arr[i] , count );
                count++;
            }
        }
        for(int i = 0 ;i < arr.length ; i++){
            ans[i] = map.get(ans[i]);
        }
        return ans;
    }
}