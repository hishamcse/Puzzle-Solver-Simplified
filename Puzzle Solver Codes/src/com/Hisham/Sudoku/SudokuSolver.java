package com.Hisham.Sudoku;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

public class SudokuSolver {

    private final int[] a;
    private boolean solved;
    private final int[][] initialSudoku;

    public SudokuSolver(int[] a) {
        this.a = a;

        initialSudoku = new int[9][9];
        setInitialSudoku();
        process();

        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                enumerate(i);
            }
        }
    }

    private void setInitialSudoku() {
        int j = -1;
        for (int i = 0; i < a.length; i++) {
            if (i % 9 == 0) {
                j++;
            }
            initialSudoku[j][i % 9] = a[i];
        }
    }

    private void process() {
        int[][] sudoku = new int[9][9];
        int j = -1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            if (i > 0 && i % 9 != 0) {
                builder.append(a[i]).append(" ");
                sudoku[j][i % 9] = a[i];
            } else {
                j++;
                sudoku[j][i % 9] = a[i];
                builder.append("\n").append(a[i]).append(" ");
            }
        }
        builder.append("\n");
        System.out.println(builder.toString());
        SudokuVisualizer.drawGrid(initialSudoku, sudoku);
        SudokuVisualizer.drawNumbers(initialSudoku, sudoku);
        StdDraw.pause(1500);
    }

    private void enumerate(int k) {

        if (solved) return;

        // found a solution
        if (k == 81) {
            solved = true;
            process();
            return;
        }

        // cell k initially filled in; recur on next cell
        if (a[k] != 0) {
            enumerate(k + 1);
            return;
        }

        for (int r = 1; r <= 9; r++) {      // try 9 possible digits for cell k
            a[k] = r;
            if (!canBacktrack(k)) {         // unless it violates a Sudoku constraint
                enumerate(k + 1);
            }
        }
        a[k] = 0;         // clean up
    }

    private boolean canBacktrack(int k) {
        // Row
        int row = k / 9;
        for (int i = row * 9; i < row * 9 + 9; i++) {
            if (i != k) {
                if (a[i] == a[k]) {
                    return true;
                }
            }
        }
        // Column
        int column = k % 9;
        for (int i = column; i < 81; i += 9) {
            if (i != k) {
                if (a[i] == a[k]) {
                    return true;
                }
            }
        }

        // first find the starting point of box with 'k' in it.
        int box_row = boxRow(k);
        int box_column = boxColumn(k);
        for (int i = box_row; i < box_row + 3; i++) {
            for (int j = box_column; j < box_column + 3; j++) {
                int l = i * 9 + j;
                if (l != k) {
                    if (a[l] == a[k]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private int boxRow(int k) {
        int val = k / 9;
        int val2 = val / 3;
        return val2 * 3;
    }

    private int boxColumn(int k) {
        int val = k % 9;
        int val2 = val / 3;
        return val2 * 3;
    }

    public static void main(String[] args) {
        int i = 0;
        int[] a = new int[81];
        String line;

        In reader = new In(StdIn.readLine());
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            String[] b = line.split(" ");
            for (String val : b) {
                a[i++] = Integer.parseInt(val);
            }
        }
        new SudokuSolver(a);
    }

}
