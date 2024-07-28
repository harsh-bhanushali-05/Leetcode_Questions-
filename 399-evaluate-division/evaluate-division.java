class Solution {
    class pair{
        String node; 
        double wt;
        pair(String node , double wt){
            this.node = node;
            this.wt=wt;
        }
    }
    public double f(String node , String target , HashMap<String , List<pair>> map , HashSet<String> set ){
        if(set.contains(node))return -1;
        set.add(node);
        double ans = -1;
        System.out.print(node+"->");
        for(pair nbr : map.getOrDefault(node , new ArrayList<>())){
            if(nbr.node.equals(target)){
                return nbr.wt;
            }
            double curr= f(nbr.node , target , map,set );
            if(curr !=-1) return curr*nbr.wt;
        }
        set.remove(node);
        return ans;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries){
        HashMap<String , List<pair>> map= new HashMap<>();
        int i=0;
        for(List<String> list : equations ){
            if(map.containsKey(list.get(0)) == false)
                map.put(list.get(0) , new ArrayList<>());
            map.get(list.get(0)).add(new pair(list.get(1),values[i]));
            if(map.containsKey(list.get(1)) == false)
                map.put(list.get(1) , new ArrayList<>());
            map.get(list.get(1)).add(new pair(list.get(0),1/values[i]));
            i++;
        }
        double ans[]=new double[queries.size()];
        int index = 0;
        for(List<String> list : queries){
            ans[index] = f(list.get(0) ,list.get(1) , map , new HashSet<>());
            System.out.println(ans[index]);
            index++;
        }
        return ans;
    }
}