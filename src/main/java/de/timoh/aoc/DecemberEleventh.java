package de.timoh.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Timo Hanisch / timohanisch@gmail.com
 * @since 11.12.2015
 */
public class DecemberEleventh {

    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("inputs/input11")));
        password(input, 1);
        password(input, 2);
    }

    private static void password(String input, int iter) {
        char[] chars = input.toCharArray();
        int max;
        int found = 0;
        while (found < iter) {
            if (checkPassword(chars)) {
                found++;
                System.out.println(new String(chars));
            }
            max = chars.length - 1;
            for (int i = chars.length - 1; i >= max; i--) {
                chars[i]++;
                if (chars[i] > 'z') {
                    chars[i] = 'a';
                    max--;
                }
            }
        }
    }

    private static boolean checkPassword(char[] chars) {
        if (new String(chars).matches("[a-z]*(i|o|l)[a-z]*")) {
            return false;
        }
        // Check straight
        boolean straight = false;
        for (int i = 0; i < chars.length - 2; i++) {
            if (chars[i] + 1 == chars[i + 1] && chars[i + 1] + 1 == chars[i + 2]) {
                straight = true;
                break;
            }
        }
        int found = 0;
        char lastChar = 0;
        // Check pairs
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1] && chars[i] != lastChar) {
                found++;
                lastChar = chars[i];
                i++;
            }
        }
        return found >= 2 && straight;
    }
}
