package SchedulingSystem;
//import java.util.Scanner;
public class Student extends Person implements StudentInterface{
  //Scanner in=new Scanner(System.in);
  private int id;
  private int level;
  private String college;
  static int MNofC=3;
  private int NofC;
  private boolean have_a_schedule=false; 
  
  private Course c1=new Course();
  private Course c2=new Course();
  private Course c3=new Course();
  private Course courses[]={c1,c2,c3};
    
  public Course[] getCourses(){
    return courses;
  }
  public boolean getHaveSchedule(){
    return have_a_schedule;
  }
  public void setHaveSchedule(boolean have){
    have_a_schedule=have;
  }
  //public int getMNofC(){
  //  return MNofC;
  //}
  public void setNofC(int num){
    NofC+=num;
  }
  public int getNofC(){
    return NofC;
  } 
  public int getId(){
    return id;
  }  
  public int getLevel(){
    return level;
  }
  public String getCollege(){
    return college;
  }
  public void setID(int id){
    this.id=id;
  }
  public void setLevel(int level){
    this.level=level;
  }
  public void setCollege(String college){
    this.college=college;
  }
  
  /*...............add course...............*/    
  public void addCourse(int location,String name,String number, String room, String teacher) {
    //if(NofC==MNofC){
    //  System.out.println("\nCan't added because the number of courses are exceeded maximumÂ¿\n");
    //}else{
      //boolean able_to_add=true;
      //for(int i=0; i<courses.length; i++){
      //  if(courses[i].getName()==name){
      //   System.out.println("\n This course already exists Â¿\n");
      //    able_to_add=false;
      //    break;
      // }  
      //if((courses[i].getDate().getDay()==day)&&(courses[i].getDate().getTime()==time)){
      //   System.out.println("\nThere is a course in this dateÂ¿");
      //    System.out.print("If you add this course the other course will delete..Are you shore?\n\t1.Yes.\n\tNo.\n\tChoose : ");
      //    int choice=in.nextInt();
      //  switch(choice){
      //      case 1:
       //       courses[i].remove();
       //      break;
        //    case 2:
      //        able_to_add=false;
       //       break;
       //     default:
       //       System.out.println("\nInvalid codeÂ¿\n");
       //       break;    
       //   }  
        //}          
      //}
      //if(able_to_add){
        //for(int i=0; i<courses.length; i++){
        //  if(courses[i].getName()==null){
            courses [location].add(name,number,room,teacher);
            NofC++;
            System.out.println("\nAdd completeÂ¡\n");
          //  break;
         // }
        //}
     // }
    //}
  }
  
  /*...............remove course...............*/
  public void removeOneCourse(String name){
    //if(NofC==0){
    //  System.out.println("\nCan't removed because there no courses foundÂ¿\n");
    //}else{
      boolean found=false;
      for(int i=0; i<courses.length; i++){
        if(courses[i].getName() != null){
          if(courses[i].getName().equals(name)){
            courses[i].remove();
            NofC--;
            found=true;
            System.out.println("\nRemove completeÂ¡\n");
            if(NofC==0){
              have_a_schedule=false;
            }
            break;
          }
        }
      }
      if(!found){
        System.out.println("\nThis course not foundÂ¿\n");
      }
    //}
  }
  
  public void removeAllCourses(){
    //if(MNofC==0){
    //  System.out.println("\nCan't removed because there no courses foundÂ¿\n");
    //}
    for(int i=0; i<courses.length; i++){
      courses[i].remove();
      NofC=0;
    }
    System.out.println("\nRemove completeÂ¡\n");
  }
      
  /*...............add student...............*/
  public void add(String firstName, String lastName, int id, int level, String college){
    //super(firstName,LastName);
    add(firstName,lastName);
    this.id=id;
    this.level=level;
    this.college=college;
  }
}
