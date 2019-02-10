package SchedulingSystem;

public class Course {
  private String name;
  private String number;
  private String room;
  private String teacher;
  //private Date date=new Date();
  static int MNofD=3;
  private int NofD=0;
  static int MNofT=2;
  private int NofT=0;
  
  private String []days=new String[MNofD];
  private String []times=new String[MNofT];
  
  public String[] getDays(){
    return days;
  }
  public String getDay(int location){
    return days[location];
  }
  public String[] getTimes(){
    return times;
  }
  public String getTime(int location){
    return times[location];
  }
  public void setDays(String day){
    for(int i=0; i<days.length; i++){
      if(days[i]==null){
        days[i]=day;
        NofD++;
        break;
      }
    }
  }
  public void setTimes(String time){
    for(int i=0; i<times.length; i++){
      if(times[i]==null){
        times[i]=time;
        NofT++;
        break;
      }
    }
  }
  
  public void removeDays(){
    for(int i=0; i<days.length; i++){
      days[i]=null;
      NofD--;
    }
  }
  public void removeTimes(){
    for(int i=0; i<times.length; i++){
      times[i]=null;
      NofT--;
    }
  }
  
  public int getNofD(){
    return NofD;
  }
  public int getNofT(){
    return NofT;
  }
  public void setNofD(int num){
    NofD+=num;
  }
  public void setNofT(int num){
    NofT+=num;
  }
    
  public void setName(String name){
    this.name=name;
  }
  public void setNumber(String number){
    this.number=number;
  }
  public void setRoom(String room){
    this.room=room;
  }
  public void setTeacher(String teacher){
    this.teacher=teacher;
  }
  
  //public Date getDate(){
  //  return date;
  //}  
  public String getName(){
    return name;
  }
  public String getNumber(){
    return number;
  }
  public String getRoom(){
    return room;
  }
  public String getTeacher(){
    return teacher;
  }
  
 public void add(String name,String number, String room, String teacher){
   this.name=name;
   this.number=number;
   this.room=room;
   this.teacher=teacher;
   //setDays(day);
   //setTimes(time);
 } 
  
  public void remove(){
    name=null;
    number=null;
    room=null;
    teacher=null;
    removeDays();
    removeTimes();
  }
}
