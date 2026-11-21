public class ArrayCircularQueue {

    private int[] arr;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public ArrayCircularQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }

        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }

        rear = (rear + 1) % capacity;
        arr[rear] = value;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        int value = arr[front];
        front = (front + 1) % capacity;
        size--;

        if (size == 0) {
            front = 0;
            rear = -1;
        }

        return value;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        return arr[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue: ");

        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(arr[index] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        ArrayCircularQueue queue = new ArrayCircularQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        queue.display();

        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());

        queue.enqueue(50);
        queue.enqueue(60);

        queue.display();

        System.out.println("Front Element: " + queue.peek());
        System.out.println("Queue Size: " + queue.size());
    }
}
