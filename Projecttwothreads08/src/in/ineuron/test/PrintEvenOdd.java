/*Write a Java program that creates two threads. The first thread should print even
numbers between 1 and 10, and the second thread should print odd numbers
between 1 and 10
 */




package in.ineuron.test;

public class PrintEvenOdd {
    public static void main(String[] args) {
        Thread t1 = new Thread(new EvenPrinter());
        Thread t2 = new Thread(new OddPrinter());

        t1.start();
        t2.start();
    }
}

class EvenPrinter implements Runnable {
    @Override
    public void run() {
        for (int i = 2; i <= 10; i += 2) {
            System.out.println("Even: " + i);
        }
    }
}

class OddPrinter implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i += 2) {
            System.out.println("Odd: " + i);
        }
    }
}
