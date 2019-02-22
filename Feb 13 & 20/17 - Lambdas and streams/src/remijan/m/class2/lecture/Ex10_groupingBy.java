package remijan.m.class2.lecture;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex10_groupingBy {
    public static void main(String[] args) {
        List<Person> persons = new LinkedList<>();
        persons.add(new Person("Rita", "Red", 34, "St. Louis"));
        persons.add(new Person("Oscar", "Orange", 78, "Chicago"));
        persons.add(new Person("Yet", "Yellow", 5, "New York"));
        persons.add(new Person("Gary", "Green", 21, "St. Louis"));
        persons.add(new Person("Bonnie", "Blue", 37, "New York"));
        persons.add(new Person("Ivan", "Indigo", 13, "Chicago"));
        persons.add(new Person("Vivian", "Violet", 30, "Orlando"));
        
        // People in each city
        System.out.printf("%n");
        {
          Map<String, List<Person>> result =
            persons.stream()
                .collect(
                  Collectors.groupingBy(p -> p.getCity())
                );
          
          System.out.printf("People in cities: %s%n", result);             
        }
        
        // First names in each city
        System.out.printf("%n");
        {
          Map<String, List<String>> result =
            persons.stream()
                .collect(
                  Collectors.groupingBy(
                        p -> p.getCity()
                      , Collectors.mapping(p->p.getFirstName()
                      , Collectors.toList())
                  )
                );
          
          System.out.printf("First names in cities: %s%n", result);             
        }
        
        // Count in each city
        System.out.printf("%n");
        {
          Map<String, Long> result =
            persons.stream()
                .collect(
                  Collectors.groupingBy(
                        p -> p.getCity()
                      , Collectors.counting()
                  )
                );
          
          System.out.printf("Count in cities: %s%n", result);             
        }
        
        // Cities with more than 1 occupant
        System.out.printf("%n");
        {
          List<String> result =
            persons.stream()
                .collect(
                  Collectors.groupingBy(
                        p -> p.getCity()
                      , Collectors.counting()
                  )
                )
                .entrySet().stream()
                  .filter(e -> e.getValue() > 1)
                  .map(e -> e.getKey())
                  .collect(Collectors.toList());
          
          System.out.printf("Cities > 1: %s%n", result);             
        }
        
        // Average age in each city
        System.out.printf("%n");
        {
          Map<String, Double> result =
            persons.stream()
                .collect(
                    Collectors.groupingBy(
                        p->p.getCity()
                        , Collectors.averagingInt(p->p.getAge())
                    )
                );
          System.out.printf("Average age: %s%n", result);
        }
    }
}
