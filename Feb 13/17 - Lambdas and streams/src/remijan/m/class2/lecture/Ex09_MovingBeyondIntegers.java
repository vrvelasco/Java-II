package remijan.m.class2.lecture;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Ex09_MovingBeyondIntegers {
    public static void main(String[] args) {
        List<Person> persons = new LinkedList<>();
        persons.add(new Person("Rita", "Red", 34, "St. Louis"));
        persons.add(new Person("Oscar", "Orange", 78, "Chicago"));
        persons.add(new Person("Yet", "Yellow", 5, "New York"));
        persons.add(new Person("Gary", "Green", 21, "St. Louis"));
        persons.add(new Person("Bonnie", "Blue", 37, "New York"));
        persons.add(new Person("Ivan", "Indigo", 13, "Chicago"));
        persons.add(new Person("Vivian", "Violet", 30, "Orlando"));
        
        // max age
        System.out.printf("%n");
        {
          int result =
            persons.stream()
                .mapToInt(Person::getAge)
                .max()
                .getAsInt();
          System.out.printf("Max age: %d%n", result);
        }
        
        
        // People in their 30's
        System.out.printf("%n");
        {
          List<Person> result = persons.stream()
              .filter(p -> p.getAge() >= 30 && p.getAge() <= 39)
              .collect(Collectors.toList());
          System.out.printf("30's: %s%n", result);
        }
        
        // First person (last name alphabetical) in Chicago
        System.out.printf("%n");
        {
          Person result = persons.stream()
              .filter(p -> "Chicago".equals(p.getCity()))
              .sorted((p1, p2) -> p1.getLastName().compareTo(p2.getLastName()))
              .findFirst()
              .get();
          System.out.printf("1st in Chicago: %s%n", result);
        }
        
        // Sorted by city (alphabetical) & last name (reverse)
        System.out.printf("%n");
        {
          List<Person> result =
          persons.stream()
              .sorted(
                  Comparator
                    .comparing(Person::getCity)
                    .thenComparing(Person::getLastName, Comparator.reverseOrder())
              )
              .collect(Collectors.toList());
          
          System.out.printf("Sorted by city & last name%n");
          result.stream()
              .forEach(p -> System.out.printf("%s, %s%n", p.getCity(), p.getLastName()));
        }
    }
}
