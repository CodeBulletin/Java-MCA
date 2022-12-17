// Problem Statement
// Sudoku is a 9 X 9 grid divided into smaller 3 X 3 boxes (also called regions or blocks).
// Fill the empty cells, also called free cells, with numbers 1 to 9 so that every row,
// every column, and every 3 X 3 box contains the numbers 1 to 9

public class BA2 {
    public static void main(String[] args) {
        SudokuBoard board = new SudokuBoard();

        SudokuSolver solver = new SudokuSolver(board);

        solver.solve();

        System.out.println(board);
    }
}

class Pair {
    public int x, y;
}

class SudokuBoard {
    Integer[][] board = new Integer[9][9];

    public Integer getAt(int x, int y) {
        return board[x][y];
    }

    public void setAt(int x, int y, Integer value) {
        this.board[x][y] = value;
    }

    @Override
    public String toString() {
        String str = "";
        for(Integer[] i : board) {
            for(Integer j : i) {
                str += j;
                str += " ";
            }
            str += "\n";
        }
        return str;
    }
}

class SudokuSolver {
    SudokuBoard board;

    SudokuSolver(SudokuBoard board) {
        this.board = board;
    }

    public boolean find_null(Pair p) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board.getAt(i, j) == null) {
                    p.x = i;
                    p.y = j;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSafe(int x, int y, Integer num) {
        for(int i = 0; i < 9; i++) {
            if(board.getAt(x, i) == num) return false;
        }

        for(int i = 0; i < 9; i++) {
            if(board.getAt(i, y) == num) return false;
        }

        int nx = 3 * (x / 3);
        int ny = 3 * (y / 3);

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board.getAt(nx + i, ny + j) == num) return false;
            }
        }

        return true;
    }

    public boolean solve() {
        Pair pos = new Pair();

        if(!find_null(pos)) return true;

        for(int i = 0; i < 9; i++) {
            if(isSafe(pos.x, pos.y, i + 1)) {
                board.setAt(pos.x, pos.y, i + 1);
                if(solve()) return true;
                board.setAt(pos.x, pos.y, null);
            }
        }

        return false;
    }
}