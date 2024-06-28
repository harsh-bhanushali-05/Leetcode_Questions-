class StockSpanner {
    Stack<Integer> st;
    List<Integer> list ;
    public StockSpanner() {
        st = new Stack<>();
        list = new ArrayList<>();
    }
    
    public int next(int price) {
        int ans = 0;
        while(st.isEmpty() == false && list.get(st.peek())<=price){
            st.pop();
        }
        ans = st.isEmpty()?list.size()+1: list.size()-st.peek();
        list.add(price);
        st.push(list.size()-1);
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */