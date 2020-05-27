package GUIPractice;

import java.awt.*;

public class TestFlowLayout {
    public static void main(String[] args) {
        Frame f = new Frame("My Frame");
        f.setLayout(new FlowLayout());
        f.add(new Button("register"));
        f.add(new Button("login"));
        f.add(new Button("logout"));
        f.setVisible(true);
    }
}
