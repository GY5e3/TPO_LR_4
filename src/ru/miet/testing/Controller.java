package ru.miet.testing;
import java.util.Scanner;

public class Controller implements CalculatorPresenter{
    Scanner s = new Scanner(System.in);
    public static Model model;
    private static View view;
    public static double firstArg = 0;
    public static double secondArg = 1;
    public static double res;
    public Controller()
    {
        model = new Model();
        view = new View();
    }
    public static void arithmeticParser(String data) throws Exception
    {
        double result = model.arithmeticParser(data);
        view.printResult(result);
    }

    public static void DisplayError(Exception e){
        view.displayError(e.toString());
    }







    //USELESS SHIT USELESS SHIT USELESS SHIT USELESS SHIT USELESS SHIT USELESS SHIT USELESS SHIT USELESS SHIT
    //USELESS SHIT USELESS SHIT USELESS SHIT USELESS SHIT USELESS SHIT USELESS SHIT USELESS SHIT USELESS SHIT
    //USELESS SHIT USELESS SHIT USELESS SHIT USELESS SHIT USELESS SHIT USELESS SHIT USELESS SHIT USELESS SHIT
    //USELESS SHIT USELESS SHIT USELESS SHIT USELESS SHIT USELESS SHIT USELESS SHIT USELESS SHIT USELESS SHIT
    //USELESS SHIT USELESS SHIT USELESS SHIT USELESS SHIT USELESS SHIT USELESS SHIT USELESS SHIT USELESS SHIT
    /**
     * Вызывается формой в тот момент, когда пользователь нажал на кнопку '+'
     */
    public void onPlusClicked()
    {
        view.printResult(model.sum(firstArg, secondArg));
    }

    /**
     * Вызывается формой в тот момент, когда пользователь нажал на кнопку '-'
     */
    public void onMinusClicked(){
        view.printResult(model.subtract(firstArg, secondArg));
    }

    /**
     * Вызывается формой в тот момент, когда пользователь нажал на кнопку '/'
     */
    public void onDivideClicked() throws Exception {
        try{
            res = model.divide(firstArg, secondArg);
            view.printResult(res);
        }catch (Exception e){
            view.displayError(String.valueOf(e));
        }

    }
    /**
     * Вызывается формой в тот момент, когда пользователь нажал на кнопку '*'
     */
    public void onMultiplyClicked() throws Exception {
        view.printResult(model.multiply(firstArg, secondArg));
    };
}
