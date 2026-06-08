class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> low = new ArrayList<>(); 
        List<Integer> same = new ArrayList<>(); 
        List<Integer> high = new ArrayList<>(); 
        for(int i : nums ){
            if(i < pivot){
                low.add(i);
            }else if(i == pivot ){
                same.add(i);
            }else{
                high.add(i);
            }
        }
        int index = 0; 
        for(int i = 0 ; i<low.size(); i++){
            nums[index] = low.get(i);
            index++;
        }
        for(int i = 0 ; i<same.size(); i++){
            nums[index] = same.get(i);
            index++;
        }for(int i = 0 ; i<high.size(); i++){
            nums[index] = high.get(i);
            index++;
        }
        return nums;
    }
}