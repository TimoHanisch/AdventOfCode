package de.timoh.aoc;

import com.google.common.primitives.Chars;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * DecemberFirst
 *
 * @author Timo Hanisch
 * @since 01.12.2015
 */
public class DecemberFirst {


    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("inputs/input1")));
        first(input);
        second(input);
    }

    public static void first(String input) {
        char[] chars = input.toCharArray();
        List<Character> characters = new ArrayList<>(Chars.asList(chars));
        int floor = characters.stream().reduce(0, (sum, c) -> sum + (c == '(' ? 1 : -1), (sum1, sum2) -> sum1 + sum2);
        System.out.println(floor);
    }

    public static void second(String input) {
        char[] chars = input.toCharArray();
        List<Character> characters = new ArrayList<>(Chars.asList(chars));
        int[] index = {0};
        characters.stream().reduce(0, (sum, c) -> {
                    index[0]++;
                    sum = sum + (c == '(' ? 1 : -1);
                    if (sum == -1) {
                        System.out.println(index[0]);
                    }
                    return sum;
                },
                (sum1, sum2) -> sum1 + sum2);
    }
}
