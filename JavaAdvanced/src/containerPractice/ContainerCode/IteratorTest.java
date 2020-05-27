package containerPractice.ContainerCode;

import containerPractice.ContainerCode.Name;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorTest {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add(new Name("whb", "1"));
        c.add(new Name("lhr", "2"));
        c.add(new Name("lxy", "3"));
        c.add(new Name("zxc", "4"));
        c.add(new Name("bnm", "5"));
        Iterator i = c.iterator();
        int k = 0;
        while (i.hasNext()) {
            k++;
            System.out.println(i.next());
            if (k == 3) {
                i.remove();
            }
        }
        System.out.println("*************************");
        Iterator i2 = c.iterator();
        while (i2.hasNext()) {
            System.out.println(i2.next());
        }
    }
}
