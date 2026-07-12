class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer , Integer > map = new HashMap<>(); 
        int index = 1; 
        int temp[] = new int[arr.length];
        for(int i = 0; i < temp.length ; i++){
            temp[i] = arr[i];
        }
        Arrays.sort(temp);
        for(int i : temp ){
            if(map.containsKey(i)){
                continue; 
            }
            map.put(i , index );
            index++;
        }
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}