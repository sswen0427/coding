package interview;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Consumer extends Thread {

    Lock lock;
    Deque<Integer> queue;
    Condition product;
    Condition consumer;

    public Consumer(Deque<Integer> list, Lock lock, Condition product, Condition consumer) {
        this.queue = list;
        this.lock = lock;
        this.product = product;
        this.consumer = consumer;
    }

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                while (queue.isEmpty()) {
                    try {
                        consumer.await();
                    } catch (Exception e) {
                    }
                }
                for (int i = 0; i < 10; i++) {
                    System.out.println("consume " + queue.pollFirst());
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                }catch (Exception e){

                }
                product.signal();
            }finally {
                lock.unlock();
            }
        }
    }
}

class Product extends Thread{
    Deque<Integer> queue;
    Lock lock;
    Condition product;
    Condition consumer;
    public Product(Deque<Integer> list, Lock lock, Condition product, Condition consumer){
        this.queue = list;
        this.lock = lock;
        this.product = product;
        this.consumer = consumer;
    }
    @Override
    public void run(){
        while (true) {
            lock.lock();
            try {
                while (!queue.isEmpty()) {
                    try {
                        product.await();
                    }catch (Exception e){

                    }
                }
                for (int i = 0; i < 10; i++) {
                    queue.addLast(i);
                    System.out.println("preduce " + i);
                }
                consumer.signal();
            }finally {
                lock.unlock();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        Lock lock = new ReentrantLock();
        Condition production = lock.newCondition();
        Condition consumer = lock.newCondition();

        new Consumer(deque, lock, production, consumer).start();
        new Product(deque, lock, production, consumer).start();
    }
}
