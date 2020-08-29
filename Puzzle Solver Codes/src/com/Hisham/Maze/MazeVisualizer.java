package com.Hisham.Maze;

import edu.princeton.cs.algs4.StdDraw;

public class MazeVisualizer {

    public static void initDraw(int n) {
        StdDraw.setXscale(0, n + 2);
        StdDraw.setYscale(0, n + 2);
    }

    public static void draw(int n, boolean[][] east, boolean[][] west, boolean[][] north, boolean[][] south) {
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.filledCircle(n / 2.0 + 0.5, n / 2.0 + 0.5, 0.375);
        StdDraw.filledCircle(1.5, 1.5, 0.375);

        StdDraw.setPenColor(StdDraw.BLACK);
        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= n; y++) {
                if (south[x][y]) StdDraw.line(x, y, x + 1, y);
                if (north[x][y]) StdDraw.line(x, y + 1, x + 1, y + 1);
                if (west[x][y]) StdDraw.line(x, y, x, y + 1);
                if (east[x][y]) StdDraw.line(x + 1, y, x + 1, y + 1);
            }
        }
        StdDraw.show();
        StdDraw.pause(1000);
    }

    public static void correctlyVisited(int x, int y) {
        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        StdDraw.filledCircle(x + 0.5, y + 0.5, 0.25);
        StdDraw.show();
        StdDraw.pause(30);
    }

    public static void falseVisited(int x, int y) {
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledCircle(x + 0.5, y + 0.5, 0.25);
        StdDraw.show();
        StdDraw.pause(30);
    }
}
