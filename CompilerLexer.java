// Generated from compiler.g by ANTLR 4.7.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CompilerLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IF=1, FI=2, DO=3, OD=4, SKP=5, SEMI=6, VARDEF=7, THEN=8, ELIF=9, AND=10, 
		SCAND=11, OR=12, SCOR=13, TRUE=14, FALSE=15, POW=16, MULT=17, PLUS=18, 
		MIN=19, UNEQ=20, NOT=21, GT=22, GE=23, LT=24, LE=25, EQ=26, LPAREN=27, 
		RPAREN=28, NUM=29, VAR=30, WS=31;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"IF", "FI", "DO", "OD", "SKP", "SEMI", "VARDEF", "THEN", "ELIF", "AND", 
		"SCAND", "OR", "SCOR", "TRUE", "FALSE", "POW", "MULT", "PLUS", "MIN", 
		"UNEQ", "NOT", "GT", "GE", "LT", "LE", "EQ", "LPAREN", "RPAREN", "NUM", 
		"VAR", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'if '", "' fi'", "'do '", "' od'", "'skip'", "';'", "':='", "'->'", 
		"'[]'", "'&'", "'&&'", "'|'", "'||'", "'true'", "'false'", "'^'", "'*'", 
		"'+'", "'-'", "'!='", "'!'", "'>'", "'>='", "'<'", "'<='", "'='", "'('", 
		"')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "IF", "FI", "DO", "OD", "SKP", "SEMI", "VARDEF", "THEN", "ELIF", 
		"AND", "SCAND", "OR", "SCOR", "TRUE", "FALSE", "POW", "MULT", "PLUS", 
		"MIN", "UNEQ", "NOT", "GT", "GE", "LT", "LE", "EQ", "LPAREN", "RPAREN", 
		"NUM", "VAR", "WS"
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


	public CompilerLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "compiler.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2!\u00ae\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3"+
		"\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3"+
		"\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25"+
		"\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\33\3\33"+
		"\3\34\3\34\3\35\3\35\3\36\6\36\u0095\n\36\r\36\16\36\u0096\3\36\3\36\6"+
		"\36\u009b\n\36\r\36\16\36\u009c\5\36\u009f\n\36\3\37\3\37\7\37\u00a3\n"+
		"\37\f\37\16\37\u00a6\13\37\3 \6 \u00a9\n \r \16 \u00aa\3 \3 \2\2!\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
		"\3\2\5\3\2\62;\4\2C\\c|\5\2\13\f\17\17\"\"\2\u00b2\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\3A\3\2\2\2\5E\3\2\2\2\7I\3\2\2\2\tM\3\2\2\2\13Q\3\2\2\2\rV\3\2"+
		"\2\2\17X\3\2\2\2\21[\3\2\2\2\23^\3\2\2\2\25a\3\2\2\2\27c\3\2\2\2\31f\3"+
		"\2\2\2\33h\3\2\2\2\35k\3\2\2\2\37p\3\2\2\2!v\3\2\2\2#x\3\2\2\2%z\3\2\2"+
		"\2\'|\3\2\2\2)~\3\2\2\2+\u0081\3\2\2\2-\u0083\3\2\2\2/\u0085\3\2\2\2\61"+
		"\u0088\3\2\2\2\63\u008a\3\2\2\2\65\u008d\3\2\2\2\67\u008f\3\2\2\29\u0091"+
		"\3\2\2\2;\u0094\3\2\2\2=\u00a0\3\2\2\2?\u00a8\3\2\2\2AB\7k\2\2BC\7h\2"+
		"\2CD\7\"\2\2D\4\3\2\2\2EF\7\"\2\2FG\7h\2\2GH\7k\2\2H\6\3\2\2\2IJ\7f\2"+
		"\2JK\7q\2\2KL\7\"\2\2L\b\3\2\2\2MN\7\"\2\2NO\7q\2\2OP\7f\2\2P\n\3\2\2"+
		"\2QR\7u\2\2RS\7m\2\2ST\7k\2\2TU\7r\2\2U\f\3\2\2\2VW\7=\2\2W\16\3\2\2\2"+
		"XY\7<\2\2YZ\7?\2\2Z\20\3\2\2\2[\\\7/\2\2\\]\7@\2\2]\22\3\2\2\2^_\7]\2"+
		"\2_`\7_\2\2`\24\3\2\2\2ab\7(\2\2b\26\3\2\2\2cd\7(\2\2de\7(\2\2e\30\3\2"+
		"\2\2fg\7~\2\2g\32\3\2\2\2hi\7~\2\2ij\7~\2\2j\34\3\2\2\2kl\7v\2\2lm\7t"+
		"\2\2mn\7w\2\2no\7g\2\2o\36\3\2\2\2pq\7h\2\2qr\7c\2\2rs\7n\2\2st\7u\2\2"+
		"tu\7g\2\2u \3\2\2\2vw\7`\2\2w\"\3\2\2\2xy\7,\2\2y$\3\2\2\2z{\7-\2\2{&"+
		"\3\2\2\2|}\7/\2\2}(\3\2\2\2~\177\7#\2\2\177\u0080\7?\2\2\u0080*\3\2\2"+
		"\2\u0081\u0082\7#\2\2\u0082,\3\2\2\2\u0083\u0084\7@\2\2\u0084.\3\2\2\2"+
		"\u0085\u0086\7@\2\2\u0086\u0087\7?\2\2\u0087\60\3\2\2\2\u0088\u0089\7"+
		">\2\2\u0089\62\3\2\2\2\u008a\u008b\7>\2\2\u008b\u008c\7?\2\2\u008c\64"+
		"\3\2\2\2\u008d\u008e\7?\2\2\u008e\66\3\2\2\2\u008f\u0090\7*\2\2\u0090"+
		"8\3\2\2\2\u0091\u0092\7+\2\2\u0092:\3\2\2\2\u0093\u0095\t\2\2\2\u0094"+
		"\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2"+
		"\2\2\u0097\u009e\3\2\2\2\u0098\u009a\7\60\2\2\u0099\u009b\t\2\2\2\u009a"+
		"\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2"+
		"\2\2\u009d\u009f\3\2\2\2\u009e\u0098\3\2\2\2\u009e\u009f\3\2\2\2\u009f"+
		"<\3\2\2\2\u00a0\u00a4\t\3\2\2\u00a1\u00a3\t\3\2\2\u00a2\u00a1\3\2\2\2"+
		"\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5>\3"+
		"\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00a9\t\4\2\2\u00a8\u00a7\3\2\2\2\u00a9"+
		"\u00aa\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\3\2"+
		"\2\2\u00ac\u00ad\b \2\2\u00ad@\3\2\2\2\b\2\u0096\u009c\u009e\u00a4\u00aa"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}