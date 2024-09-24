class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++){
            list.add(i+1);
        }
        for(int i : nums ){
            list.set(i-1 , -1 );
        }
        for(int i = 0 ; i < list.size() ; i++){
            if(list.get(i) == -1 ){
                list.remove(i);
                i--;    
            }
        }
        return list;
    }
}