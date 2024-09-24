class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String> set = new HashSet<>();
        for(int i : arr1 ){
            String curr = Integer.toString(i);
            for(int l = 0 ; l < curr.length() ; l++){
                //  System.out.println(curr.substring(0 , l+1));
                set.add(curr.substring(0,l+1));
            }
        }
        int ans= 0;
        for(int i : arr2 ){
            String curr = Integer.toString(i);
            for(int l = 0 ; l < curr.length() ; l++){
                if(set.contains(curr.substring(0 , l+1))){
                    ans= Math.max(curr.substring(0 , l+1).length(), ans);
                }
            }
        }
        return ans;
    }
}