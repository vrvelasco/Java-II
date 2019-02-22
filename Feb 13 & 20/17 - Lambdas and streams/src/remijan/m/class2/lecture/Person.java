package remijan.m.class2.lecture;

import java.util.StringJoiner;

public class Person {

  private String firstName;
  private String lastName;
  private Integer age;
  private String city;

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public Integer getAge() {
    return age;
  }

  public String getCity() {
    return city;
  }

  public Person(String firstName, String lastName, Integer age, String city) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.city = city;
  }

  @Override
  public String toString() {
    return new StringJoiner(",", "{", "}")
        .add(firstName)
        .add(String.valueOf(age))
        .add(city)
        .toString();
  }
}
