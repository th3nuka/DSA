
import java.util.Stack;

public class StackQueueDequeueFriendly {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public void enqueue(int value) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        s1.push(value);

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public int dequeue() {
        if (s1.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        return s1.pop();
    }

    public int peek() {
        if (s1.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        return s1.peek();
    }

    public boolean isEmpty() {
        return s1.isEmpty();
    }

    public int size() {
        return s1.size();
    }

    public static void main(String[] args) {

        StackQueueDequeueFriendly queue = new StackQueueDequeueFriendly();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Peek: " + queue.peek());

        queue.enqueue(40);

        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());

        System.out.println("Is Empty: " + queue.isEmpty());
    }
}
