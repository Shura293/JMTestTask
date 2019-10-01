package com.company;

public class Calculator {
    private Calculator(){}

    public static int calculate(Integer var1, Integer var2, char operation, boolean flag){
        int result = 0;
        switch (operation){
            case '+': result = var1 + var2; break;
            case '-': result = var1 - var2; break;
            case '*': result = var1 * var2; break;
            case '/': result = var1 / var2; break;
            default:throw  new IllegalArgumentException("Invalid operator");
        }
        return result;
    }

}
