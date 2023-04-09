package questao1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ConversorMoedas extends JFrame implements ActionListener {
    private JLabel label1, label2, resultado, space1, space2, space3, space4;
    private JTextField textField;
    private JButton button;
    private CheckboxGroup grupo1;
    public ConversorMoedas() {
        setTitle("Conversor de Moedas");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 3));

        label1 = new JLabel("Valor em Real:");
        panel.add(label1);//1 1

        textField = new JTextField(10);
        panel.add(textField);//1 2
        
        space1 = new JLabel("");
        panel.add(space1);//1 3
        
        space2 = new JLabel("");
        panel.add(space2);//2 1
        
        label2 = new JLabel("Converter para:");
        panel.add(label2);//2 2
 
        space3 = new JLabel("");
        panel.add(space3);//2 3
        
        grupo1 = new CheckboxGroup();
        panel.add(new Checkbox("Dólar", grupo1, true));//3 1
        
        panel.add(new Checkbox("Euro", grupo1, false));//3 2
        panel.add(new Checkbox("Libra Esterlina", grupo1, false));//3 3

        button = new JButton("Converter");
        button.addActionListener(this);
        panel.add(button);//4 1
        
        space4 = new JLabel("");
        panel.add(space4);//4 2

        resultado = new JLabel("Resultado:");
        panel.add(resultado);//4 3

        getContentPane().add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
    	if (verificaDouble(textField.getText())) {
	        double valorReal = Double.parseDouble(textField.getText());
	        String moedaSelecionada = (String)  grupo1.getSelectedCheckbox().getLabel();
	        double valorConvertido = 0;
	        switch (moedaSelecionada) {
	            case "Dólar":
	                valorConvertido = valorReal * 0.18; // cotação do dólar em 07/04/2023
	                break;
	            case "Euro":
	                valorConvertido = valorReal * 0.16; // cotação do euro em 07/04/2023
	                break;
	            case "Libra Esterlina":
	                valorConvertido = valorReal * 0.13; // cotação da libra esterlina em 07/04/2023
	                break;
	        }
        resultado.setText("Resultado: " + valorConvertido);
    	}
    	else resultado.setText("Valor inválido!");
    }

    public static void main(String[] args) {
        ConversorMoedas conversor = new ConversorMoedas();
    }
    public static boolean verificaDouble(String numero) {
    	try {
    		Double.parseDouble(numero);
    		return true;
    	}
    	catch(Exception e) {
    		return false;
    	}
    }
}