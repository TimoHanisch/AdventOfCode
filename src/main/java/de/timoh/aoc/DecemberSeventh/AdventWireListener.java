// Generated from C:/Users/Timo/IdeaProjects/AdventOfCode/src/main/java/de/timoh/aoc/DecemberSeventh\AdventWire.g4 by ANTLR 4.5.1
package de.timoh.aoc.DecemberSeventh;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AdventWireParser}.
 */
public interface AdventWireListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AdventWireParser#rules}.
	 * @param ctx the parse tree
	 */
	void enterRules(AdventWireParser.RulesContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdventWireParser#rules}.
	 * @param ctx the parse tree
	 */
	void exitRules(AdventWireParser.RulesContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdventWireParser#operand}.
	 * @param ctx the parse tree
	 */
	void enterOperand(AdventWireParser.OperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdventWireParser#operand}.
	 * @param ctx the parse tree
	 */
	void exitOperand(AdventWireParser.OperandContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdventWireParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(AdventWireParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdventWireParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(AdventWireParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdventWireParser#and}.
	 * @param ctx the parse tree
	 */
	void enterAnd(AdventWireParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdventWireParser#and}.
	 * @param ctx the parse tree
	 */
	void exitAnd(AdventWireParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdventWireParser#or}.
	 * @param ctx the parse tree
	 */
	void enterOr(AdventWireParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdventWireParser#or}.
	 * @param ctx the parse tree
	 */
	void exitOr(AdventWireParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdventWireParser#lshift}.
	 * @param ctx the parse tree
	 */
	void enterLshift(AdventWireParser.LshiftContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdventWireParser#lshift}.
	 * @param ctx the parse tree
	 */
	void exitLshift(AdventWireParser.LshiftContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdventWireParser#rshift}.
	 * @param ctx the parse tree
	 */
	void enterRshift(AdventWireParser.RshiftContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdventWireParser#rshift}.
	 * @param ctx the parse tree
	 */
	void exitRshift(AdventWireParser.RshiftContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdventWireParser#not}.
	 * @param ctx the parse tree
	 */
	void enterNot(AdventWireParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdventWireParser#not}.
	 * @param ctx the parse tree
	 */
	void exitNot(AdventWireParser.NotContext ctx);
}