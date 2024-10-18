import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // Create an array of cars, each represented by {position, time to target}
        int n = position.length;
        double[][] cars = new double[n][2]; // Each car has position and time

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i]; // position
            cars[i][1] = (double)(target - position[i]) / speed[i]; // time to reach target
        }

        // Sort cars by position (farther from the target first)
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            double time = cars[i][1];
            if (stack.isEmpty() || stack.peek() < time) {
                stack.push(time);
            }
        }

        // The size of the stack is the number of fleets
        return stack.size();
    }
}