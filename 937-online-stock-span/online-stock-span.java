class StockSpanner {
    class node{
        int index; 
        int val;
        node(int index , int val ){
            this.index = index;
            this.val  =val;
        }
    }
    Stack<node> st = new Stack<>();
    int curr = 0 ;
    public StockSpanner() {
        
    }
    
    public int next(int price) {
        while(!st.isEmpty() && st.peek().val <= price ){
            st.pop();
        }
        curr++;
        int ans = st.isEmpty()? curr : curr - st.peek().index;
        st.push(new node(curr , price ));
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */