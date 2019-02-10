package SchedulingSystem;

public class Date implements DateInterface{
  private String time;
  private String day;
  
  public String getTime(){
    return time;
  }
  public String getDay(){
    return day;
  }
  public void setTime(String time){
    this.time=time;
  }
  public void setDay(String day){
    this.day=day;
  }
  
  public void remove(){
    time=null;
    day=null;
  }
  
  public void add(String time, String day){
    this.time=time;
    this.day=day;
  }
}
