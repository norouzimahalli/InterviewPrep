package interview.prep;

import org.junit.Test;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Adunuthula on 4/13/2014.
 */
public class BlockingQueueTest {
    private ExecutorService executorService;
    private BlockingQueue<Integer> queue;

    @org.junit.Before
    public void setUp() throws Exception {
        executorService = Executors.newFixedThreadPool(BlockingQueue.QUEUE_MAXSIZE);
        queue = new BlockingQueue<Integer>();
    }

    @org.junit.After
    public void tearDown() throws Exception {
        executorService.shutdown();
        executorService.awaitTermination(60, TimeUnit.SECONDS);
        System.out.println("Thread pool shutdown");
    }

    @Test
    public void testProduceConsume() {
        //Producers
        for (int i = 0; i < BlockingQueue.QUEUE_MAXSIZE; i++) {
            Producer producer = new Producer(queue, i);
            executorService.execute(producer);
        }

        //Consume
        for (int i = 0; i < BlockingQueue.QUEUE_MAXSIZE; i++) {
            Consumer consumer = new Consumer(queue);
            executorService.execute(consumer);
        }

        for (int i = 0; i < BlockingQueue.QUEUE_MAXSIZE; i++) {
            Producer producer = new Producer(queue, i);
            executorService.execute(producer);
        }

        //Consume
        for (int i = 0; i < BlockingQueue.QUEUE_MAXSIZE; i++) {
            Consumer consumer = new Consumer(queue);
            executorService.execute(consumer);
        }
    }

    @Test
    public void testRandomProduceConsume() {
        for (int i = 0; i < 100; i++) {
            Random random = new Random();
            if (random.nextInt() % 2 == 0) {
                Producer producer = new Producer(queue, i);
                executorService.execute(producer);
            } else {
                Consumer consumer = new Consumer(queue);
                executorService.execute(consumer);
            }
        }
    }


    public class Producer implements Runnable {

        BlockingQueue<Integer> queue;
        Integer element;

        public Producer(BlockingQueue<Integer> q, int e) {
            queue = q;
            element = new Integer(e);
        }

        public void run() {
            System.out.println("Producer Thread: Enqueueing element " + element.intValue());
            queue.enqueue(element);
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                System.err.println(e);
            }

        }
    }

    public class Consumer implements Runnable {
        BlockingQueue<Integer> queue;

        public Consumer(BlockingQueue<Integer> q) {
            queue = q;
        }

        public void run() {
            Integer elem = queue.dequeue();
            System.out.println("Consumer Thread: Dequeueing element " + elem.intValue());
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                System.err.println(e);
            }

        }
    }


}
