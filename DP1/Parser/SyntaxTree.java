package Parser;
import java.util.LinkedList;

import ContantVariables.CVars;
import Exceptions.Exceptions;

public class SyntaxTree {
    public static class Term {
        public boolean positive;
        public SyntaxNode expression;

        public Term(boolean positive, SyntaxNode expression) {
            this.positive = positive;
            this.expression = expression;
        }
    }

    public static class ConstantSyntaxNode implements SyntaxNode {
        private double value;

        public ConstantSyntaxNode(double value) {
            this.value = value;
        }

        public ConstantSyntaxNode(String value) throws NumberFormatException {
            this.value = Double.parseDouble(value);
        }

        public double getValue() throws Exception {
            return value;
        }

        public int getType() {
            return SyntaxNode.CONSTANT_NODE;
        }
    }

    public static class ConstantVariableSyntaxNode implements SyntaxNode {
        private String var;
        private static final CVars vars = new CVars();

        public ConstantVariableSyntaxNode(String var) throws NumberFormatException {
            this.var = var;
        }

        public double getValue() throws Exception {
            return vars.get(var);
        }

        public int getType() {
            return SyntaxNode.CVARIABLE_NODE;
        }
    }

    public static abstract class SequenceSyntaxNode
            implements SyntaxNode {

        protected LinkedList<Term> terms;

        public SequenceSyntaxNode() {
            this.terms = new LinkedList<Term>();
        }

        public SequenceSyntaxNode(SyntaxNode a, boolean positive) {
            this.terms = new LinkedList<Term>();
            this.terms.add(new Term(positive, a));
        }

        public void add(SyntaxNode a, boolean positive) {
            this.terms.add(new Term(positive, a));
        }
    }

    public static class AdditionSyntaxNode
            extends SequenceSyntaxNode {

        public AdditionSyntaxNode() {
            super();
        }

        public AdditionSyntaxNode(SyntaxNode a,
                boolean positive) {
            super(a, positive);
        }

        public int getType() {
            return SyntaxNode.ADDITION_NODE;
        }

        public double getValue() throws Exception {
            double sum = 0.0;
            for (Term t : terms) {
                if (t.positive)
                    sum += t.expression.getValue();
                else
                    sum -= t.expression.getValue();
            }
            return sum;
        }
    }

    public static class MultiplicationSyntaxNode
            extends SequenceSyntaxNode {

        public MultiplicationSyntaxNode() {
            super();
        }

        public MultiplicationSyntaxNode(SyntaxNode a,
                boolean positive) {
            super(a, positive);
        }

        public int getType() {
            return SyntaxNode.MULTIPLICATION_NODE;
        }

        public double getValue() throws Exception  {
            double prod = 1.0;
            for (Term t : terms) {
                if (t.positive)
                    prod *= t.expression.getValue();
                else {
                    double value = t.expression.getValue();
                    if (value == 0) {
                        throw new ArithmeticException("Divide by zero");
                    }
                    prod /= value;
                }
            }
            return prod;
        }
    }

    public static class ExponentiationSyntaxNode
            implements SyntaxNode {

        private SyntaxNode base;
        private SyntaxNode exponent;

        public ExponentiationSyntaxNode(SyntaxNode base,
                SyntaxNode exponent) {
            this.base = base;
            this.exponent = exponent;
        }

        public int getType() {
            return SyntaxNode.EXPONENTIATION_NODE;
        }

        public double getValue() throws Exception {
            double b = base.getValue();
            double e = exponent.getValue();
            if (b == 0 && e == 0) {
                throw new ArithmeticException("Zero raised to the exponent Zero");
            }
            return Math.pow(b, e);
        }
    }

    public static class FunctionSyntaxNode
            implements SyntaxNode {
        public static final int SIN = 1;
        public static final int COS = 2;
        public static final int TAN = 3;

        public static final int ASIN = 4;
        public static final int ACOS = 5;
        public static final int ATAN = 6;

        public static final int SQRT = 7;
        public static final int EXP = 8;

        public static final int LN = 9;
        public static final int LOG = 10;
        public static final int LOG2 = 11;

        private int function;
        private SyntaxNode argument;

        public FunctionSyntaxNode(int function,
                SyntaxNode argument) {
            super();
            this.function = function;
            this.argument = argument;
        }

        public int getType() {
            return SyntaxNode.FUNCTION_NODE;
        }

        public double getValue() throws Exception {
            switch (function) {
                case SIN:
                    return Math.sin(argument.getValue());
                case COS:
                    return Math.cos(argument.getValue());
                case TAN:
                    return Math.tan(argument.getValue());
                case ASIN:
                    return Math.asin(argument.getValue());
                case ACOS:
                    return Math.acos(argument.getValue());
                case ATAN:
                    return Math.atan(argument.getValue());
                case SQRT:
                    return Math.sqrt(argument.getValue());
                case EXP:
                    return Math.exp(argument.getValue());
                case LN:
                    return Math.log(argument.getValue());
                case LOG:
                    return Math.log(argument.getValue())
                            * 0.43429448190325182765;
                case LOG2:
                    return Math.log(argument.getValue())
                            * 1.442695040888963407360;
            }
            throw new Exceptions.EvaluationException("Invalid function id " + function + "!");
        }

        public static int stringToFunction(String str) throws Exceptions.ParserException {
            if (str.equals("sin"))
                return FunctionSyntaxNode.SIN;
            if (str.equals("cos"))
                return FunctionSyntaxNode.COS;
            if (str.equals("tan"))
                return FunctionSyntaxNode.TAN;

            if (str.equals("asin"))
                return FunctionSyntaxNode.ASIN;
            if (str.equals("acos"))
                return FunctionSyntaxNode.ACOS;
            if (str.equals("atan"))
                return FunctionSyntaxNode.ATAN;

            if (str.equals("sqrt"))
                return FunctionSyntaxNode.SQRT;
            if (str.equals("exp"))
                return FunctionSyntaxNode.EXP;

            if (str.equals("ln"))
                return FunctionSyntaxNode.LN;
            if (str.equals("log"))
                return FunctionSyntaxNode.LOG;
            if (str.equals("log2"))
                return FunctionSyntaxNode.LOG2;

            throw new Exceptions.ParserException("Unexpected Function " + str + " found!");
        }
    }
}