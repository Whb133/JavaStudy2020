package GUIPractice;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumPlus {
    public static void main(String[] args) {
        new PlusFrame().calculate();
    }
}

class PlusFrame extends Frame {
    TextField num1 ,num2 ,num3;
    public void calculate(){
        num1= new TextField();
        num2 = new TextField();
        num3 = new TextField();
        Label label = new Label("+");
        Button button = new Button("=");
        button.addActionListener(new PlusActionListener(this));
        setLayout(new FlowLayout());
        add(num1);
        add(label);
        add(num2);
        add(button);
        add(num3);
        pack();
        setVisible(true);
    }
}

class PlusActionListener implements ActionListener{
    PlusFrame pf;
    PlusActionListener(PlusFrame pf){
        this.pf = pf;
    }
    public void actionPerformed(ActionEvent e){
        pf.num3.setText(Integer.parseInt(pf.num1.getText())+Integer.parseInt(pf.num2.getText())+"");
    }
}
