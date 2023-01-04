/*
It is not guaranteed that the application will always print out "Mares do eat oats."
This is because the value of the message1 variable may not be visible to the main thread
due to the way that threads and memory work in Java.

In this case, the value of the message1 variable is being modified by the CorrectorThread1
in a separate thread, and this value may not be immediately visible to the main thread.
This is because each thread has its own memory space,
and changes made by one thread are not always immediately visible to other threads.

To guarantee that all changes to the message1 variable will be visible in the main thread,
you can use one of the following methods:

    1.  Use the synchronized keyword to synchronize access to the message1 variable.
        This will ensure that only one thread can access the message1 variable at a time,
        which will prevent any race conditions or inconsistencies.
    2.  Use the volatile keyword to mark the message1 variable as volatile.
        This will ensure that any changes made to the message1 variable are
        immediately visible to all threads.
    3.  Use the AtomicReference class to store the message1 variable.
        This will provide atomic access to the message1 variable,
        which will ensure that all changes to the variable are immediately visible to all threads.

Changing the parameters of the sleep method calls will not guarantee that
all changes to the message1 variable will be visible in the main thread.
These methods are used to pause the execution of a thread for a certain period of time,
and they do not have any effect on the visibility of variables between threads.
*/

// 

import java.util.concurrent.atomic.AtomicReference;

public class DP7 {
    public static void main(String[] args) {
        try {
            BadThreads.run();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class BadThreads {
    static String message1;
    static volatile String message2;
    static AtomicReference<String> message3 = new AtomicReference<>();

    private static class CorrectorThread extends Thread {
        public void run() {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
            }
            // Key statement 1:
            synchronized (BadThreads.class) {
                message1 = "Mares do eat oats.";
            }
            message2 = "Mares do eat oats.";
            message3.set("Mares do eat oats.");
        }
    }

    public static void run() throws InterruptedException {
        (new CorrectorThread()).start();
        synchronized (BadThreads.class) {
            message1 = "Mares do not eat oats.";
        }
        message3.set("Mares do not eat oats.");
        Thread.sleep(2000);
        // Key statement 2:
        synchronized (BadThreads.class) {
            System.out.println(message1);
        }
        System.out.println(message2);
        System.out.println(message3.get());
    }
}

/*
 * This code includes four different variables
 * message1, message2, message3, and message3,
 * each of which is synchronized using a different method:
 * 
 * 1. message1 is synchronized using the synchronized keyword.
 * 2. message2 is marked as volatile.
 * 3. message3 is stored in an AtomicReference object.
 * 
 * The CorrectorThread class modifies all four variables,
 * and the main thread prints out their values after a two-second delay.
 * With this code, all four variables should always have the value
 * "Mares do eat oats."
 */