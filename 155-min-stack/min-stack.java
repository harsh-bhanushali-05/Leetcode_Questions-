class MinStack {
    Stack <Integer> st;
    int min ;
    public MinStack() {
        st = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        st.push(val);
        min = Math.min(min , val);
    }
    
    public void pop() {
        int removed = st.pop();
        if(removed == min){
            min = Integer.MAX_VALUE;
            Stack<Integer> temp = new Stack<>();
            while(st.isEmpty()==false){
                int x = st.pop();
                min = Math.min(min , x);
                temp.push(x);
            }
            while(temp.isEmpty()==false){
                st.push(temp.pop());
            }
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */