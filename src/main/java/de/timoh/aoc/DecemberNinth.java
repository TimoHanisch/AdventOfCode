package de.timoh.aoc;

import com.google.common.collect.Collections2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author Timo Hanisch / timohanisch@gmail.com
 * @since 09.12.2015
 */
public class DecemberNinth {

    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("inputs/input9")));
        part1(input);
        part2(input);
    }

    private static void part1(String input) {
        List<String> nodes = new ArrayList<>();
        Map<String, Integer> distances = new HashMap<>();
        extractNodes(input, nodes, distances);
        Collection<List<String>> permutations = Collections2.permutations(nodes);
        Optional<Integer> shortest = permutations.stream()
                .map(l -> getDistance(distances, l))
                .sorted()
                .findFirst();
        System.out.println(shortest);
    }

    private static void part2(String input) {
        List<String> nodes = new ArrayList<>();
        Map<String, Integer> distances = new HashMap<>();
        extractNodes(input, nodes, distances);
        Collection<List<String>> permutations = Collections2.permutations(nodes);
        Optional<Integer> longest = permutations.stream()
                .map(l -> getDistance(distances, l))
                .sorted((i1, i2) -> Integer.compare(i2, i1))
                .findFirst();
        System.out.println(longest);
    }

    private static int getDistance(Map<String, Integer> distances, List<String> l) {
        int distance = 0;
        for (int i = 0; i < l.size() - 1; i++) {
            if (distances.get(l.get(i) + l.get(i + 1)) != null) {
                distance += distances.get(l.get(i) + l.get(i + 1));
            } else if (distances.get(l.get(i + 1) + l.get(i)) != null) {
                distance += distances.get(l.get(i + 1) + l.get(i));
            }
        }
        return distance;
    }

    private static void extractNodes(String input, List<String> nodes, Map<String, Integer> distances) {
        Arrays.stream(input.split(System.getProperty("line.separator")))
                .forEach(line -> {
                    String[] splitLine = line.split(" ");
                    if (!nodes.contains(splitLine[0])) {
                        nodes.add(splitLine[0]);
                    }
                    if (!nodes.contains(splitLine[2])) {
                        nodes.add(splitLine[2]);
                    }
                    distances.put(splitLine[0] + splitLine[2], Integer.parseInt(splitLine[4]));
                });
    }

}
