package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue {
    private List<Integer> container = new ArrayList<>();
    private Lock lock = new ReentrantLock();

    private Condition isNull = lock.newCondition();
    private Condition isFull = lock.newCondition();
    private volatile int size;
    private volatile int capacity;

    BlockingQueue(int capacity){
        this.capacity = capacity;
    }

    public void add(int data){
        try {
            lock.lock();
            try {
                while (size >= capacity){
                    System.out.println("队列已满，释放锁，等待消费者消费数据");
                    isFull.await();
                }
            }catch (InterruptedException e){
                isFull.signal();
                e.printStackTrace();
            }
            ++size;
            container.add(data);
            isNull.signal();
            System.out.println("生产" + data);
        }finally {
            lock.unlock();
        }
    }

    public int take(){
        try {
            lock.lock();
            try {
                while (size == 0){
                    System.out.println("阻塞队列空了，释放锁，等待生产者生产数组");
                    isNull.await();
                }
            }catch (InterruptedException e){
                isFull.signal();
                e.printStackTrace();
            }
            --size;
            int res = container.get(0);
            container.remove(0);
            isFull.signal();
            System.out.println("消费" + res);
            return res;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        BlockingQueue queue = new BlockingQueue(5);
        Thread thread1 = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                queue.add(i);
            }
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(()->{
            for(;;){
                queue.take();
                try {
                    Thread.sleep(800);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
