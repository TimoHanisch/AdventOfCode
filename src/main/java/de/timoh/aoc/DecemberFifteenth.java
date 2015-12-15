package de.timoh.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;

import static java.lang.Integer.*;

/**
 * @author Timo Hanisch / timohanisch@gmail.com
 * @since 15.12.2015
 */
public class DecemberFifteenth {

    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("inputs/input15")));
        System.out.println(cookieScore(input, 100, 4, 0));
        System.out.println(cookieScore(input, 100, 5, 500));
    }

    private static int cookieScore(String input, int max, int ingredients, int cal) {
        String[] split = input.split(System.getProperty("line.separator"));
        int[][] values = new int[split.length][5];
        final int[] index = new int[]{0};
        Arrays.stream(split).map(line -> {
            String[] lineSplit = line.replaceAll(",", "").split(" ");
            return new int[]{parseInt(lineSplit[2]), parseInt(lineSplit[4]), parseInt(lineSplit[6]), parseInt(lineSplit[8]), parseInt(lineSplit[10])};
        }).forEach(line -> values[index[0]++] = line);
        final int[] score = {0};
        IntStream.range(0, max)
                .forEach(a -> IntStream.range(0, 100 - a)
                        .forEach(b -> IntStream.range(0, 100 - a - b)
                                .forEach(c -> {
                                    int d = 100 - a - b - c;
                                    int tmpScore = calcScore(values, ingredients, cal, new int[]{a, b, c, d});
                                    if (tmpScore > score[0]) {
                                        score[0] = tmpScore;
                                    }
                                })));
        return score[0];
    }

    private static int calcScore(int[][] values, int ingredients, int cal, int[] cookieParts) {
        // Index 4 == calories
        int score = 1;
        int tmpScore;
        for (int i = 0; i < values[0].length && i < ingredients; i++) {
            tmpScore = 0;
            for (int j = 0; j < values.length; j++) {
                tmpScore += (values[j][i] * cookieParts[j]);
            }
            if (i == 4 && cal != 0 && tmpScore != cal) {
                return 0;
            }
            if (tmpScore < 0) {
                tmpScore = 0;
            }
            if (i != 4) {
                score *= tmpScore;
            }
        }
        return score;
    }
}
