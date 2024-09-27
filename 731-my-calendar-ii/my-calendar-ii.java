import java.util.ArrayList;
import java.util.List;

class MyCalendarTwo {
    List<Integer> list = new ArrayList<>();  // To store booked intervals
    List<Integer> over = new ArrayList<>();  // To store overlapping intervals (double bookings)

    public MyCalendarTwo() {
    }

    public boolean book(int start, int end) {
        // Check for triple booking in the `over` list
        for (int i = 0; i < over.size(); i += 2) {
            if (start < over.get(i+1) && end > over.get(i)) {
                return false;  // Triple booking detected
            }
        }

        // Check for overlaps with existing bookings and add to `over` if overlap exists
        for (int i = 0; i < list.size(); i += 2) {
            if (start < list.get(i+1) && end > list.get(i)) {
                // There's an overlap, add the overlap range to the `over` list
                over.add(Math.max(list.get(i), start));  // Add the max of the two starts (start of the overlap)
                over.add(Math.min(list.get(i+1), end));  // Add the min of the two ends (end of the overlap)
            }
        }

        // If no triple booking is detected, add the new booking to `list`
        list.add(start);
        list.add(end);
        return true;  // Booking is successful
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */