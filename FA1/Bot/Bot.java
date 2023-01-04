package Bot;

import java.util.LinkedList;
import Parser.Parser;
import Parser.SyntaxNode;
import Tokenizer.Token;
import Tokenizer.Tokenizer;

public class Bot {

    Tokenizer tokenizer = Tokenizer.InitTokenizer();
    Parser parser = new Parser();

    public String getReply(String message) {
        try { 
            tokenizer.clear();
            LinkedList<Token> tokens = 
                tokenizer.tokenize(message).getTokens();
            SyntaxNode node = parser.parse(tokens);
            return "" + node.getValue();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}