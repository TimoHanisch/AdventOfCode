package de.timoh.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;

/**
 * @author Timo Hanisch / timohanisch@gmail.com
 * @since 14.12.2015
 */
public class DecemberFourteenth {

    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("inputs/input14")));
        System.out.println(part1(input, 2503, (t1, t2) -> Integer.compare(t2.o2, t1.o2)).get(0).o2);
        System.out.println(part2(input, 2503));
    }

    private static int part2(String input, int time) {
        Map<String, Integer> points = new HashMap<>();
        IntStream.range(1, time + 1)
                .forEach(i -> {
                    List<Tuple<String, Integer>> winners = part1(input, i, (t1, t2) -> Integer.compare(t2.o2, t1.o2));
                    winners.forEach(winner -> {
                        if (points.containsKey(winner.o1)) {
                            points.put(winner.o1, points.get(winner.o1) + 1);
                        } else {
                            points.put(winner.o1, 1);
                        }
                    });
                });
        return points.values().stream()
                .sorted((i1, i2) -> Integer.compare(i2, i1))
                .findFirst()
                .get();
    }

    private static List<Tuple<String, Integer>> part1(String input, int time, Comparator<? super Tuple<String, Integer>> comparator) {
        List<Tuple<String, Integer>> list = new ArrayList<>();
        Arrays.stream(input.split(System.getProperty("line.separator")))
                .map(line -> {
                    String[] split = line.split(" ");
                    int speed = Integer.parseInt(split[3]);
                    int acceleration = Integer.parseInt(split[6]);
                    int sleep = Integer.parseInt(split[13]);
                    int div = Math.floorDiv(time, (acceleration + sleep));
                    int rest = time % (acceleration + sleep);
                    int restDistance = (rest > acceleration ? acceleration * speed : rest * speed);
                    return new Tuple<>(split[0], div * acceleration * speed + restDistance);
                })
                .sorted(comparator)
                .forEach(t -> {
                    if (list.isEmpty()) {
                        list.add(t);
                    } else if (list.get(0).o2.equals(t.o2)) {
                        list.add(t);
                    }
                });
        return list;
    }

    private static class Tuple<K, V> {
        public K o1;
        public V o2;

        public Tuple(K o1, V o2) {
            this.o1 = o1;
            this.o2 = o2;
        }

        public String toString() {
            return "(" + o1 + ", " + o2 + ")";
        }
    }
}
