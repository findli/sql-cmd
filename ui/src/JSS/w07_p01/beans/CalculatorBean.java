package JSS.w07_p01.beans;

import java.io.Serializable;

public class CalculatorBean implements Serializable {
    private double a = 0;
    private double b = 0;
    private String operation = "+";

    public CalculatorBean() {
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getResult() {
        double res = 0;
        switch (operation.charAt(0)) {
            case '+':
                res = a + b;
                break;
            case '-':
                res = a - b;
                break;
            case '*':
                res = a * b;
                break;
            case '/':
                res = a / b;
                break;
        }
        return res;
    }

    public void reset() {
        a = b = 0;
        operation = "+";
    }
}
