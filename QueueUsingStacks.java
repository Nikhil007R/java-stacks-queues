import java.util.Stack;

class QueueUsingStacks {
    private Stack<Integer> s1; // Stack for enqueue
    private Stack<Integer> s2; // Stack for dequeue

    // Constructor
    public QueueUsingStacks() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    // Enqueue operation
    public void enqueue(int item) {
        s1.push(item);
    }

    // Dequeue operation
    public int dequeue() {
        if (s2.isEmpty()) {
            if (s1.isEmpty()) {
                throw new RuntimeException("Queue is empty!");
            }
            // Move elements from s1 to s2
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    // Peek operation
    public int peek() {
        if (s2.isEmpty()) {
            if (s1.isEmpty()) {
                throw new RuntimeException("Queue is empty!");
            }
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println(queue.dequeue()); // 10
        System.out.println(queue.peek());    // 20
        System.out.println(queue.dequeue()); // 20
        System.out.println(queue.isEmpty()); // false
        System.out.println(queue.dequeue()); // 30
        System.out.println(queue.isEmpty()); // true
    }
}
