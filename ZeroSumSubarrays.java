import java.util.*;

class ZeroSumSubarrays {
    public static void findZeroSumSubarrays(int[] arr) {
        // Map to store (cumulative sum -> list of indices)
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        int sum = 0; // Cumulative sum

        // Initialize map with (0 -> [-1]) to handle zero sum from start
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]; // Update cumulative sum

            // If sum was seen before, subarrays exist
            if (map.containsKey(sum)) {
                for (int start : map.get(sum)) {
                    result.add(Arrays.asList(start + 1, i)); // Store subarray indices
                }
            }

            // Store index in the map for the current sum
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }

        // Print the subarrays
        if (result.isEmpty()) {
            System.out.println("No zero-sum subarrays found.");
        } else {
            System.out.println("Zero-sum subarrays:");
            for (List<Integer> subarray : result) {
                System.out.println("Start: " + subarray.get(0) + ", End: " + subarray.get(1));
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2}; // Example array
        findZeroSumSubarrays(arr);
    }
}
