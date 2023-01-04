import java.util.LinkedList;

public class DP8 {
    public static void main(String[] args) {
        Queue<Integer> product_queue = new Queue<Integer>(5);

        Producer p = new Producer(product_queue);
        Consumer c = new Consumer(product_queue);

        p.start();
        c.start();
    }
}

class Queue<T> extends LinkedList<T> {
    private int qsize;
    Queue (int size) {
        this.qsize = size;
    }

    public int qSize() {
        return qsize;
    }

    @Override
    public boolean add(T o) {
        while (this.size() == this.qsize) {
            return false;
        }
        super.add(o);
        return true;
    }
}

class Producer extends Thread {
    private Queue<Integer> queue;

    Producer (Queue<Integer> queue) {
        this.queue = queue;
    }

    synchronized boolean add(Integer i) {
        System.out.println("Producer: " + i);
        return queue.add(i);
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 10) {
            if (add(i))
                i++;
            try {
                Thread.sleep(10);
            }
            catch (Exception e) {
                System.err.println(e);
            }
        }
    }
}

class Consumer extends Thread {
    private Queue<Integer> queue;
    int consumed_no;

    Consumer (Queue<Integer> queue) {
        this.queue = queue;
        this.consumed_no = 0;
    }

    synchronized void consume() {
        System.out.println("Consumer: " + queue.remove());
        this.consumed_no += 1;
    }

    @Override
    public void run() {
        while(consumed_no < 10) {
            if(queue.size() != 0) consume();
            try {
                Thread.sleep(10);
            }
            catch (Exception e) {
                System.err.println(e);
            }
        }
    }
}
