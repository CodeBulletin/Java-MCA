package Tokenizer;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.LinkedList;
import Exceptions.Exceptions;

public class Tokenizer {
    private class TokenInfo {
        public final Pattern regex;
        public final int token;

        public TokenInfo(Pattern regex, int token) {
            this.regex = regex;
            this.token = token;
        }
    }

    private LinkedList<TokenInfo> tokenInfos;
    private LinkedList<Token> tokens;

    private Tokenizer() {
        tokenInfos = new LinkedList<TokenInfo>();
    }

    public void clear() {
        tokens.clear();
    }

    public void add(String regex, int token) {
        tokenInfos.add(
                new TokenInfo(Pattern.compile("^(" + regex + ")"), token));
        tokens = new LinkedList<Token>();
    }

    public Tokenizer tokenize(String str) throws Exceptions.TokenException {
        String s = new String(str);
        while (s.length() != 0 && s.charAt(0) == ' ') {
            s = s.substring(1);
            if (s.length() == 0)
                break;
        }
        while (!s.equals("")) {
            boolean match = false;
            for (TokenInfo info : tokenInfos) {
                Matcher m = info.regex.matcher(s);
                if (m.find()) {
                    match = true;

                    String tok = m.group().trim();
                    tokens.add(new Token(info.token, tok));

                    s = m.replaceFirst("");
                    break;
                }
            }
            if (!match) {
                throw new Exceptions.TokenException("unexpected char: " + s);
            }
            while (s.length() != 0 && s.charAt(0) == ' ') {
                s = s.substring(1);
                if (s.length() == 0)
                    break;
            }
        }
        return this;
    }

    public static Tokenizer InitTokenizer() {
        Tokenizer tokenizer = new Tokenizer();
        tokenizer.add("[+-]", 1); // plus or minus
        tokenizer.add("[*/]", 2); // mult or divide
        tokenizer.add("\\^", 3); // raised
        tokenizer.add(
            "sin|cos|tan|asin|acos|atan|sqrt|exp|ln|log|log2",
            4
        ); // function
        tokenizer.add("\\(", 5); // open bracket
        tokenizer.add("\\)", 6); // close bracket
        tokenizer.add("[a-zA-Z][a-zA-Z0-9_]*", 7); // variable
        tokenizer.add("[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?", 8); // integer number
        return tokenizer;
    }

    public LinkedList<Token> getTokens() {
        return tokens;
    }
}