package BP9;

// Problem Statement
/*
Use ragged array to provide the output given below
        1
        1 2
        1 2 3
        1 2 3 4
        1 2 3 4 5
        1
      1 2
    1 2 3
  1 2 3 4
1 2 3 4 5
*/

public class BP9 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        int[][] array = new int[2 * n][];

        for(int i = 0; i < n; i++) {
            array[i] = new int[array.length];
            array[i + n] = new int[array.length - 1];
            for (int j = 0; j <= i; j++) {
                array[i][n + j - 1] = j + 1;
                array[i + n][n - j - 1] = n - j;
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length - 1; j++) {
                if (array[i][j] == 0) System.out.print("  ");
                else System.out.printf("%d ", array[i][j]);
            }
            System.out.print("\n");
        }

    }
}
