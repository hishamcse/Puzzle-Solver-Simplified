package com.Hisham.Sudoku;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

public class SudokuVisualizer {

    private static final int WINDOW_SIZE = 500;
    private static final double CELL_LENGTH = 0.5 / 9;

    // draw sudoku numbers on the grid
    public static void drawNumbers(int[][] initialSudoku,int[][] sudoku) {
        Font font = new Font("Helvetica", Font.PLAIN, 20);
        StdDraw.setFont(font);
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                if (initialSudoku[j][i] != 0)
                    font = new Font("Helvetica", Font.BOLD, 20);
                else
                    font = new Font("Helvetica", Font.PLAIN, 20);
                StdDraw.setFont(font);
                StdDraw.text(2 * i * CELL_LENGTH + CELL_LENGTH, 2 * (8 - j) * CELL_LENGTH + CELL_LENGTH, Integer.toString(sudoku[j][i]));
            }
        }
    }

    // draw sudoku grid
    public static void drawGrid(int[][] initialSudoku,int[][] sudoku) {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                if (initialSudoku[j][i] == 0)
                    StdDraw.setPenColor(Color.WHITE);
                else
                    StdDraw.setPenColor(Color.LIGHT_GRAY);
                StdDraw.filledSquare(2 * i * CELL_LENGTH + CELL_LENGTH, 2 * (8 - j) * CELL_LENGTH + CELL_LENGTH, CELL_LENGTH);
            }
        }

        StdDraw.setPenColor(Color.BLACK);
        for (int i = 0; i < sudoku.length; i++) {
            if (i % 3 == 0 && i != 0)
                StdDraw.setPenRadius(5 / (double) WINDOW_SIZE);
            else
                StdDraw.setPenRadius(1 / (double) WINDOW_SIZE);
            StdDraw.line(CELL_LENGTH * 2 * i, 0, CELL_LENGTH * 2 * i, 1);
            StdDraw.line(0, CELL_LENGTH * 2 * i, 1, CELL_LENGTH * 2 * i);
        }
    }
}
