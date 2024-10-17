class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        
        for (int i : asteroids) {
            // Handle collision cases where a positive asteroid and negative asteroid collide
            while (!st.isEmpty() && st.peek() > 0 && i < 0) {
                if (st.peek() < -i) {
                    // The top of the stack (positive asteroid) is smaller and will explode
                    st.pop();
                    // Continue to check for further collisions
                } else if (st.peek() == -i) {
                    // Both asteroids are equal, both will explode
                    st.pop();
                    i = 0; // Set `i` to 0 to prevent it from being pushed into the stack
                    break;
                } else {
                    // The current asteroid is smaller and will explode
                    i = 0;
                    break;
                }
            }
            
            if (i != 0) {
                st.push(i); // Push the asteroid into the stack if it's still intact
            }
        }
        
        // Convert stack to array for final result
        int[] ans = new int[st.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }
        return ans;
    }
}