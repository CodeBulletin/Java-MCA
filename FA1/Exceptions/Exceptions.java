package Exceptions;

public class Exceptions {
    public static class ParserException extends Exception {
        public ParserException(String message) {
            super(message);
        }
    }

    public static class TokenException extends Exception {
        public TokenException(String message) {
            super(message);
        }
    }

    public static class EvaluationException extends Exception {
        public EvaluationException(String message) {
            super(message);
        }
    }
}
