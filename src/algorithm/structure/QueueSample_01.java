package algorithm.structure;

import java.util.Scanner;

/**
 * @author Jim, Kim
 * @since 2019-06-01
 */
interface queue {
    boolean isEmpty();
    boolean isFull();
    void clear();
    void enqueue(String data);
    String dequeue();
    String peek();
}

public class QueueSample_01 implements queue {

    int front;
    int rear;
    int queueSize;
    String[] queue;

    public QueueSample_01(int queueSize) {
        this.front = -1;
        this.rear = -1;
        this.queueSize = queueSize;
        queue = new String[queueSize];
    }

    @Override
    public boolean isEmpty() {
        if (this.front == this.rear) {
            // front와 rear가 같다면, 데이터가 없는 상태이므로 모두 -1로 설정
            this.front = -1;
            this.rear = -1;
        }
        return this.front == this.rear;
    }

    @Override
    public boolean isFull() {
        // rear가 queueSize - 1과 같다면 모두 차여있는 상태
        return this.rear == this.queueSize - 1;
    }

    @Override
    public void clear() {
        this.front = -1;
        this.rear = -1;
        this.queue = new String[this.queueSize];
    }

    @Override
    public void enqueue(String data) {
        if (isFull()) {
            System.out.println("Queue is already full!");
        } else {
            this.queue[++rear] = data;
        }
    }

    @Override
    public String dequeue() {
        if (isEmpty()) {
            System.out.println("dequeue fail! Queue is already empty!");
            return "empty";
        } else {
            this.front = (this.front + 1) % this.queueSize;
            return this.queue[this.front];
        }
    }

    @Override
    public String peek() {
        if (isEmpty()) {
            System.out.println("peek fail! Queue is already empty!");
            return "empty";
        } else {
            return this.queue[this.front + 1];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int queueSize = sc.nextInt();

        QueueSample_01 queue = new QueueSample_01(queueSize);

        for (int i = 0; i < queueSize; i++) {
            String data = sc.next();
            queue.enqueue(data);
        }

        System.out.println("----------peek test---------");
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println("----------dequeue test---------");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
