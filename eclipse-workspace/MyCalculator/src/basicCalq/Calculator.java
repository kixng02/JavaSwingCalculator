package basicCalq;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Calculator extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JTextField display;
    private JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    private JButton buttonAdd, buttonSubtract, buttonMultiply, buttonDivide, buttonEquals, buttonClear;

    private double num1 = 0, num2 = 0;
    private char operation = ' ';

    public Calculator() {
        setTitle("Calculator");
        setSize(250, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        display = new JTextField();
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(true);

        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");

        buttonAdd = new JButton("Add");
        buttonSubtract = new JButton("Subtract");
        buttonMultiply = new JButton("Multiply");
        buttonDivide = new JButton("Devide");
        buttonEquals = new JButton("Equal");
        buttonClear = new JButton("Clear");

        button0.addActionListener(this);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        buttonAdd.addActionListener(this);
        buttonSubtract.addActionListener(this);
        buttonMultiply.addActionListener(this);
        buttonDivide.addActionListener(this);
        buttonEquals.addActionListener(this);
        buttonClear.addActionListener(this);

        JPanel panel1 = new JPanel(new GridLayout(4, 4));
        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);
        panel1.add(buttonAdd);
        panel1.add(button4);
        panel1.add(button5);
        panel1.add(button6);
        panel1.add(buttonSubtract);
        panel1.add(button7);
        panel1.add(button8);
        panel1.add(button9);
        panel1.add(buttonMultiply);
        panel1.add(buttonClear);
        panel1.add(button0);
        panel1.add(buttonEquals);
        panel1.add(buttonDivide);

        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.add(display, BorderLayout.NORTH);
        panel2.add(panel1, BorderLayout.CENTER);

        add(panel2);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button0) {
            display.setText(display.getText() + "0");
        } else if (e.getSource() == button1) {
            display.setText(display.getText() + "1");
        } else if (e.getSource() == button2) {
            display.setText(display.getText() + "2");
        } else if (e.getSource() == button3) {
            display.setText(display.getText() + "3");
        } else if (e.getSource() == button4) {
            display.setText(display.getText() + "4");
        } else if (e.getSource() == button5) {
            display.setText(display.getText() + "5");
        } else if (e.getSource() == button6) {
            display.setText(display.getText() + "6");
        } else if (e.getSource() == button7) {
            display.setText(display.getText() + "7");
        } else if (e.getSource() == button8) {
            display.setText(display.getText() + "8");
        } else if (e.getSource() == button9) {
            display.setText(display.getText() + "9");
        } else if (e.getSource() == buttonAdd) {
            num1 = Double.parseDouble(display.getText());
            operation = '+';
            display.setText("");
        } else if (e.getSource() == buttonSubtract) {
            num1 = Double.parseDouble(display.getText());
            operation = '-';
            display.setText("");
        } else if (e.getSource() == buttonMultiply) {
            num1 = Double.parseDouble(display.getText());
            operation = '*';
            display.setText("");
        } else if (e.getSource() == buttonDivide) {
            num1 = Double.parseDouble(display.getText());
            operation = '/';
            display.setText("");
        } else if (e.getSource() == buttonEquals) {
            num2 = Double.parseDouble(display.getText());
            double result = 0;
            switch (operation) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            display.setText(String.valueOf(result));
        } else if (e.getSource() == buttonClear) {
            num1 = 0;
            num2 = 0;
            operation = ' ';
            display.setText("");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}


