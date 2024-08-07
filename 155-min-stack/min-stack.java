class MinStack {
    Stack<Integer> st;
    int min = Integer.MAX_VALUE;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        min = Math.min(val , min );
        st.push(val);    
    }
    
    public void pop() {
        if(st.pop() == min ){
            min = Integer.MAX_VALUE;
            Stack<Integer> temp = new Stack<>();
            while(st.isEmpty()==false){
                int poped = st.pop();
                min = Math.min(min , poped);
                temp.push(poped);
            }
            while(temp.isEmpty()==false){
                int poped = temp.pop();
                st.push(poped);
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