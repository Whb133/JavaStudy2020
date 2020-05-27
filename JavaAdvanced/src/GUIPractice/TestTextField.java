package GUIPractice;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestTextField {
    public static void main(String[] args) {
        new TFFrame("test TF");
    }
}class TFFrame extends Frame{
    TFFrame(String lable){
        super(lable);
        TextField tf = new TextField();
        tf.setEchoChar('*');
        add(tf);
        tf.addActionListener(new TextFieldListener());
        pack();
        setVisible(true);
    }
}
class TextFieldListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        TextField tf = (TextField) e.getSource();
        System.out.println(tf.getText());
        tf.setText("");
    }
}
