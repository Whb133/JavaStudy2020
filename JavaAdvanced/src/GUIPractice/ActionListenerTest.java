package GUIPractice;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerTest {
    public static void main(String[] args) {
        Frame f= new Frame("TEST");
        Button b = new Button("EXIT");
        f.add(b);
        ButtonListener bl = new ButtonListener();
        b.addActionListener(bl);
        f.setLocation(300,400);
        f.setSize(60,80);
        f.setVisible(true);
    }
}
class ButtonListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("a button hsa been pressed!");
        System.exit(0);
    }
}
