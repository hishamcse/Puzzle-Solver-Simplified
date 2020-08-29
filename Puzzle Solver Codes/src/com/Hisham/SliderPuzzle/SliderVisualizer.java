package com.Hisham.SliderPuzzle;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

public class SliderVisualizer {

    private static final int WINDOW_SIZE = 300;

    public static void drawGrid(int[][] board,int n) {
        double squareLength = 0.5 / n;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if(board[i][j]!=0) {
                    StdDraw.setPenColor(Color.LIGHT_GRAY);
                }else{
                    StdDraw.setPenColor(Color.WHITE);
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

    public static void drawNumbers(int[][] board, int n) {
        double squareLength = 0.5 / n;
        Font font = new Font("Helvetica", Font.PLAIN, 30);
        StdDraw.setFont(font);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 0) {
                    StdDraw.setPenColor(Color.BLACK);
                    font = new Font("Helvetica", Font.BOLD, 30);
                } else {
                    StdDraw.setPenColor(Color.RED);
                    font = new Font("Helvetica", Font.PLAIN, 30);
                }
                StdDraw.setFont(font);
                StdDraw.text(2 * i * squareLength + squareLength, 2 * (n - 1 - j) * squareLength + squareLength, Integer.toString(board[i][j]));
            }
    }
}
