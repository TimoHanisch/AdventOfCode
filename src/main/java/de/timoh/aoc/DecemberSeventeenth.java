package de.timoh.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author Timo Hanisch / timohanisch@gmail.com
 * @since 17.12.2015
 */
public class DecemberSeventeenth {

    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("inputs/input17")));
        System.out.println(part1(input, 150));
        System.out.println(part2(input, 150));
    }

    private static int part1(String input, int volume) {
        int[] arr = Stream.of(input.split(System.getProperty("line.separator"))).mapToInt(Integer::parseInt).toArray();
        int allMasks = (1 << arr.length);
        int possibilities = 0;
        int tmpVolume;
        for (int i = 1; i < allMasks; i++) {
            tmpVolume = 0;
            for (int j = 0; j < arr.length; j++) {
                //The j-th element is used
                if ((i & (1 << j)) > 0) {
                    tmpVolume += arr[j];
                }
            }
            if (tmpVolume == volume) {
                possibilities++;
            }
        }
        return possibilities;
    }

    private static int part2(String input, int volume) {
        int[] arr = Stream.of(input.split(System.getProperty("line.separator"))).mapToInt(Integer::parseInt).toArray();
        int allMasks = (1 << arr.length);
        int possibilities = 0;
        int tmpVolume;
        int minCount = Integer.MAX_VALUE;
        int tmpMinCount;
        for (int i = 1; i < allMasks; i++) {
            tmpVolume = 0;
            tmpMinCount = 0;
            for (int j = 0; j < arr.length; j++) {
                if ((i & (1 << j)) > 0) {
                    tmpVolume += arr[j];
                    tmpMinCount++;
                }
            }
            if (tmpVolume == volume) {
                if (tmpMinCount < minCount) {
                    minCount = tmpMinCount;
                    possibilities = 1;
                } else if (tmpMinCount == minCount) {
                    possibilities++;
                }
            }
        }
        return possibilities;
    }
}
