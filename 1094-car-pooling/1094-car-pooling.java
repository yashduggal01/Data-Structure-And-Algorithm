class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] stops = new int[1001];

        // Process net passenger changes at each location
        for (int[] trip : trips) {
            int numPassengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            stops[from] += numPassengers; // Passengers get on
            stops[to] -= numPassengers;   // Passengers get off
        }

        int currentPassengers = 0;
        
        // Accumulate passenger count along the route
        for (int passengers : stops) {
            currentPassengers += passengers;
            if (currentPassengers > capacity) {
                return false;
            }
        }

        return true;
    }
}