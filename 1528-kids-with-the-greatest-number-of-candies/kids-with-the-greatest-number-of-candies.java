class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = -1;
        for(int i : candies )
            max = Math.max(max , i );
        List<Boolean> list = new ArrayList<>();
        for(int i : candies ){
            if(i+extraCandies >= max )
                list.add(true);
            else 
                list.add(false);
        }
        return list;
    }
}