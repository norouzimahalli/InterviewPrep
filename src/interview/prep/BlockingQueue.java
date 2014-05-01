package interview.prep;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Adunuthula on 4/13/2014.
 */
public class BlockingQueue<T> {
    private Queue<T> queue = new LinkedList<T>();
    private Object lock = new Object();
    public static int QUEUE_MAXSIZE = 5;

    public void enqueue(T elem) {
        synchronized (lock) {
            while (queue.size() >= QUEUE_MAXSIZE) {
                try {
                    System.out.println("Waiting for a slot in the queue: " + elem);
                    lock.wait();
                } catch (InterruptedException ie) {
                    //log interrupted exception
                }
            }

            System.out.println("Enqueue item ..." + elem);
            queue.add(elem);
            lock.notifyAll();

        }
    }


    public T dequeue() {
        synchronized (lock) {
            while (queue.size() == 0) {
                try {
                    System.out.println("Waiting to dequeue ...");
                    lock.wait();
                } catch (InterruptedException ie) {
                    //log interrupted exception
                }
            }

            T elem = queue.remove();
            System.out.println("Dequeued item ..." + elem);
            lock.notifyAll();
            return elem;
        }
    }
}
