package com.Hisham.NRooks;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class NRooks {

//    How many ways are there to place N rooks on an N-by-N board so that
//    no rook can attack any other and show all the answers?

    private final int n;
    private final int[] a;
    private boolean[][] result;
    private int counter;  // counting the number of permutation possible for placing rooks

    public NRooks(int n) {
        this.n = n;
        counter = 0;
        a = new int[n];
        result = new boolean[n][n];

        int WINDOW_SIZE;
        if (n > 10) {
            WINDOW_SIZE = 750;
        } else {
            WINDOW_SIZE = 500;
        }

        StdDraw.setCanvasSize(WINDOW_SIZE, WINDOW_SIZE);
        NRooksVisualizer.drawGrid(result, n);
        NRooksVisualizer.drawNumbers(result, n);

        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
        enumerate(0);
    }

    private void process() {
        result = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StdOut.print(a[i] + " ");
            result[i][a[i]] = true;
        }
        StdOut.println();
        counter++;
        NRooksVisualizer.drawGrid(result, n);
        NRooksVisualizer.drawNumbers(result, n);
        StdDraw.pause(1500);
    }

    private void enumerate(int k) {
        if (k == n) {
            process();
            return;
        }
        for (int i = k; i < n; i++) {
            swap(k, i);
            enumerate(k + 1);
            swap(i, k);          // clean up so that in the next permutation it can commence from the start
        }
    }

    public int getCounter() {
        return counter;
    }

    private void swap(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        NRooks nRooks = new NRooks(n);
        System.out.println(nRooks.getCounter());
    }

}
