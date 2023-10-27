package ru.miet.testing;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    Controller controller = new Controller();
    @Test
    void start() {
    }

    @Test
    void onPlusClicked() {
        double param = 0.1;
        controller.firstArg = param;
        controller.secondArg = param;
        String consoleOutput = null;
        PrintStream originalOut = System.out;
        try{
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(100);
            PrintStream capture = new PrintStream(outputStream);
            System.setOut(capture);

            controller.onPlusClicked();

            capture.flush();
            consoleOutput = outputStream.toString();
            System.setOut(originalOut);
        }catch(Exception e){}

        assertEquals(Double.toString(param + param), consoleOutput);
    }

    @Test
    void onMinusClicked() {
        double param = 0.1;
        controller.firstArg = param;
        controller.secondArg = param;
        String consoleOutput = null;
        PrintStream originalOut = System.out;
        try{
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(100);
            PrintStream capture = new PrintStream(outputStream);
            System.setOut(capture);

            controller.onMinusClicked();

            capture.flush();
            consoleOutput = outputStream.toString();
            System.setOut(originalOut);
        }catch(Exception e){}

        assertEquals(Double.toString(param - param), consoleOutput);
    }

    @Test
    void onDivideClicked() {
        double param = 2;
        controller.firstArg = param;
        controller.secondArg = param;
        String consoleOutput = null;
        PrintStream originalOut = System.out;
        try{
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(100);
            PrintStream capture = new PrintStream(outputStream);
            System.setOut(capture);

            controller.onDivideClicked();

            capture.flush();
            consoleOutput = outputStream.toString();
            System.setOut(originalOut);
        }catch(Exception e){}

        assertEquals(Double.toString(param / param), consoleOutput);
    }

    @Test
    void onMultiplyClicked() {
        double param = 0.1;
        controller.firstArg = param;
        controller.secondArg = param;
        String consoleOutput = null;
        PrintStream originalOut = System.out;
        try{
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(100);
            PrintStream capture = new PrintStream(outputStream);
            System.setOut(capture);

            controller.onMultiplyClicked();

            capture.flush();
            consoleOutput = outputStream.toString();
            System.setOut(originalOut);
        }catch(Exception e){}

        assertEquals(Double.toString(param * param), consoleOutput);
    }
}