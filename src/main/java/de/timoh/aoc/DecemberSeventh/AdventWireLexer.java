// Generated from C:/Users/Timo/IdeaProjects/AdventOfCode/src/main/java/de/timoh/aoc/DecemberSeventh\AdventWire.g4 by ANTLR 4.5.1
package de.timoh.aoc.DecemberSeventh;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AdventWireLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		AND=1, OR=2, NOT=3, LSHIFT=4, RSHIFT=5, ASSIGN=6, NEWLINE=7, IDENTIFIER=8, 
		INTEGER=9, SKIP=10;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"AND", "OR", "NOT", "LSHIFT", "RSHIFT", "ASSIGN", "NEWLINE", "IDENTIFIER", 
		"INTEGER", "SKIP"
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


	public AdventWireLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "AdventWire.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\fF\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\5\b\67\n\b"+
		"\3\t\6\t:\n\t\r\t\16\t;\3\n\6\n?\n\n\r\n\16\n@\3\13\3\13\3\13\3\13\2\2"+
		"\f\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\3\2\5\3\2c|\3\2\62;\5"+
		"\2\13\13\16\16\"\"H\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\3\27\3\2\2\2\5\33\3\2\2\2\7\36\3\2\2\2\t\"\3\2\2\2\13)\3\2\2\2"+
		"\r\60\3\2\2\2\17\66\3\2\2\2\219\3\2\2\2\23>\3\2\2\2\25B\3\2\2\2\27\30"+
		"\7C\2\2\30\31\7P\2\2\31\32\7F\2\2\32\4\3\2\2\2\33\34\7Q\2\2\34\35\7T\2"+
		"\2\35\6\3\2\2\2\36\37\7P\2\2\37 \7Q\2\2 !\7V\2\2!\b\3\2\2\2\"#\7N\2\2"+
		"#$\7U\2\2$%\7J\2\2%&\7K\2\2&\'\7H\2\2\'(\7V\2\2(\n\3\2\2\2)*\7T\2\2*+"+
		"\7U\2\2+,\7J\2\2,-\7K\2\2-.\7H\2\2./\7V\2\2/\f\3\2\2\2\60\61\7/\2\2\61"+
		"\62\7@\2\2\62\16\3\2\2\2\63\64\7\17\2\2\64\67\7\f\2\2\65\67\7\f\2\2\66"+
		"\63\3\2\2\2\66\65\3\2\2\2\67\20\3\2\2\28:\t\2\2\298\3\2\2\2:;\3\2\2\2"+
		";9\3\2\2\2;<\3\2\2\2<\22\3\2\2\2=?\t\3\2\2>=\3\2\2\2?@\3\2\2\2@>\3\2\2"+
		"\2@A\3\2\2\2A\24\3\2\2\2BC\t\4\2\2CD\3\2\2\2DE\b\13\2\2E\26\3\2\2\2\6"+
		"\2\66;@\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}