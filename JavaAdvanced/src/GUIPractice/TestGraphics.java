package GUIPractice;

import java.awt.*;

public class TestGraphics {
    public static void main(String[] args) {
      GraphFrame gf = new GraphFrame();
    }
}

class GraphFrame extends Frame{

    GraphFrame(){

        setVisible(true);
    }

    public void paint(Graphics g){
        g.drawRect(400,300,30,40);
        g.drawRoundRect(800,900,50,50,40,40);
    }

}
