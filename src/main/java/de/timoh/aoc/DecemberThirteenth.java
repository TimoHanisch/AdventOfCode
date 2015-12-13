package de.timoh.aoc;

import com.google.common.collect.Collections2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * DecemberThirteenth
 *
 * @author Timo Hanisch
 * @since 13.12.2015
 */
public class DecemberThirteenth {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("inputs/input13")));
        happinessCalculator(input, new ArrayList<>());
        happinessCalculator(input, Collections.singletonList("me"));
    }

    private static void happinessCalculator(String input, List<String> newNodes) {
        List<String> nodes = new ArrayList<>();
        nodes.addAll(newNodes);
        Map<String, Integer> happinessMap = new HashMap<>();
        extractNodes(input, nodes, happinessMap);
        Collection<List<String>> permutations = Collections2.permutations(nodes);
        Optional<Integer> largest = permutations.stream()
                .map(g -> getHappiness(happinessMap, g))
                .sorted((i1, i2) -> Integer.compare(i2, i1))
                .findFirst();
        System.out.println(largest);
    }

    private static int getHappiness(Map<String, Integer> happinessMap, List<String> guests) {
        int change = 0;
        String leftNeighbour;
        String rightNeighbour;
        for (int i = 0; i < guests.size(); i++) {
            if (i == 0) {
                leftNeighbour = guests.get(i) + guests.get(guests.size() - 1);
                rightNeighbour = guests.get(i) + guests.get(i + 1);
            } else if (i == guests.size() - 1) {
                leftNeighbour = guests.get(i) + guests.get(i - 1);
                rightNeighbour = guests.get(i) + guests.get(0);
            } else {
                leftNeighbour = guests.get(i) + guests.get(i - 1);
                rightNeighbour = guests.get(i) + guests.get(i + 1);
            }
            if (happinessMap.containsKey(leftNeighbour)) {
                change += happinessMap.get(leftNeighbour);
            }
            if (happinessMap.containsKey(rightNeighbour)) {
                change += happinessMap.get(rightNeighbour);
            }
        }
        return change;
    }

    private static void extractNodes(String input, List<String> nodes, Map<String, Integer> happinessMap) {
        Arrays.stream(input.split(System.getProperty("line.separator")))
                .forEach(line -> {
                    String[] splitLine = line.split(" ");
                    String name1 = splitLine[0];
                    String name2 = splitLine[splitLine.length - 1].substring(0, splitLine[splitLine.length - 1].length() - 1);
                    if (!nodes.contains(name1)) {
                        nodes.add(name1);
                    }
                    if (!nodes.contains(name2)) {
                        nodes.add(name2);
                    }
                    int value = Integer.parseInt(splitLine[3]);
                    int happiness = splitLine[2].equals("gain") ? value : value * -1;
                    happinessMap.put(name1 + name2, happiness);
                });
    }
}
