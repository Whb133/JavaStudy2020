package GUIPractice;

import java.awt.*;

public class TestFrame {
    public static void main(String[] args) {
        Frame f = new Frame("new Window");
        f.setBackground(Color.blue);
        f.setResizable(true);
        f.setSize(300,400);
        f.setLocation(0,0);
        f.setVisible(true);//必须写，不写的话，不可见
        /*
        注：不可直接点击返回关闭，未作组件响应处理
         */
    }
}
