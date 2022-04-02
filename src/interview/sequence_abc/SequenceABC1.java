package interview.sequence_abc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SequenceABC1 {
    private static Lock lock = new ReentrantLock();
    private static int state = 0;

    static class ThreadA extends Thread{
        @Override
        public void run() {
            for(int i = 0; i < 10;){
                lock.lock();
                if(state % 3 == 0){
                    System.out.print("A");
                    i++;
                    state++;
                }
                lock.unlock();
            }
        }
    }

    static class ThreadB extends Thread{
        @Override
        public void run() {
            for(int i = 0; i < 10;){
                lock.lock();
                if(state % 3 == 1){
                    System.out.print("B");
                    i++;
                    state++;
                }
                lock.unlock();
            }
        }
    }

    static class ThreadC extends Thread{
        @Override
        public void run() {
            for(int i = 0; i < 10;){
                lock.lock();
                if(state % 3 == 2){
                    System.out.print("C");
                    i++;
                    state++;
                }
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }
}