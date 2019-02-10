package SchedulingSystem;

public class Person implements PersonInterface{
  private String firstName;
  private String lastName;
  
 /* public Person(String firstName, String lastName){
    this.firstName=firstName;
    this.lastName=lastName;
  }*/
  public void setFirstName(String firstName){
    this.firstName=firstName;
  }
  public void setLastName(String lastName){
    this.lastName=lastName;
  }
  public String getFirstName(){
    return firstName;
  }
  public String getLastName(){
    return lastName;
  }
  public String getName(){
    return firstName+" "+lastName;
  }
  
  public void add(String firstName, String lastName){
    this.firstName=firstName;
    this.lastName=lastName;
  }
}
