// Generated from C:/Users/Timo/IdeaProjects/AdventOfCode/src/main/java/de/timoh/aoc/DecemberSeventh\AdventWire.g4 by ANTLR 4.5.1
package de.timoh.aoc.DecemberSeventh;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AdventWireParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		AND=1, OR=2, NOT=3, LSHIFT=4, RSHIFT=5, ASSIGN=6, NEWLINE=7, IDENTIFIER=8, 
		INTEGER=9, SKIP=10;
	public static final int
		RULE_rules = 0, RULE_operand = 1, RULE_assign = 2, RULE_and = 3, RULE_or = 4, 
		RULE_lshift = 5, RULE_rshift = 6, RULE_not = 7;
	public static final String[] ruleNames = {
		"rules", "operand", "assign", "and", "or", "lshift", "rshift", "not"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'AND'", "'OR'", "'NOT'", "'LSHIFT'", "'RSHIFT'", "'->'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "AND", "OR", "NOT", "LSHIFT", "RSHIFT", "ASSIGN", "NEWLINE", "IDENTIFIER", 
		"INTEGER", "SKIP"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "AdventWire.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AdventWireParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RulesContext extends ParserRuleContext {
		public List<AssignContext> assign() {
			return getRuleContexts(AssignContext.class);
		}
		public AssignContext assign(int i) {
			return getRuleContext(AssignContext.class,i);
		}
		public List<AndContext> and() {
			return getRuleContexts(AndContext.class);
		}
		public AndContext and(int i) {
			return getRuleContext(AndContext.class,i);
		}
		public List<OrContext> or() {
			return getRuleContexts(OrContext.class);
		}
		public OrContext or(int i) {
			return getRuleContext(OrContext.class,i);
		}
		public List<LshiftContext> lshift() {
			return getRuleContexts(LshiftContext.class);
		}
		public LshiftContext lshift(int i) {
			return getRuleContext(LshiftContext.class,i);
		}
		public List<RshiftContext> rshift() {
			return getRuleContexts(RshiftContext.class);
		}
		public RshiftContext rshift(int i) {
			return getRuleContext(RshiftContext.class,i);
		}
		public List<NotContext> not() {
			return getRuleContexts(NotContext.class);
		}
		public NotContext not(int i) {
			return getRuleContext(NotContext.class,i);
		}
		public RulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rules; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdventWireListener ) ((AdventWireListener)listener).enterRules(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdventWireListener ) ((AdventWireListener)listener).exitRules(this);
		}
	}

	public final RulesContext rules() throws RecognitionException {
		RulesContext _localctx = new RulesContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_rules);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << IDENTIFIER) | (1L << INTEGER))) != 0)) {
				{
				setState(22);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(16);
					assign();
					}
					break;
				case 2:
					{
					setState(17);
					and();
					}
					break;
				case 3:
					{
					setState(18);
					or();
					}
					break;
				case 4:
					{
					setState(19);
					lshift();
					}
					break;
				case 5:
					{
					setState(20);
					rshift();
					}
					break;
				case 6:
					{
					setState(21);
					not();
					}
					break;
				}
				}
				setState(26);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperandContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(AdventWireParser.IDENTIFIER, 0); }
		public TerminalNode INTEGER() { return getToken(AdventWireParser.INTEGER, 0); }
		public OperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdventWireListener ) ((AdventWireListener)listener).enterOperand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdventWireListener ) ((AdventWireListener)listener).exitOperand(this);
		}
	}

	public final OperandContext operand() throws RecognitionException {
		OperandContext _localctx = new OperandContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_operand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER || _la==INTEGER) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignContext extends ParserRuleContext {
		public OperandContext operand() {
			return getRuleContext(OperandContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(AdventWireParser.ASSIGN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(AdventWireParser.IDENTIFIER, 0); }
		public TerminalNode NEWLINE() { return getToken(AdventWireParser.NEWLINE, 0); }
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdventWireListener ) ((AdventWireListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdventWireListener ) ((AdventWireListener)listener).exitAssign(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			operand();
			setState(30);
			match(ASSIGN);
			setState(31);
			match(IDENTIFIER);
			setState(32);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AndContext extends ParserRuleContext {
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public TerminalNode AND() { return getToken(AdventWireParser.AND, 0); }
		public TerminalNode ASSIGN() { return getToken(AdventWireParser.ASSIGN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(AdventWireParser.IDENTIFIER, 0); }
		public TerminalNode NEWLINE() { return getToken(AdventWireParser.NEWLINE, 0); }
		public AndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdventWireListener ) ((AdventWireListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdventWireListener ) ((AdventWireListener)listener).exitAnd(this);
		}
	}

	public final AndContext and() throws RecognitionException {
		AndContext _localctx = new AndContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_and);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			operand();
			setState(35);
			match(AND);
			setState(36);
			operand();
			setState(37);
			match(ASSIGN);
			setState(38);
			match(IDENTIFIER);
			setState(39);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrContext extends ParserRuleContext {
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public TerminalNode OR() { return getToken(AdventWireParser.OR, 0); }
		public TerminalNode ASSIGN() { return getToken(AdventWireParser.ASSIGN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(AdventWireParser.IDENTIFIER, 0); }
		public TerminalNode NEWLINE() { return getToken(AdventWireParser.NEWLINE, 0); }
		public OrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdventWireListener ) ((AdventWireListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdventWireListener ) ((AdventWireListener)listener).exitOr(this);
		}
	}

	public final OrContext or() throws RecognitionException {
		OrContext _localctx = new OrContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			operand();
			setState(42);
			match(OR);
			setState(43);
			operand();
			setState(44);
			match(ASSIGN);
			setState(45);
			match(IDENTIFIER);
			setState(46);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LshiftContext extends ParserRuleContext {
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public TerminalNode LSHIFT() { return getToken(AdventWireParser.LSHIFT, 0); }
		public TerminalNode ASSIGN() { return getToken(AdventWireParser.ASSIGN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(AdventWireParser.IDENTIFIER, 0); }
		public TerminalNode NEWLINE() { return getToken(AdventWireParser.NEWLINE, 0); }
		public LshiftContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lshift; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdventWireListener ) ((AdventWireListener)listener).enterLshift(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdventWireListener ) ((AdventWireListener)listener).exitLshift(this);
		}
	}

	public final LshiftContext lshift() throws RecognitionException {
		LshiftContext _localctx = new LshiftContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_lshift);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			operand();
			setState(49);
			match(LSHIFT);
			setState(50);
			operand();
			setState(51);
			match(ASSIGN);
			setState(52);
			match(IDENTIFIER);
			setState(53);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RshiftContext extends ParserRuleContext {
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public TerminalNode RSHIFT() { return getToken(AdventWireParser.RSHIFT, 0); }
		public TerminalNode ASSIGN() { return getToken(AdventWireParser.ASSIGN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(AdventWireParser.IDENTIFIER, 0); }
		public TerminalNode NEWLINE() { return getToken(AdventWireParser.NEWLINE, 0); }
		public RshiftContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rshift; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdventWireListener ) ((AdventWireListener)listener).enterRshift(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdventWireListener ) ((AdventWireListener)listener).exitRshift(this);
		}
	}

	public final RshiftContext rshift() throws RecognitionException {
		RshiftContext _localctx = new RshiftContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_rshift);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			operand();
			setState(56);
			match(RSHIFT);
			setState(57);
			operand();
			setState(58);
			match(ASSIGN);
			setState(59);
			match(IDENTIFIER);
			setState(60);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NotContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(AdventWireParser.NOT, 0); }
		public OperandContext operand() {
			return getRuleContext(OperandContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(AdventWireParser.ASSIGN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(AdventWireParser.IDENTIFIER, 0); }
		public TerminalNode NEWLINE() { return getToken(AdventWireParser.NEWLINE, 0); }
		public NotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_not; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdventWireListener ) ((AdventWireListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdventWireListener ) ((AdventWireListener)listener).exitNot(this);
		}
	}

	public final NotContext not() throws RecognitionException {
		NotContext _localctx = new NotContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_not);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(NOT);
			setState(63);
			operand();
			setState(64);
			match(ASSIGN);
			setState(65);
			match(IDENTIFIER);
			setState(66);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\fG\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\7\2\31\n\2\f\2\16\2\34\13\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\2\2\n\2\4"+
		"\6\b\n\f\16\20\2\3\3\2\n\13D\2\32\3\2\2\2\4\35\3\2\2\2\6\37\3\2\2\2\b"+
		"$\3\2\2\2\n+\3\2\2\2\f\62\3\2\2\2\169\3\2\2\2\20@\3\2\2\2\22\31\5\6\4"+
		"\2\23\31\5\b\5\2\24\31\5\n\6\2\25\31\5\f\7\2\26\31\5\16\b\2\27\31\5\20"+
		"\t\2\30\22\3\2\2\2\30\23\3\2\2\2\30\24\3\2\2\2\30\25\3\2\2\2\30\26\3\2"+
		"\2\2\30\27\3\2\2\2\31\34\3\2\2\2\32\30\3\2\2\2\32\33\3\2\2\2\33\3\3\2"+
		"\2\2\34\32\3\2\2\2\35\36\t\2\2\2\36\5\3\2\2\2\37 \5\4\3\2 !\7\b\2\2!\""+
		"\7\n\2\2\"#\7\t\2\2#\7\3\2\2\2$%\5\4\3\2%&\7\3\2\2&\'\5\4\3\2\'(\7\b\2"+
		"\2()\7\n\2\2)*\7\t\2\2*\t\3\2\2\2+,\5\4\3\2,-\7\4\2\2-.\5\4\3\2./\7\b"+
		"\2\2/\60\7\n\2\2\60\61\7\t\2\2\61\13\3\2\2\2\62\63\5\4\3\2\63\64\7\6\2"+
		"\2\64\65\5\4\3\2\65\66\7\b\2\2\66\67\7\n\2\2\678\7\t\2\28\r\3\2\2\29:"+
		"\5\4\3\2:;\7\7\2\2;<\5\4\3\2<=\7\b\2\2=>\7\n\2\2>?\7\t\2\2?\17\3\2\2\2"+
		"@A\7\5\2\2AB\5\4\3\2BC\7\b\2\2CD\7\n\2\2DE\7\t\2\2E\21\3\2\2\2\4\30\32";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}