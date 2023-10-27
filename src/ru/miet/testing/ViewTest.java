package ru.miet.testing;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ViewTest {
    private View view = new View();
    @Test
    void printResult() {
        double param = 0.1;
        String consoleOutput = null;
        PrintStream originalOut = System.out;
        try{
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(100);
            PrintStream capture = new PrintStream(outputStream);
            System.setOut(capture);

            view.printResult(param);

            capture.flush();
            consoleOutput = outputStream.toString();
            System.setOut(originalOut);
        }catch(Exception e){}

        assertEquals(Double.toString(param), consoleOutput);

    }

    @Test
    void displayError() {
        String param = "Error";
        String consoleOutput = null;
        PrintStream originalOut = System.out;
        try{
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(100);
            PrintStream capture = new PrintStream(outputStream);
            System.setOut(capture);

            view.displayError(param);

            capture.flush();
            consoleOutput = outputStream.toString();
            System.setOut(originalOut);
        }catch(Exception e){}

        assertEquals(param, consoleOutput);

    }

    @Test
    void getFirstArgumentAsString() {
        double a = 1;
        view.firstArg = a;
        assertEquals(Double.toString(a), view.getFirstArgumentAsString());
    }

    @Test
    void getSecondArgumentAsString() {
        double a = 1;
        view.secondArg = a;
        assertEquals(Double.toString(a), view.getSecondArgumentAsString());
    }
}