/*9 )Write a Java program that implements a producer-consumer model using
multithreading. The program should have a producer thread that generates random
numbers and adds them to a queue, and a consumer thread that reads numbers
from the queue and calculates their sum. The program should use synchronization to
ensure that the queue is accessed by only one thread at a time.
 */




package in.ineuron.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProducerConsumer {
    private static final int Max_Capacity = 10;
    private static final int Max_Numbers = 20;

    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        Thread producerThread = new Thread(new Producer());
        Thread consumerThread = new Thread(new Consumer());

        producerThread.start();
        consumerThread.start();
    }

    static class Producer implements Runnable {
        private Random random = new Random();

        @Override
        public void run() {
            for (int i = 0; i < Max_Numbers; i++) {
                try {
                    produce(i);
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private synchronized void produce(int number) throws InterruptedException {
            while (queue.size() == Max_Capacity) {
                wait();
            }

            queue.offer(number);
            System.out.println("Produced: " + number);

            notify();
        }
    }

    static class Consumer implements Runnable {
        private int sum = 0;

        @Override
        public void run() {
            for (int i = 0; i <Max_Numbers; i++) {
                try {
                    sum += consume();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Total sum: " + sum);
        }

        private synchronized int consume() throws InterruptedException {
            while (queue.isEmpty()) {
                wait();
            }

            int number = queue.poll();
            System.out.println("Consumed: " + number);

            notify();

            return number;
        }
    }
}


