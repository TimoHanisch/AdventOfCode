package de.timoh.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * @author Timo Hanisch / timohanisch@gmail.com
 * @since 21.12.2015
 */
public class DecemberEighteenth {
    public static void main(String[] args) throws IOException {
        String input1 = new String(Files.readAllBytes(Paths.get("inputs/input18_1")));
        String input2 = new String(Files.readAllBytes(Paths.get("inputs/input18_2")));
        System.out.println(part1(input1, 100));
        System.out.println(part2(input2, 100));
    }

    private static int part2(String input, int steps) {
        boolean[][] grid = readGrid(input);
        boolean[][] tmpGrid;
        for (int n = 0; n < steps; n++) {
            tmpGrid = new boolean[grid.length][grid[0].length];
            for (int x = 0; x < grid[0].length; x++) {
                for (int y = 0; y < grid.length; y++) {
                    tmpGrid[y][x] = getCellStatus2(grid, x, y);
                }
            }
            grid = tmpGrid;
        }
        return count(grid);
    }

    private static int part1(String input, int steps) {
        boolean[][] grid = readGrid(input);
        boolean[][] tmpGrid;
        for (int n = 0; n < steps; n++) {
            tmpGrid = new boolean[grid.length][grid[0].length];
            for (int x = 0; x < grid[0].length; x++) {
                for (int y = 0; y < grid.length; y++) {
                    tmpGrid[y][x] = getCellStatus1(grid, x, y);
                }
            }
            grid = tmpGrid;
        }
        return count(grid);
    }

    private static int count(boolean[][] grid) {
        return Arrays.stream(grid).map(gridLine -> {
            int count = 0;
            for (boolean b : gridLine) {
                count += (b ? 1 : 0);
            }
            return count;
        }).reduce(0, Integer::sum);
    }

    private static boolean getCellStatus1(boolean[][] grid, int x, int y) {
        int on = 0;
        for (int x2 = -1; x2 <= 1; x2++) {
            for (int y2 = -1; y2 <= 1; y2++) {
                int xNew = x + x2;
                int yNew = y + y2;
                if (xNew >= 0 && yNew >= 0 && xNew < grid[0].length && yNew < grid.length && (xNew != x && yNew != y || xNew == x && yNew != y || xNew != x && yNew == y)) {
                    on = grid[yNew][xNew] ? on + 1 : on;
                }
            }
        }
        return grid[y][x] && (on == 2 || on == 3) || (!grid[y][x] && on == 3);
    }

    private static boolean getCellStatus2(boolean[][] grid, int x, int y) {
        return getCellStatus1(grid, x, y) || (x == 0 && y == 0 || x == grid[0].length - 1 && y == 0 || x == 0 && y == grid.length - 1 || x == grid[0].length - 1 && y == grid.length - 1);
    }

    private static boolean[][] readGrid(String input) {
        String[] lines = input.split(System.getProperty("line.separator"));
        final int[] index = {0};
        boolean[][] grid = new boolean[lines.length][];
        Arrays.stream(lines).map(line -> {
            boolean[] gridLine = new boolean[line.length()];
            for (int i = 0; i < line.length(); i++) {
                gridLine[i] = line.charAt(i) != '.';
            }
            return gridLine;
        }).forEach(gridLine -> grid[index[0]++] = gridLine);
        return grid;
    }
}
