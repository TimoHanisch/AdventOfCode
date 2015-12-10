package de.timoh.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Timo Hanisch / timohanisch@gmail.com
 * @since 10.12.2015
 */
public class DecemberTenth {

    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("inputs/input10")));
        runner(input, 40);
        runner(input, 50);
    }

    private static void runner(String input, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < input.length(); ) {
                int subSequenceLength = getSubSequenceLength(j, input);
                stringBuilder.append(subSequenceLength)
                        .append(input.charAt(j));
                j += subSequenceLength;
            }
            input = stringBuilder.toString();
            stringBuilder = new StringBuilder();
        }
        System.out.println(input.length());
    }

    private static int getSubSequenceLength(int index, String input) {
        char start = input.charAt(index);
        int length = 1;
        for (int i = index + 1; i < input.length(); i++) {
            if (input.charAt(i) == start) {
                length++;
            } else {
                break;
            }
        }
        return length;
    }

}
