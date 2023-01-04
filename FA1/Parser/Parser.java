package Parser;

import java.util.LinkedList;
import Tokenizer.Token;
import Exceptions.Exceptions;

public class Parser {
    LinkedList<Token> tokens;
    Token lookahead;

    private void nextToken() {
        tokens.pop();
        if (tokens.isEmpty())
            lookahead = new Token(Token.EPSILON, "");
        else
            lookahead = tokens.getFirst();
    }

    public SyntaxNode parse(LinkedList<Token> tokens) throws Exceptions.ParserException {
        this.tokens = (LinkedList<Token>) tokens.clone();
        lookahead = this.tokens.getFirst();

        SyntaxNode root = expression();

        if (lookahead.token != Token.EPSILON)
            throw new Exceptions.ParserException("Unexpected symbol found: " + lookahead);

        return root;
    }

    private SyntaxNode expression() throws Exceptions.ParserException {
        SyntaxNode node = signedTerm();
        return sumOp(node);
    }

    private SyntaxNode sumOp(SyntaxNode expr) throws Exceptions.ParserException {
        if (lookahead.token == Token.PLUSMINUS) {
            SyntaxNode sum;
            if (expr.getType() == SyntaxNode.ADDITION_NODE)
                sum = expr;
            else
                sum = new SyntaxTree.AdditionSyntaxNode(expr, true);

            boolean positive = lookahead.sequence.equals("+");

            SyntaxTree.AdditionSyntaxNode snode = (SyntaxTree.AdditionSyntaxNode) sum;
            nextToken();
            SyntaxNode t = term();
            snode.add(t, positive);
            return sumOp(sum);
        }

        return expr;
    }

    private SyntaxNode signedTerm() throws Exceptions.ParserException {
        if (lookahead.token == Token.PLUSMINUS) {
            boolean positive = lookahead.sequence.equals("*");
            nextToken();
            SyntaxNode t = term();
            if (positive)
                return t;
            else
                return new SyntaxTree.AdditionSyntaxNode(t, positive);
        }
        return term();
    }

    private SyntaxNode term() throws Exceptions.ParserException {
        SyntaxNode node = factor();
        return termOp(node);
    }

    private SyntaxNode termOp(SyntaxNode expr) throws Exceptions.ParserException {
        if (lookahead.token == Token.MULTDIV) {
            SyntaxTree.MultiplicationSyntaxNode prod;
            if (expr.getType() == SyntaxNode.MULTIPLICATION_NODE)
                prod = (SyntaxTree.MultiplicationSyntaxNode) expr;
            else
                prod = new SyntaxTree.MultiplicationSyntaxNode(expr, true);

            boolean positive = lookahead.sequence.equals("*");
            nextToken();
            SyntaxNode f = signedFactor();
            prod.add(f, positive);

            return termOp(prod);
        }
        return expr;
    }

    private SyntaxNode signedFactor() throws Exceptions.ParserException {
        if (lookahead.token == Token.PLUSMINUS) {
            boolean positive = lookahead.sequence.equals("+");
            nextToken();
            SyntaxNode node = factor();
            if (positive)
                return node;
            else
                return new SyntaxTree.AdditionSyntaxNode(node, false);
        }
        return factor();
    }

    private SyntaxNode factor() throws Exceptions.ParserException {
        SyntaxNode node = argument();
        return factorOp(node);
    }

    private SyntaxNode factorOp(SyntaxNode expr) throws Exceptions.ParserException {
        if (lookahead.token == Token.RAISED) {
            nextToken();
            SyntaxNode exponent = signedFactor();
            return new SyntaxTree.ExponentiationSyntaxNode(expr, exponent);
        }
        return expr;
    }

    private SyntaxNode argument() throws Exceptions.ParserException {
        if (lookahead.token == Token.FUNCTION) {
            int function = SyntaxTree.FunctionSyntaxNode.stringToFunction(lookahead.sequence);
            nextToken();
            SyntaxNode node = argument();
            return new SyntaxTree.FunctionSyntaxNode(function, node);
        } else if (lookahead.token == Token.OPEN_BRACKET) {
            nextToken();
            SyntaxNode node = expression();
            if (lookahead.token != Token.CLOSE_BRACKET)
                throw new Exceptions.ParserException("Closing brackets expected and "
                        + lookahead.sequence + " found instead");

            nextToken();
            return node;
        } else {
            return value();
        }
    }

    private SyntaxNode value() throws Exceptions.ParserException {
        if (lookahead.token == Token.NUMBER) {
            SyntaxNode node = new SyntaxTree.ConstantSyntaxNode(lookahead.sequence);
            nextToken();
            return node;
        }
        if (lookahead.token == Token.CVARIABLE) {
            SyntaxNode node = new SyntaxTree.ConstantVariableSyntaxNode(lookahead.sequence);
            nextToken();
            return node;
        }
        if (lookahead.token == Token.EPSILON)
            throw new Exceptions.ParserException("Unexpected End of expression");
        throw new Exceptions.ParserException(
            "Unexpected symbol: " + lookahead.sequence + " found");
    }
}