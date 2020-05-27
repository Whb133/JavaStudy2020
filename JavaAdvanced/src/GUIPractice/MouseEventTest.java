package GUIPractice;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class MouseEventTest {
    public static void main(String[] args) {
        new MouseFrame();
    }
}
class MouseFrame extends Frame{

    ArrayList points = new ArrayList();
    MouseFrame(){
        addMouseListener(new MListen());
        setBounds(300,300,400,300);
        setVisible(true);
    }
    void addpoint(Point p){
        points.add(p);
    }
    public void paint(Graphics g){
        Iterator iterator = points.iterator();
        while (iterator.hasNext()){
            Point p = (Point) iterator.next();
            g.setColor(Color.blue);
            g.fillOval(p.x,p.y,10,10);
        }
    }
}
class MListen extends MouseAdapter{
    public void mousePressed(MouseEvent e){
        MouseFrame mf = (MouseFrame) e.getSource();
        mf.addpoint(new Point(e.getX(),e.getY()));
        mf.repaint();
    }
}
