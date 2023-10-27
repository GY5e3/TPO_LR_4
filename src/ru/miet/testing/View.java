package ru.miet.testing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements CalculatorView{

    Error er;
    public double firstArg = 0;
    public double secondArg = 0;
    JTextArea mainZone = new JTextArea(2,17);

    JButton one = new JButton("1");
    JButton two = new JButton("2");
    JButton three = new JButton("3");
    JButton four = new JButton("4");
    JButton five = new JButton("5");
    JButton six = new JButton("6");
    JButton seven = new JButton("7");
    JButton eight = new JButton("8");
    JButton nine = new JButton("9");
    JButton zero = new JButton("0");
    JButton dot = new JButton(".");
    JButton plus = new JButton("+");
    JButton minus = new JButton("-");
    JButton multiply = new JButton("*");
    JButton divide = new JButton("/");

    JButton result = new JButton("=");

    public View() {
        this.setTitle("Simple Calculator");
        this.setVisible(true);
        this.setSize(400, 400);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        mainZone.setLineWrap(true);

        JPanel panel = new JPanel(new GridLayout(7, 1));

        JPanel emptyPanel1 = new JPanel();
        JPanel emptyPanel2 = new JPanel();
        JPanel emptyPanel3 = new JPanel();
        JPanel emptyPanel4 = new JPanel();
        JPanel emptyPanel5 = new JPanel();
        JPanel emptyPanel6 = new JPanel();

        plus.addActionListener(new Handler());
        minus.addActionListener(new Handler());
        multiply.addActionListener(new Handler());
        divide.addActionListener(new Handler());
        one.addActionListener(new Handler());
        two.addActionListener(new Handler());
        three.addActionListener(new Handler());
        four.addActionListener(new Handler());
        five.addActionListener(new Handler());
        six.addActionListener(new Handler());
        seven.addActionListener(new Handler());
        eight.addActionListener(new Handler());
        nine.addActionListener(new Handler());
        zero.addActionListener(new Handler());
        dot.addActionListener(new Handler());

        result.addActionListener(new Handler());

        emptyPanel1.add(mainZone);

        emptyPanel2.add(one);
        emptyPanel2.add(two);
        emptyPanel2.add(three);
        emptyPanel2.add(four);


        emptyPanel3.add(five);
        emptyPanel3.add(six);
        emptyPanel3.add(seven);
        emptyPanel3.add(eight);

        emptyPanel4.add(nine);
        emptyPanel4.add(zero);
        emptyPanel4.add(dot);

        emptyPanel5.add(plus);
        emptyPanel5.add(minus);
        emptyPanel5.add(multiply);
        emptyPanel5.add(divide);

        emptyPanel6.add(result,BorderLayout.WEST);



        panel.add(emptyPanel1);
        panel.add(emptyPanel5);
        panel.add(emptyPanel2);
        panel.add(emptyPanel3);
        panel.add(emptyPanel4);
        panel.add(emptyPanel6);

        add(panel);

    }
    class Handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == plus)
                mainZone.setText(mainZone.getText() + "+");
            if(e.getSource() == minus)
                mainZone.setText(mainZone.getText() + "-");
            if(e.getSource() == multiply)
                mainZone.setText(mainZone.getText() + "*");
            if(e.getSource() == divide)
                mainZone.setText(mainZone.getText() + "/");
            if(e.getSource() == one)
                mainZone.setText(mainZone.getText() + "1");
            if(e.getSource() == two)
                mainZone.setText(mainZone.getText() + "2");
            if(e.getSource() == three)
                mainZone.setText(mainZone.getText() + "3");
            if(e.getSource() == four)
                mainZone.setText(mainZone.getText() + "4");
            if(e.getSource() == five)
                mainZone.setText(mainZone.getText() + "5");
            if(e.getSource() == six)
                mainZone.setText(mainZone.getText() + "6");
            if(e.getSource() == seven)
                mainZone.setText(mainZone.getText() + "7");
            if(e.getSource() == eight)
                mainZone.setText(mainZone.getText() + "8");
            if(e.getSource() == nine)
                mainZone.setText(mainZone.getText() + "9");
            if(e.getSource() == zero)
                mainZone.setText(mainZone.getText() + "0");
            if(e.getSource() == dot)
                mainZone.setText(mainZone.getText() + ".");
            if(e.getSource() == result) {
                try {
                    Controller.arithmeticParser(mainZone.getText());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }

        }
    }
    private static class Error extends JFrame {
        JLabel l;
        public Error(String s){
            setVisible(true);
            setSize(500, 200);
            setLayout(new FlowLayout());
            l = new JLabel(s);
            add(l);
        }
    }
    private class ResultWindow extends JFrame {
        public ResultWindow(double result){
            setVisible(true);
            setSize(500, 200);
            JLabel l;
            setLayout(new FlowLayout());
            l = new JLabel("Результат вычислений" + result);
            add(l);
        }
    }

    /**
     * Отображает результат вычисления
     */
    public void printResult(double result)
    {
        if(!er.isVisible())
        {
            ResultWindow resultWindow = new ResultWindow(result);
        }

    }
    /**
     * Показывает ошибку, например деление на 0, пустые аргументы и прочее
     */
    public void displayError(String message)
    {
        er = new Error(message);
    }
    /**
     * Возвращает значение, введенное в поле первого аргументы
     */
    public String getFirstArgumentAsString() {
        return Double.toString(firstArg);
    }


    /**
     * Возвращает значение, введенное в поле второго аргументы
     */
    public String getSecondArgumentAsString() {
        return Double.toString(secondArg);
    }

}
