import java.util.PriorityQueue;

public class PrioQueue<T> {
    private PriorityQueue<T> queue;

    public PrioQueue() {
        queue = new PriorityQueue<T>();
    }

    public void add(T item) {
        queue.offer(item);
    }

    public T remove() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    public T peek() {
        return queue.peek();
    }

    public static void main(String[] args) {
        PrioQueue<Integer> queue = new PrioQueue<Integer>();

        queue.add(5);
        queue.add(3);
        queue.add(8);
        queue.add(2);
        queue.add(9);

        System.out.println("Queue size: " + queue.size());

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }
}

