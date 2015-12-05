package de.timoh.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author Timo Hanisch / timohanisch@gmail.com
 * @since 05.12.2015
 */
public class DecemberFifth {

    private static Pattern doubles = Pattern.compile("(.)\\1");

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        String input = new String(Files.readAllBytes(Paths.get("inputs/input5")));
        part1(input);
        part2(input);
    }

    private static void part1(String input) {
        long count = Arrays.stream(input.split(System.getProperty("line.separator")))
                .filter(DecemberFifth::isLegal)
                .count();
        System.out.println(count);
    }

    private static void part2(String input) {
        long count = Arrays.stream(input.split(System.getProperty("line.separator")))
                .filter(s -> findDouble(s, 2, 0, false) && findDouble(s, 1, 1, true))
                .count();
        System.out.println(count);
    }

    /**
     * Finds doubled sub sequences in a string.
     *
     * @param input      The given string
     * @param length     The length of the sub sequence
     * @param space      The space which should be at least between two sub sequences
     * @param forceSpace If true only doubled sub sequences are considered which have <b>space</b>
     *                   characters between them, otherwise the whole input is scanned for reappearances
     * @return True if doubled sub sequences were found
     */
    private static boolean findDouble(String input, int length, int space, boolean forceSpace) {
        for (int i = 0; i <= input.length() - length; i++) {
            String substring = input.substring(i, i + length);
            for (int j = i + length + space; j <= input.length() - length; j++) {
                String nextSubstring = input.substring(j, j + length);
                if (substring.equals(nextSubstring)) {
                    return true;
                } else if (forceSpace) {
                    break;
                }
            }
        }
        return false;
    }

    private static boolean isLegal(String s) {
        if (!doubles.matcher(s).find()) {
            return false;
        } else if (!s.matches("(?i)(?:[a-z]*[aeiou]){3}[a-z]*")) {
            return false;
        } else if (s.contains("ab") || s.contains("cd") || s.contains("pq") || s.contains("xy")) {
            return false;
        }
        return true;
    }
}
