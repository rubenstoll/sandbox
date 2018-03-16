package persistence.jpa.tutorialspoint.model;

/**
 * user model
 */
public class User {

  private Integer id;
  private String firstName;
  private String lastName;
  private Integer age;

  public User() {
  }

  public User(int id, String first, String last, int age) {
    this.id = id;
    this.firstName = first;
    this.lastName = last;
    this.age = age;
  }

  public String toString() {
    return "" + id + ", " + firstName + ", " + lastName + ", " + age;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }
}