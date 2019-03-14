package remijan.m.lecture;

public class Name implements Comparable<Name> {

    public String name;

    public Name(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "NAME: " + this.name;
    }

    @Override
    public int compareTo(Name that) {
        return this.name.compareTo(that.name);
    }
}
