package de.timoh.aoc;

import com.google.common.primitives.Chars;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * DecemberThird
 *
 * @author Timo Hanisch
 * @since 03.12.2015
 */
public class DecemberThird {

    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("inputs/input3")));
        part1(input);
        part2(input);
    }

    public static void part1(String input) {
        List<Character> characters = new ArrayList<>(Chars.asList(input.toCharArray()));
        final List<Point> houses = new ArrayList<>();
        houses.add(new Point(0, 0));
        characters.stream()
                .map(DecemberThird::characterTo2DVector)
                .reduce(houses.get(0), (s, p) -> {
                    Point location = new Point(s.x + p.x, s.y + p.y);
                    if (!houses.contains(location)) {
                        houses.add(location);
                    }
                    return location;
                });
        System.out.println(houses.size());
    }

    public static void part2(String input) {
        List<Character> characters = new ArrayList<>(Chars.asList(input.toCharArray()));
        final Point locationSanta = new Point(0, 0);
        final Point locationRobotSanta = new Point(0, 0);
        final List<Point> houses = new ArrayList<>();
        final int[] index = {0};
        houses.add(new Point(0, 0));
        characters.stream()
                .map(DecemberThird::characterTo2DVector)
                .forEach(p -> {
                    if (index[0]++ % 2 == 0) {
                        locationSanta.x += p.x;
                        locationSanta.y += p.y;
                        Point housePos = new Point(locationSanta.x, locationSanta.y);
                        if (!houses.contains(housePos)) {
                            houses.add(housePos);
                        }
                    } else {
                        locationRobotSanta.x += p.x;
                        locationRobotSanta.y += p.y;
                        Point housePos = new Point(locationRobotSanta.x, locationRobotSanta.y);
                        if (!houses.contains(housePos)) {
                            houses.add(housePos);
                        }
                    }
                });
        System.out.println(houses.size());
    }

    private static Point characterTo2DVector(char c) {
        switch (c) {
            case '^':
                return new Point(0, 1);
            case 'v':
                return new Point(0, -1);
            case '>':
                return new Point(1, 0);
            case '<':
                return new Point(-1, 0);
        }
        return new Point(0, 0);
    }
}
