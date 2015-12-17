package de.timoh.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.Function;

/**
 * @author Timo Hanisch / timohanisch@gmail.com
 * @since 17.12.2015
 */
public class DecemberSixteenth {

    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("inputs/input16")));
        Aunt a1 = new Aunt(3, 7, 2, 3, 0, 0, 5, 3, 2, 1);
        System.out.println(findAunt(input, a1::getSimilarity1));
        System.out.println(findAunt(input, a1::getSimilarity2));
    }

    private static int findAunt(String input, Function<? super Aunt, Integer> similarityFunc) {
        int[] index = {1};
        int[] sim = {0};
        String[] splitted = input.split(System.getProperty("line.separator"));
        return Arrays.stream(splitted)
                .map(l -> {
                    String[] splitLine = l.split(",");
                    String[] value1 = Arrays.copyOfRange(splitLine[0].replaceAll(":", "").split(" "), 2, 4);
                    String[] value2 = Arrays.copyOfRange(splitLine[1].replaceAll(":", "").split(" "), 1, 3);
                    String[] value3 = Arrays.copyOfRange(splitLine[2].replaceAll(":", "").split(" "), 1, 3);
                    return createAunt(value1, value2, value3);
                }).map(similarityFunc)
                .reduce(0, (i, simVal) -> {
                    if (simVal > sim[0]) {
                        sim[0] = simVal;
                        return index[0]++;
                    }
                    index[0]++;
                    return i;
                });
    }

    private static Aunt createAunt(String[]... values) {
        int children = -1;
        int cats = -1;
        int samoyeds = -1;
        int pomeranians = -1;
        int akitas = -1;
        int vizslas = -1;
        int goldfish = -1;
        int trees = -1;
        int cars = -1;
        int perfumes = -1;
        for (String[] val : values)
            switch (val[0]) {
                case "children":
                    children = Integer.parseInt(val[1]);
                    break;
                case "cats":
                    cats = Integer.parseInt(val[1]);
                    break;
                case "samoyeds":
                    samoyeds = Integer.parseInt(val[1]);
                    break;
                case "pomeranians":
                    pomeranians = Integer.parseInt(val[1]);
                    break;
                case "akitas":
                    akitas = Integer.parseInt(val[1]);
                    break;
                case "vizslas":
                    vizslas = Integer.parseInt(val[1]);
                    break;
                case "goldfish":
                    goldfish = Integer.parseInt(val[1]);
                    break;
                case "trees":
                    trees = Integer.parseInt(val[1]);
                    break;
                case "cars":
                    cars = Integer.parseInt(val[1]);
                    break;
                case "perfumes":
                    perfumes = Integer.parseInt(val[1]);
                    break;
            }
        return new Aunt(children, cats, samoyeds, pomeranians, akitas, vizslas, goldfish, trees, cars, perfumes);
    }

    private static class Aunt {

        /**
         * 0: children
         * 1: cats
         * 2: samoyeds
         * 3: pomeranians
         * 4: akitas
         * 5: vizslas
         * 6: goldfish
         * 7: trees
         * 8: cars
         * 9: perfumes
         */
        public int[] values;

        public Aunt(int... values) {
            this.values = values;
        }

        public int getSimilarity1(Aunt aunt) {
            int sim = 0;
            for (int i = 0; i < aunt.values.length; i++) {
                if (aunt.values[i] == this.values[i]) {
                    sim++;
                } else if (aunt.values[i] >= 0 && this.values[i] == -1 || aunt.values[i] == -1 && this.values[i] >= 0) {
                    sim++;
                }
            }
            return sim;
        }

        public int getSimilarity2(Aunt aunt) {
            int sim = 0;
            for (int i = 0; i < aunt.values.length; i++) {
                if (aunt.values[i] >= 0 && this.values[i] == -1 || aunt.values[i] == -1 && this.values[i] >= 0) {
                    sim++;
                } else if ((i == 1 || i == 7) && aunt.values[i] > this.values[i]) {
                    sim++;
                } else if ((i == 3 || i == 6) && aunt.values[i] < this.values[i]) {
                    sim++;
                } else if (aunt.values[i] == this.values[i]) {
                    sim++;
                }
            }
            return sim;
        }
    }
}
