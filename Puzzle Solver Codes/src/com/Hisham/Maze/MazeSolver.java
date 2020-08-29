package com.Hisham.Maze;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class MazeSolver {          // credit : algs4 booksite

    private final int n;                 // dimension of maze
    private boolean[][] north;     // is there a wall to north of cell i, j
    private boolean[][] east;
    private boolean[][] south;
    private boolean[][] west;
    private boolean[][] visited;
    private boolean done = false;

    public MazeSolver(int n) {
        this.n = n;
        MazeVisualizer.initDraw(n);          // initial drawing
        init();
        generate();
    }

    private void init() {

        // initialize border cells as already visited
        visited = new boolean[n + 2][n + 2];
        for (int x = 0; x < n + 2; x++) {
            visited[x][0] = true;
            visited[x][n + 1] = true;
        }
        for (int y = 0; y < n + 2; y++) {
            visited[0][y] = true;
            visited[n + 1][y] = true;
        }

        // initialize all walls as present
        north = new boolean[n + 2][n + 2];
        east = new boolean[n + 2][n + 2];
        south = new boolean[n + 2][n + 2];
        west = new boolean[n + 2][n + 2];
        for (int x = 0; x < n + 2; x++) {
            for (int y = 0; y < n + 2; y++) {
                north[x][y] = true;
                east[x][y] = true;
                south[x][y] = true;
                west[x][y] = true;
            }
        }
    }

    // generate the maze
    private void generate(int x, int y) {
        visited[x][y] = true;

        // while there is an unvisited neighbor
        while (!visited[x][y + 1] || !visited[x + 1][y] || !visited[x][y - 1] || !visited[x - 1][y]) {

            // pick random neighbor (could use Knuth's trick instead)
            while (true) {
                double r = StdRandom.uniform(4);
                if (r == 0 && !visited[x][y + 1]) {
                    north[x][y] = false;
                    south[x][y + 1] = false;
                    generate(x, y + 1);
                    break;
                } else if (r == 1 && !visited[x + 1][y]) {
                    east[x][y] = false;
                    west[x + 1][y] = false;
                    generate(x + 1, y);
                    break;
                } else if (r == 2 && !visited[x][y - 1]) {
                    south[x][y] = false;
                    north[x][y - 1] = false;
                    generate(x, y - 1);
                    break;
                } else if (r == 3 && !visited[x - 1][y]) {
                    west[x][y] = false;
                    east[x - 1][y] = false;
                    generate(x - 1, y);
                    break;
                }
            }
        }
    }

    // generate the maze starting from lower left
    private void generate() {
        generate(1, 1);
    }

    // solve the maze using depth-first search
    private void solve(int x, int y) {
        if (x == 0 || y == 0 || x == n + 1 || y == n + 1) return;
        if (done || visited[x][y]) return;
        visited[x][y] = true;

        // draw newly visited paths (blue region)
        MazeVisualizer.correctlyVisited(x, y);

        // reached middle
        if (x == n / 2 && y == n / 2) done = true;

        if (!north[x][y]) solve(x, y + 1);
        if (!east[x][y]) solve(x + 1, y);
        if (!south[x][y]) solve(x, y - 1);
        if (!west[x][y]) solve(x - 1, y);

        if (done) return;

        // draw already visited paths (grey region.should not be included in answer)
        MazeVisualizer.falseVisited(x, y);

    }

    // solve the maze starting from the start state
    public void solve() {
        for (int x = 1; x <= n; x++)
            for (int y = 1; y <= n; y++)
                visited[x][y] = false;
        done = false;
        solve(1, 1);
    }

    // draw the maze
    public void draw() {
        MazeVisualizer.draw(n, east, west, north, south);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(StdIn.readLine());
        MazeSolver maze = new MazeSolver(n);
        StdDraw.enableDoubleBuffering();
        maze.draw();
        maze.solve();
    }

}
