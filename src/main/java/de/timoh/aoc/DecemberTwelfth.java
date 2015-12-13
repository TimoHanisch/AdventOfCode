package de.timoh.aoc;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.StreamSupport;

/**
 * DecemberTwelfth
 *
 * @author Timo Hanisch
 * @since 13.12.2015
 */
public class DecemberTwelfth {

    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("inputs/input12")));
        System.out.println(count(new ObjectMapper().readTree(input), false));
        System.out.println(count(new ObjectMapper().readTree(input), true));
    }

    private static int count(JsonNode node, boolean ignoreRed) {
        if (node.isInt()) {
            return node.asInt();
        } else if (ignoreRed && StreamSupport.stream(node.spliterator(), false).filter(n -> n.asText().equals("red")).count() > 0 && !node.isArray()) {
            return 0;
        } else if (node.isArray() || !node.isValueNode()) {
            return StreamSupport.stream(node.spliterator(), false)
                    .map(n -> count(n, ignoreRed))
                    .reduce(0, Integer::sum);
        }
        return 0;
    }
}
