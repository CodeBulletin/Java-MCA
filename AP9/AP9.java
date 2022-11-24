package AP9;

// Problem Statement
/*
A Financial Calculator to calculate the SimpleInterest and CompoundInterest by taking command line values for principal, rate and time.
    1. Extend the code to calculate ‘Final Value’ of investment (V) of an investment (principal P) compounded yearly for T years at interest rate
       R is given by the formula: V = P * (1 + R) * T
    2. Perform the above code using a function and call it in main().
Make another class and a function in it to perform the above task.
*/

public class AP9 {
    public static void main(String[] args) {

        Double[] argsD = new Double[3];
        int k = 0;
        for (String i: args) {
            Double j = Double.parseDouble(i);
            argsD[k] = j;
            k++;
        }

        Calculator calculator = new Calculator(argsD[0],
            argsD[1] / 100.0, argsD[2]);

        System.out.println("Simple Intrest: " +
            calculator.CalculateSimpleIntrest());
        System.out.println("Compound Intrest: " +
            calculator.CalculateCompundIntrest(4));
        System.out.println("Simple Final value: " +
            calculator.CalculateSimpleFinalValue());
        System.out.println("Compound Final valur: " + 
            calculator.CalculateCompoundFinalValue(4));
    }
}

class Calculator {
    public double p, r, t; 

    Calculator(double p, double r, double t) {
        this.p = p; this.r = r; this.t = t;
    }

    public double CalculateCompundIntrest(double n) {
        return p * Math.pow(1 + r/n, n * t) - p;
    }

    public double CalculateSimpleIntrest() {
        return p * r * t;
    }

    public double CalculateSimpleFinalValue() {
        return CalculateSimpleIntrest() + p;
    }

    public double CalculateCompoundFinalValue(double n) {
        return CalculateCompundIntrest(n) + p;
    }
}