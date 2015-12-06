package de.timoh.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * @author Timo Hanisch / timohanisch@gmail.com
 * @since 06.12.2015
 */
public class DecemberSixth {

    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("inputs/input6")));
        part1(input);
        part2(input);
    }

    private static void part1(String input) {
        final boolean[][] lights = new boolean[1000][1000];
        Arrays.stream(input.split(System.getProperty("line.separator")))
                .map(DecemberSixth::mapInput)
                .forEach(ints -> {
                    for (int x = ints[1]; x <= ints[3]; x++) {
                        for (int y = ints[2]; y <= ints[4]; y++) {
                            switch (ints[0]) {
                                case 2:
                                    lights[x][y] = !lights[x][y];
                                    break;
                                case -1:
                                    lights[x][y] = false;
                                    break;
                                case 1:
                                    lights[x][y] = true;
                                    break;
                            }
                        }
                    }
                });
        int count = 0;
        for (boolean[] line : lights) {
            for (int y = 0; y < lights.length; y++) {
                if (line[y]) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void part2(String input) {
        final int[][] brightness = new int[1000][1000];
        Arrays.stream(input.split(System.getProperty("line.separator")))
                .map(DecemberSixth::mapInput)
                .forEach(ints -> {
                    for (int x = ints[1]; x <= ints[3]; x++) {
                        for (int y = ints[2]; y <= ints[4]; y++) {
                            brightness[x][y] += ints[0];
                            if (brightness[x][y] < 0) {
                                brightness[x][y] = 0;
                            }
                        }
                    }
                });
        int count = 0;
        for (int[] line : brightness) {
            for (int y = 0; y < brightness.length; y++) {
                count += line[y];
            }
        }
        System.out.println(count);
    }

    private static int[] mapInput(String input) {
        String[] line = input.split(" ");
        String[] start, end;
        int[] mapped = new int[5];
        if (line[0].equals("toggle")) {
            mapped[0] = 2;
            start = line[1].split(",");
            end = line[3].split(",");
        } else {
            if (line[1].equals("on")) {
                mapped[0] = 1;
            } else {
                mapped[0] = -1;
            }
            start = line[2].split(",");
            end = line[4].split(",");
        }
        mapped[1] = Integer.parseInt(start[0]);
        mapped[2] = Integer.parseInt(start[1]);
        mapped[3] = Integer.parseInt(end[0]);
        mapped[4] = Integer.parseInt(end[1]);
        return mapped;
    }
}
