package ru.miet.testing;

import java.util.Stack;

public class Model {

    public double arithmeticParser(String data) throws Exception {
        Stack<Double> nums = new Stack<>();
        Stack<String> operations = new Stack<>();
        String numBuffer = "";
        double first = 0, second = 0;
        for(int i = 0; i < data.length(); i++)
        {
            if(data.charAt(i) != '+' && data.charAt(i) != '-' && data.charAt(i) != '*' && data.charAt(i) != '/')
            {
                numBuffer += data.charAt(i);
            }
            else
            {
                if(!operations.isEmpty() && operations.peek().equals("*"))
                {
                    first = nums.pop();
                    second = Double.parseDouble(numBuffer);
                    nums.add(this.multiply(first, second));
                    operations.pop();
                    operations.add(String.valueOf(data.charAt(i)));
                }
                else if(!operations.isEmpty() && operations.peek().equals("/"))
                {
                    first = nums.pop();
                    second = Double.parseDouble(numBuffer);
                    nums.add(this.divide(first, second));
                    operations.pop();
                    operations.add(String.valueOf(data.charAt(i)));
                }
                else{
                    nums.add(Double.parseDouble(numBuffer));
                    operations.add(String.valueOf(data.charAt(i)));
                }
                numBuffer = "";

            }
            if(i == data.length() - 1){
                if(!operations.isEmpty() && operations.peek().equals("*"))
                {
                    first = nums.pop();
                    second = Double.parseDouble(numBuffer);
                    nums.add(this.multiply(first, second));
                    operations.pop();
                }
                else if(!operations.isEmpty() && operations.peek().equals("/"))
                {
                    first = nums.pop();
                    second = Double.parseDouble(numBuffer);
                    nums.add(this.divide(first, second));
                    operations.pop();
                }
                else{
                    nums.add(Double.parseDouble(numBuffer));
                }
            }
        }
        first = nums.pop();
        while (!nums.isEmpty())
        {
            if(operations.peek().equals("+"))
            {
                operations.pop();
                first = this.sum(first, nums.pop());
            }
            else if(operations.peek().equals("-"))
            {
                operations.pop();
                first = this.subtract(nums.pop(), first);
            }
        }
        return first;
    }
    /**
     * Вычисляет сумму двух чисел
     */
    public double sum(double a, double b){
        return a + b;
    };
    /**
     * Вычисляет разность двух чисел a - b
     */
    public double subtract(double a, double b){
        return a - b;
    };

    /**
     * Вычисляет произведение двух чисел
     */
    double multiply(double a, double b){
        return a * b;
    };

    /**
     * Вычисляет отношение числа а к числу b.
     * Должен выбросить {@link java.lang.ArithmeticException} если |b| < 10e-8
     */
    double divide(double a, double b) throws Exception {
        double result = 0;
        try
        {
            if(Math.abs(b) < 0.00000001){
                throw new java.lang.ArithmeticException("Делить на ноль нельзя");
            }
           result = a / b;
        }
        catch (Exception e)
        {
            Controller.DisplayError(e);
        }
        return result;
    };

}
