class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        HashMap<Character , List<Integer>> map = new HashMap<>();
        int index = 0;
        for(char c : s.toCharArray()){
            if(map.containsKey(c) == false)
                map.put(c, new ArrayList<>());
            map.get(c).add(index);
            index++;
        }
        int ans = -1;
        for(char c : map.keySet()){
            ans = Math.max(ans ,map.get(c).get(map.get(c).size()-1) - map.get(c).get(0)-1);
        }
        return ans;
    }
}