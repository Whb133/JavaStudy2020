package ReflectionPractice.ReflectionCodes.Util;

public class People<S> {
    private String name;
    public String sex;

    public People() {

    }

    public People(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "I am a person, my name is " + name;
    }
}
