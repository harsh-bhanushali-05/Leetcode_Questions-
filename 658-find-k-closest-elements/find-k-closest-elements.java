class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int ans = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(Math.abs(arr[i] - x)< Math.abs(arr[ans]-x)){
                ans = i;
            }
        }
        List<Integer> list = new ArrayList<>();
        list.add(arr[ans]);
        k--;
        int i = ans-1 ; 
        int j = ans+1 ;
        while(k-->0){
            int prev = i<0?Integer.MIN_VALUE : arr[i];
            int next = j == arr.length ? Integer.MIN_VALUE : arr[j];
            if(i==-1 || Math.abs(next - x )< Math.abs(prev - x )){
                list.add(arr[j]);
                j++;
            }
            else{
                list.add(arr[i]);
                i--;
            }
        }
        Collections.sort(list);
        return list;
    }
}