package de.timoh.aoc.DecemberSeventh;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

/**
 * @author Timo Hanisch / timohanisch@gmail.com
 * @since 07.12.2015
 */
public class DecemberSeventh {
    public static void main(String[] args) throws IOException {
        // Part1
        AdventWireLexer lexer = new AdventWireLexer(new ANTLRFileStream("inputs/input7"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        AdventWireParser parser = new AdventWireParser(tokens);

        AdventWireParser.RulesContext drinkSentenceContext = parser.rules();

        // Walk it and attach our listener
        ParseTreeWalker walker = new ParseTreeWalker();
        AdventWireWalker listener = new AdventWireWalker();
        walker.walk(listener, drinkSentenceContext);
        System.out.println(listener.getValue("a"));

        // Part2
        // Changed b assignment in input7_2 to output of first part
        lexer = new AdventWireLexer(new ANTLRFileStream("inputs/input7_2"));
        tokens = new CommonTokenStream(lexer);

        parser = new AdventWireParser(tokens);

        drinkSentenceContext = parser.rules();

        // Walk it and attach our listener
        walker = new ParseTreeWalker();
        listener = new AdventWireWalker();
        walker.walk(listener, drinkSentenceContext);
        System.out.println(listener.getValue("a"));
    }
}
