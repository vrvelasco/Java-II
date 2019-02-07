package remijan.m.example;

import java.util.Comparator;

public class LastNameComparator implements Comparator<Name> {

    @Override
    public int compare(Name o1, Name o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }

}
