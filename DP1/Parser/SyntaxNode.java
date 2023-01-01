package Parser;

public interface SyntaxNode {
    public static final int CONSTANT_NODE = 1;
    public static final int CVARIABLE_NODE = 2;
    public static final int ADDITION_NODE = 3;
    public static final int MULTIPLICATION_NODE = 4;
    public static final int EXPONENTIATION_NODE = 5;
    public static final int FUNCTION_NODE = 6;

    public int getType();

    public double getValue() throws Exception;
}