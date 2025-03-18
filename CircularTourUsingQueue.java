import java.util.LinkedList;
import java.util.Queue;

class CircularTourUsingQueue {
    // Function to find the starting petrol pump index
    public static int findStartingPoint(int[] petrol, int[] distance) {
        int n = petrol.length;
        Queue<Integer> queue = new LinkedList<>();
        int surplus = 0, deficit = 0, startIndex = 0;

        for (int i = 0; i < n; i++) {
            surplus += petrol[i] - distance[i];
            queue.offer(i); // Add pump to the queue

            // If we run out of fuel, remove elements from the queue
            while (surplus < 0 && !queue.isEmpty()) {
                int removed = queue.poll();
                deficit += petrol[removed] - distance[removed]; // Store deficit
                surplus = 0; // Reset surplus
                startIndex = removed + 1; // Move start index forward
            }
        }

        // If total fuel collected is enough to cover the deficit, return startIndex
        return (surplus + deficit >= 0) ? startIndex : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int start = findStartingPoint(petrol, distance);
        System.out.println(start == -1 ? "No valid start point" : "Start at pump index: " + start);
    }
}
