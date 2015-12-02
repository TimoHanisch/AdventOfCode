package de.timoh.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * DecemberSecond
 *
 * @author Timo Hanisch
 * @since 02.12.2015
 */
public class DecemberSecond {

    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("inputs/input2")));
        part1(input);
        part2(input);
    }

    public static void part1(String input) {
        Integer value = Arrays.stream(input.split(System.getProperty("line.separator")))
                .map(s -> Arrays.stream(s.split("x"))
                        .map(Integer::parseInt).toArray())
                .map(arr -> Arrays.stream(new int[]{(int) arr[0] * (int) arr[1], (int) arr[1] * (int) arr[2], (int) arr[2] * (int) arr[0]}).sorted().toArray())
                .map(arr -> arr[0] + arr[0] * 2 + arr[1] * 2 + arr[2] * 2)
                .reduce(0, (sum, v) -> sum + v, (s1, s2) -> s1 + s2);
        System.out.println(value);
    }

    public static void part2(String input) {
        Integer value = Arrays.stream(input.split(System.getProperty("line.separator")))
                .map(s -> Arrays.stream(s.split("x"))
                        .map(Integer::parseInt).sorted().toArray())
                .map(arr -> (int) arr[0] * 2 + (int) arr[1] * 2 + (int) arr[0] * (int) arr[1] * (int) arr[2])
                .reduce(0, (sum, v) -> sum + v, (s1, s2) -> s1 + s2);
        System.out.println(value);
    }
}
