// Problem Statement
// Create a stack to maintain Plates in a birthday party. Ask the organizer how many Plates do they want initially.
// Maintain track of each plate used and number of Plates added.
// Finally print the number of total number of Plates in the stack,
// Plates used and number of Plates left in the stack

import java.util.ArrayList;

public class BA1 {
    public static void main(String[] args) {
        PlateStack plates = new PlateStack(20);

        for(int i = 0; i < 12; i++) {
            plates.takePlate();
        }

        System.out.println(
            "Plates used: " + plates.numUsed() +
            "\nPlates left: " + plates.numLeft() + 
            "\nTotal Plates: " + plates.numTotal());
    }
}

class Plate {
    int pid;
    long pd;
    Plate(int pid, long pd) {
        this.pid = pid;
        this.pd = pd;
    }
}

class PlateStack {
    private ArrayList<Plate> plates = new ArrayList<Plate>();
    private int num_plates;

    PlateStack(int num_plates) {
        this.num_plates = num_plates;
        for(int i = 0; i < num_plates; i++) {
            plates.add(new Plate(i, System.nanoTime()));
        }
    }

    public Plate takePlate() throws IndexOutOfBoundsException{
        if (plates.size() == 0) throw new IndexOutOfBoundsException("No Plate left");
        return plates.remove(plates.size() - 1);
    }

    public void putPlate(Plate p) throws IndexOutOfBoundsException{
        if (plates.size() == num_plates) throw new IndexOutOfBoundsException("Can't add more plates");
        plates.add(p);
    }

    public int numUsed() {
        return num_plates - plates.size();
    }

    public int numTotal() {
        return num_plates;
    }

    public int numLeft() {
        return plates.size();
    }
}