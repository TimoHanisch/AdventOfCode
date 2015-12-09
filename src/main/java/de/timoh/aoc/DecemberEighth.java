package de.timoh.aoc;

import com.google.common.primitives.Chars;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * @author Timo Hanisch / timohanisch@gmail.com
 * @since 09.12.2015
 */
public class DecemberEighth {

    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("inputs/input8")));
        part1(input);
        part2(input);
    }

    private static void part1(String input) {
        int size = Arrays.stream(input.split(System.getProperty("line.separator")))
                .reduce(0, (sum, s) -> {
                            int length = s.length();
                            int code = getCodeLength(s);
                            return sum + (length - code);
                        }
                        , (sum1, sum2) -> sum1 + sum2);
        System.out.println(size);
    }

    private static int getCodeLength(String s) {
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '\\':
                    switch (s.charAt(i + 1)) {
                        case 'x':
                            i += 2;
                        default:
                            size++;
                            i++;
                    }
                    break;
                default:
                    size++;
            }
        }
        return size - 2;
    }

    private static void part2(String input) {
        int size = Arrays.stream(input.split(System.getProperty("line.separator")))
                .reduce(0, (sum, s) -> {
                            int length = s.length();
                            int encoded = getEncodedLength(s);
                            return sum + (encoded - length);
                        }
                        , (sum1, sum2) -> sum1 + sum2);
        System.out.println(size);
    }

    private static int getEncodedLength(String s) {
        return s.replaceAll("\\\\","\\\\\\\\").replaceAll("\"","\\\\\"").length() + 2;
    }
}
