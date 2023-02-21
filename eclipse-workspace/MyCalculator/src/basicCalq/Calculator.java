package basicCalq;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {

    private JTextField textField;
    private JButton buttonSquareRoot;

    public Calculator() {
        super("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textField = new JTextField();
        add(textField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
        String[] buttonLabels = {
            "7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "*",
            "0", ".", "=", "/"
        };
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        // Add square root button
        buttonSquareRoot = new JButton("sqrt");
        buttonSquareRoot.addActionListener(this);
        buttonPanel.add(buttonSquareRoot);

        add(buttonPanel, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("=")) {
            textField.setText(calculate());
        } else if (command.equals("sqrt")) {
            textField.setText(String.valueOf(Math.sqrt(Double.parseDouble(textField.getText()))));
        } else {
            textField.setText(textField.getText() + command);
        }
    }

    private String calculate() {
        double result = 0;
        String expression = textField.getText();
        try {
            result = evaluate(expression);
        } catch (Exception e) {
            return "Error";
        }
        return String.valueOf(result);
    }

    private double evaluate(String expression) {
        String[] tokens = expression.split(" ");
        double result = Double.parseDouble(tokens[0]);
        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            double operand = Double.parseDouble(tokens[i+1]);
            switch (operator) {
                case "+":
                    result += operand;
                    break;
                case "-":
                    result -= operand;
                    break;
                case "*":
                    result *= operand;
                    break;
                case "/":
                    result /= operand;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operator: " + operator);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
