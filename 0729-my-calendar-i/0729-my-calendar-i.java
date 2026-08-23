import java.util.*;

class MyCalendar {
    TreeMap<Integer, Integer> calendar;

    public MyCalendar() {
        calendar = new TreeMap<>();
    }

    public boolean book(int startTime, int endTime) {
        Integer prev = calendar.floorKey(startTime);
        Integer next = calendar.ceilingKey(startTime);

        if ((prev == null || calendar.get(prev) <= startTime) && 
            (next == null || next >= endTime)) {
            calendar.put(startTime, endTime);
            return true;
        }
        return false;
    }
}