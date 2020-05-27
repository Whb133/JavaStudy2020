package containerPractice.ContainerCode;

import java.util.Collection;
import java.util.HashSet;

public class CollectionTest {
    public static void main(String[] args) {
        Collection c = new HashSet();
        int i = 10;
        c.add("hello");
        c.add(new Integer(100));
        c.add(i); //自动装箱
        c.add(new String("whb"));
        c.add(new Name("hb","w"));

        c.remove("hello");
        c.remove(new Integer(100));
        c.remove(new String("whb"));
        System.out.println(c.remove(new Name("hb","w")));
        System.out.println(c);
    }
}
class  Name{
    private String firstName;
    private String lastName;
    Name(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Name){
            Name name = (Name)obj;
            if (name.firstName.equals(this.firstName) && name.lastName.equals(this.lastName)){
                return true;
            }
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return firstName.hashCode();
    }

    @Override
    public String toString() {
        return "Name:"+lastName+firstName;
    }
}
