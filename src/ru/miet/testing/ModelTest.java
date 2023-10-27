package ru.miet.testing;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    Model model = new Model();
    @org.junit.jupiter.api.Test
    void sum() {
        double a = 1;
        assertEquals(a + a, model.sum(a,a));
    }

    @org.junit.jupiter.api.Test
    void subtract() {
        double a = 1;
        assertEquals(a - a, model.subtract(a,a));
    }

    @org.junit.jupiter.api.Test
    void multiply() {
        double a = 1;
        assertEquals(a * a, model.multiply(a,a));
    }

    @org.junit.jupiter.api.Test
    void divide() throws Exception {
        double a = 1;
        assertEquals(a / a, model.divide(a,a));
    }
    @org.junit.jupiter.api.Test
    void divideEx() throws Exception
    {
        double a = 1;
        double b = 0;
        try{
            model.divide(a,b);
        }
        catch (Exception e){
            ArithmeticException ae = new ArithmeticException();
            assertEquals(ae.toString(), e.toString());
        }
    }
}