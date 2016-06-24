package model;

/**
 * Created by tk3sy on 24.12.2015.
 */
public class Student {

  private String LastName;
  private String FirstName;

  public Student(String lastName, String firstName) {
    this.LastName = lastName;
    this.FirstName = firstName;
  }

  public String getLastName() {
    return LastName;
  }

  public void setLastName(String lastName) {
    LastName = lastName;
  }

  public String getFirstName() {
    return FirstName;
  }

  public void setFirstName(String firstName) {
    FirstName = firstName;
  }
}

