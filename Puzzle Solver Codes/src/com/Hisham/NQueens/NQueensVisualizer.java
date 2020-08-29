package com.Hisham.NQueens;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

public class NQueensVisualizer {

    private static int WINDOW_SIZE;

    public static void drawGrid(boolean[][] board, int n) {
        if (n > 10) {
            WINDOW_SIZE = 750;
        } else {
            WINDOW_SIZE = 500;
        }
        double squareLength = 0.5 / n;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (!board[i][j]) {
                    StdDraw.setPenColor(Color.LIGHT_GRAY);
                } else {
                    StdDraw.setPenColor(Color.PINK);
                }
                StdDraw.filledSquare(2 * i * squareLength + squareLength, 2 * (n - 1 - j) * squareLength + squareLength, squareLength);
            }

        StdDraw.setPenColor(Color.BLACK);
        for (int i = 0; i < n; i++) {
            if (i % n == 0 && i != 0)
                StdDraw.setPenRadius(5 / (double) WINDOW_SIZE);
            else
                StdDraw.setPenRadius(1 / (double) WINDOW_SIZE);
            StdDraw.line(squareLength * 2 * i, 0, squareLength * 2 * i, 1);
            StdDraw.line(0, squareLength * 2 * i, 1, squareLength * 2 * i);
        }
    }

    public static void drawNumbers(boolean[][] board, int n) {
        if (n > 10) {
            WINDOW_SIZE = 750;
        } else {
            WINDOW_SIZE = 500;
        }
        double squareLength = 0.5 / n;
        Font font = new Font("Helvetica", Font.PLAIN, WINDOW_SIZE / (n * 4));
        StdDraw.setFont(font);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                double v = 2 * (n - 1 - j) * squareLength + squareLength;
                if (!board[i][j]) {
                    StdDraw.setPenColor(Color.BLACK);
                    font = new Font("Helvetica", Font.BOLD, WINDOW_SIZE / (n * 3));
                    StdDraw.setFont(font);
                    StdDraw.text(2 * i * squareLength + squareLength, v, Integer.toString(0));
                } else {
                    StdDraw.setPenColor(Color.WHITE);
                    font = new Font("Helvetica", Font.PLAIN, WINDOW_SIZE / (n * 3));
                    StdDraw.setFont(font);
                    StdDraw.text(2 * i * squareLength + squareLength, v, "Q");
                }
            }
    }
}
