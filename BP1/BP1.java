package BP1;

// Problem Statement
//A group of BVICAM friends decide to run the Airtel Delhi Half Marathon.
//Their names and times (in minutes) are below:
/*
Name        Time (minutes)
Elena           341
Thomas          273
Hamilton        278
Suzie           329
Phil            445
Matt            402
Alex            388
Emma            275
John            243
James           334
Jane            412
*/
public class BP1 {
    public static void main(String[] args) {
        Runner[] runners = new Runner[] { 
            new Runner("Elena", 341),
            new Runner("Thomas", 273),
            new Runner("Hamilton", 278),
            new Runner("Suzie", 329),
            new Runner("Phil", 445),
            new Runner("Matt", 402),
            new Runner("Alex", 388),
            new Runner("Emma", 275),
            new Runner("John", 243),
            new Runner("James", 334),
            new Runner("Jane", 412)
        };

        int min = runners[0].getMinutes();
        int idx = 0;
        for (int i = 1; i < runners.length; i++) {
            if (min > runners[i].getMinutes()) {
                min = runners[i].getMinutes();
                idx = i;
            }
        }

        min = runners[0].getMinutes();
        int idx2 = 0;
        for (int i = 1; i < runners.length; i++) {
            if (min > runners[i].getMinutes() && i != idx) {
                min = runners[i].getMinutes();
                idx2 = i;
            }
        }

        System.out.println("fastest runner: " + runners[idx]);
        System.out.println("second fastest runner: " + runners[idx2]);
    }
}


class Runner {
    private String name;
    private int minutes;

    Runner(String name, int minutes) {
        this.name = name;
        this.minutes = minutes;
    }

    int getMinutes() {
        return minutes;
    }

    String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Runner{" + "Name:" + name + ", minutes:" + minutes + "}";
    }
}
