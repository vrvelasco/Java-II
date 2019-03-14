package remijan.m.lecture;

public class Ex04_Max {

    public static void main(String[] args) {
        
        MaxComparator comparator
            = new MaxComparator();
        
        // Find max of Integer
        Integer imax = comparator.max(new Integer(1), 4);
        System.out.printf("Max integer: %d%n", imax);

        // Find max of double      
        Double dmax = comparator.max(new Double(10.8), 6.5);
        System.out.printf("Max double: %f%n", dmax);
        
        // Find max of Name
        Name nmax = comparator.max(new Name("Rita Red"), new Name("Oscar Orange"));
        System.out.printf("Name max: %s%n", nmax);
    }
}
