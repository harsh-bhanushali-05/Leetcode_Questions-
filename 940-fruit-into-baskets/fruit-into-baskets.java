class Solution {
    public int totalFruit(int[] arr) {
        HashMap<Integer , Integer > map = new HashMap<>();
        int count = 0 ;
        int i = 0;
        int j = 0;
        int ans = 0 ;
        while(j < arr.length ){
            if(map.containsKey(arr[j])){
                map.put(arr[j] , map.getOrDefault(arr[j] , 0 )+1);
                ans = Math.max(ans , j-i+1);
                j++;
            }
            else{
                map.put(arr[j] , map.getOrDefault(arr[j] , 0 )+1);
                if(map.get(arr[j]) == 1 )
                    count++;
                while(count > 2){
                    map.put(arr[i] , map.getOrDefault(arr[i] , 1 )-1);
                    if(map.get(arr[i]) == 0 ){
                        map.remove(arr[i]);
                        count--;
                    }
                    i++;
                }
                ans = Math.max(ans , j-i+1);
                j++;
            }
        }
        return ans;
    }
}