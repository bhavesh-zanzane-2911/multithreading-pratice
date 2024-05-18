package org.bhavesh.multithreading.practice;

public class DeadLockExample {


    static final String r1 = "Hellow";
    static final String r2 = "World";

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {

            synchronized (r1) {
                System.out.println("Thread 1 Acquired a lock on r1" + r1);

                synchronized (r2) {
                    System.out.println("Thread 1 Trying to get a lock on r2" + r2);
                }
            }
        });


        Thread t2 = new Thread(() -> {
            synchronized (r2) {

                System.out.println("Thread 2 Acquired a lock on r2" + r2);

                synchronized (r1) {
                    System.out.println("Thread 2 Trying to get a lock on r1" + r1);
                }
            }
        });

        //Start threads
        t1.start();
        t2.start();


    }
}
