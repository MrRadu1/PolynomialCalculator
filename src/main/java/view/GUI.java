package view;

import model.Polynomial;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;

public class GUI extends JFrame{

    private JFrame frame;
    private JTextField textField1;
    private JTextField textField2;
    private JButton btnAddition;
    private JButton btnMultiplication;
    private JButton btnIntegration;
    private JButton btnSubtraction;
    private JButton btnDivision;
    private JButton btnDerivate;
    private JLabel lblResult;
    private JLabel txtResult;
    private JLabel txtResult2;
    private JLabel lblSecondPolynom;
    private JLabel lblFirstPol;
    private JLabel lblRules;

    public GUI() {
        frame = new JFrame();
        frame.setBounds(100, 100, 765, 515);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        lblFirstPol = new JLabel("First Polynom:");
        lblFirstPol.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblFirstPol.setBounds(55, 75, 110, 30);
        frame.getContentPane().add(lblFirstPol);

        lblSecondPolynom = new JLabel("Second Polynom:");
        lblSecondPolynom.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblSecondPolynom.setBounds(35, 135, 135, 30);
        frame.getContentPane().add(lblSecondPolynom);

        lblResult = new JLabel("Result:");
        lblResult.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblResult.setBounds(115, 195, 51, 30);
        frame.getContentPane().add(lblResult);

        textField1 = new JTextField();
        textField1.setBounds(180, 80, 265, 25);
        frame.getContentPane().add(textField1);
        textField1.setColumns(10);

        textField2 = new JTextField();
        textField2.setColumns(10);
        textField2.setBounds(180, 140, 265, 25);
        frame.getContentPane().add(textField2);

        txtResult = new JLabel("");
        txtResult.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        txtResult.setBounds(180, 197, 265, 25);
        frame.getContentPane().add(txtResult);

        txtResult2 = new JLabel("");
        txtResult2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        txtResult2.setBounds(180, 235, 265, 25);
        frame.getContentPane().add(txtResult2);

        lblRules = new JLabel("Rules");
        lblRules.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblRules.setBounds(588, 30, 60, 30);
        frame.getContentPane().add(lblRules);

        btnAddition = new JButton("Addition");
        btnAddition.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btnAddition.setBounds(45, 275, 120, 45);
        frame.getContentPane().add(btnAddition);

        btnMultiplication = new JButton("Multiplication");
        btnMultiplication.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btnMultiplication.setBounds(180, 275, 120, 45);
        frame.getContentPane().add(btnMultiplication);

        btnIntegration = new JButton("Integration");
        btnIntegration.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btnIntegration.setBounds(315, 275, 120, 45);
        frame.getContentPane().add(btnIntegration);

        btnSubtraction = new JButton("Subtraction");
        btnSubtraction.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btnSubtraction.setBounds(45, 340, 120, 45);
        frame.getContentPane().add(btnSubtraction);

        btnDivision = new JButton("Division");
        btnDivision.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btnDivision.setBounds(180, 340, 120, 45);
        frame.getContentPane().add(btnDivision);

        btnDerivate = new JButton("Derivate");
        btnDerivate.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btnDerivate.setBounds(315, 340, 120, 45);
        frame.getContentPane().add(btnDerivate);



        JTextPane txtpnxHasTo = new JTextPane();
        txtpnxHasTo.setText("        \r\n          1.x has to be lowercase \r\n\r\n2.You don't have to add + in front of the first " +
                "element\r\n\r\n3.You don't have to add * between coefficient and x\r\n\r\n4.If x's degree is 1 you don't have to " +
                "write x^1, x is enough\r\n\r\n5.If x's degree is 0 you don't have to write x^0, the coefficient is enough\r\n\r\n6.If" +
                " x's degree is >1 you have to write x^n, n=degree\r\n\r\n                  EXAMPLE: \r\n                  2x^2-3x+5\r\n");
        txtpnxHasTo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        txtpnxHasTo.setBounds(491, 73, 232, 374);
        frame.getContentPane().add(txtpnxHasTo);

        frame.setVisible(true);
    }

    public String getFirstPol() {
        return textField1.getText();
    }

    public String getSecondPol() {
        return textField2.getText();
    }

    public void setResult (String result) {
        txtResult.setText(result);
    }

    public void setResult2 (String result) {
        txtResult2.setText(result);
    }

    public void addBtnListener(ActionListener x) {
        btnAddition.addActionListener(x);
    }

    public void subBtnListener(ActionListener x) {
        btnSubtraction.addActionListener(x);
    }

    public void mltBtnListener(ActionListener x) {
        btnMultiplication.addActionListener(x);
    }

    public void divBtnListener(ActionListener x) {
        btnDivision.addActionListener(x);
    }

    public void intBtnListener(ActionListener x) {
        btnIntegration.addActionListener(x);
    }

    public void drvBtnListener(ActionListener x) {
        btnDerivate.addActionListener(x);
    }

    public void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }
}
