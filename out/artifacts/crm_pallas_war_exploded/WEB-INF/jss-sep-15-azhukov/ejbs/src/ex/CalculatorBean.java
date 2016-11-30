package ex;

import javax.ejb.Stateless;

@Stateless(name = "CalculatorEJB")
public class CalculatorBean {
    public CalculatorBean() {
    }

    public Double calculate(Double a, Double b){
        return  a+b;
    }
}
