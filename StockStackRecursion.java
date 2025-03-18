import java.util.Stack;

class SortStackRecursively {

    // Method to sort the stack using recursion
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop(); // Pop the top element
            sortStack(stack); // Recursively sort the remaining stack
            insertInSortedOrder(stack, top); // Insert the popped element at the correct position
        }
    }

    // Helper method to insert an element in a sorted order
    private static void insertInSortedOrder(Stack<Integer> stack, int value) {
        if (stack.isEmpty() || stack.peek() <= value) {
            stack.push(value);
            return;
        }
        int temp = stack.pop(); // Pop the top element
        insertInSortedOrder(stack, value); // Recursively insert the value
        stack.push(temp); // Push the popped element back
    }

    // Main method for testing
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(4);

        System.out.println("Original Stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted Stack: " + stack);
    }
}
