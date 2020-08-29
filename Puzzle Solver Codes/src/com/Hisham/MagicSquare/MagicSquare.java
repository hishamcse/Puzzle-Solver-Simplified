package com.Hisham.MagicSquare;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

public class MagicSquare {

//    Generates a magic square of order n. A magic squares is an n-by-n
// *  matrix of the integers 1 to n^2, such that all row, column, and
// *  diagonal sums are equal.
// *
// *  One way to generate a magic square when n is odd is to assign
// *  the integers 1 to n^2 in ascending order, starting at the
// *  bottom, middle cell. Repeatedly assign the next integer to the
// *  cell adjacent diagonally to the right and down. If this cell
// *  has already been assigned another integer, instead use the
// *  cell adjacently above. Use wrap-around to handle border cases.

    // limitations - n must be odd

    public static void main(String[] args) {
        int n = Integer.parseInt(StdIn.readLine());
        if (n % 2 == 0) throw new RuntimeException("n must be odd");

        int[][] magic = new int[n][n];

        if (n > 10) {
            StdDraw.setCanvasSize(750, 750);
        } else {
            StdDraw.setCanvasSize(500, 500);
        }
        MagicVisualizer.drawGrid(n);
        MagicVisualizer.drawNumbers(magic, n);
        StdDraw.pause(1500);

        int row = n - 1;
        int col = n / 2;
        magic[row][col] = 1;

        for (int i = 2; i <= n * n; i++) {
            if (magic[(row + 1) % n][(col + 1) % n] == 0) {
                row = (row + 1) % n;
                col = (col + 1) % n;
            } else {
                row = (row - 1 + n) % n;
                // don't change col
            }
            magic[row][col] = i;
        }

        // print results
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (magic[i][j] < 10) System.out.print(" ");  // for alignment
                if (magic[i][j] < 100) System.out.print(" ");  // for alignment
                System.out.print(magic[i][j] + " ");
            }
            System.out.println();
        }

        MagicVisualizer.drawGrid(n);
        MagicVisualizer.drawNumbers(magic, n);

    }
}
