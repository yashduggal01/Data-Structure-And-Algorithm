import java.util.*;

class MyCalendarTwo {
    private List<int[]> bookings;
    private List<int[]> overlaps;

    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overlaps = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        for (int[] doubleBooked : overlaps) {
            if (Math.max(startTime, doubleBooked[0]) < Math.min(endTime, doubleBooked[1])) {
                return false;
            }
        }
        
        for (int[] event : bookings) {
            if (Math.max(startTime, event[0]) < Math.min(endTime, event[1])) {
                overlaps.add(new int[]{
                    Math.max(startTime, event[0]), 
                    Math.min(endTime, event[1])
                });
            }
        }
        
        bookings.add(new int[]{startTime, endTime});
        return true;
    }
}