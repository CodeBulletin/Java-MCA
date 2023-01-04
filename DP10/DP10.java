import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DP10 {
    public static void main(String[] args) {
        // Create an ArrayList of numbers
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(3);
        numbers.add(8);
        numbers.add(1);
        numbers.add(9);
        numbers.add(4);

        // Create a thread to sort the list in ascending order
        Thread ascendingThread = new SortThread(numbers, true);
        // Create a thread to sort the list in descending order
        Thread descendingThread = new SortThread(numbers, false);

        // Start both threads
        ascendingThread.start();
        try {
            ascendingThread.join();
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
        descendingThread.start();
    }
}

class SortThread extends Thread {
    private List<Integer> list;
    private boolean ascending;

    public SortThread(List<Integer> list, boolean ascending) {
        this.list = list;
        this.ascending = ascending;
    }

    public synchronized void sort() {
        if (ascending) {
            Collections.sort(list);
        } else {
            Collections.sort(list, Collections.reverseOrder());
        }
    }

    @Override
    public void run() {
        sort();
        System.out.println(list);
    }
}
