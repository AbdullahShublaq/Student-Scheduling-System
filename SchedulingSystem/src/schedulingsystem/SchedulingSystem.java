
package SchedulingSystem;

/**
 *
 * @author Abdullah Shublaq
 */

import java.util.Scanner;

public class SchedulingSystem {
  static Scanner in = new Scanner(System.in);
  static String time[] = {"8-9", "9-10", "10-11", "11-12", "12-1", "1-2", "2-3", "3-4"};
  static String day[] = {"Std", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri"};
  static Student currentSTD = null;
  static int MNofS = 2;
  static int NofS = 0;

  public static void view() {
    boolean loop = true;
    while (loop) {
      System.out.println("--------------------");
      System.out.print("\n1.Creat schedule form.\n2.Display schedule form.\n3.Modify schedule form.\n4.Delete schedule form.\n5.Sign out.\n\tChoose : ");
      int choice = in.nextInt();
      switch (choice) {
        case 1:
          if (currentSTD.getHaveSchedule()) {
            System.out.println("\nYou already have a scheduleÂ¿\n");
          } else {
            creatCourse(currentSTD.getCourses());
          }
          break;
        case 2:
          displaySchedule(currentSTD.getCourses());
          break;
        case 3:
          modifySchedule(currentSTD.getCourses());
          break;
        case 4:
          deleteSchedule();
          break;
        case 5:
          loop = false;
          break;
        default:
          System.out.println("\nInvalid codeÂ¿\n");
          break;
      }
    }
  }

  public static void creatCourse(Course[] courses) {
    int currentCRS = 0;
    boolean loop = true;
    while (loop) {
      System.out.println("--------------------");
      if (currentSTD.getNofC() == Student.MNofC) {
        System.out.println("\nThe number of courses arrived maximumÂ¿\n");
        loop = false;
      } else {
        System.out.println("\nNote : you can add " + (Student.MNofC - currentSTD.getNofC()) + " courses.");
        in.nextLine();
        System.out.print("\tEnter course name : ");
        String c_name = in.nextLine();
        // String name=c_name;
        boolean found = false;
        for (int i = 0; i < courses.length; i++) {
          if (!(courses[i].getName() == null)) {
            if (courses[i].getName().equalsIgnoreCase(c_name)) {
              System.out.println("\nThis course already existsÂ¿\n");
              found = true;              
              loop = false;
            }
          }
        }
        if (!found) {
          for (int x = 0; x < courses.length; x++) {
            if (courses[x].getName() == null) {
              currentCRS = x;
              break;
            }
          }
          // courses[currentCRS].setName(c_name);
          // in.nextLine();
          System.out.print("\tEnter course number : ");
          String c_number = in.nextLine();
          System.out.print("\tEnter course room : ");
          String room = in.nextLine();
          System.out.print("\tEnter course teacher : ");
          String teacher = in.nextLine();
          System.out.print("\n\tAre you sure you want to creat this course.\n\t\t1.Yes.\n\t\t2.No.\n\t\tChoose : ");
          // in.nextLine();
          String choice1 = in.next();
          switch (choice1) {
            case "1":
              currentSTD.addCourse(currentCRS, c_name, c_number, room, teacher);
              // currentSTD.setNofC(1);
              creatDate(courses, currentCRS);
              currentSTD.setHaveSchedule(true);
              System.out.println("\ncourse createdÂ¡\n");
              System.out.print("Are you want to Creat another course.\n\t1.Yes.\n\t2.No.\n\tChoose : ");
              String choice2 = in.next();
              switch (choice2) {
                case "1":
                  break;
                case "2":
                  loop = false;
                  break;
                default:
                  System.out.println("\nInvalid codeÂ¿\n");
                  break;
              }
              break;
            case "2":
              System.out.println("\nCourse has not creatÂ¡\n");
              loop = false;
              break;
            default:
              System.out.println("\nInvalid codeÂ¿\n");
              break;
          }
        }
      }
    }
  }

  public static void creatDate(Course[] courses, int currentCRS) {
    freeTime(courses);
    boolean conflict = false;
    do {
      System.out.println("\n\nChoose the day(" + Course.MNofD + " day at most) : ");
      for (int i = 0; i < day.length; i++) {
        System.out.println("\t" + (i + 1) + ". " + day[i]);
      }
      boolean loop1 = true;
      while (loop1) {
        if (courses[currentCRS].getNofD() == Course.MNofD) {
          System.out.println("\nThe number of days arrived maximumÂ¿\n");
          loop1 = false;
        } else {
          System.out.print("\t\tChoose day : ");
          int num = in.nextInt();
          if (num > 7 && num < 1) {
            System.out.println("\nInvalid dayÂ¿\n");
            continue;
          } else {
            if (num == 6 || num == 7) {
              System.out.print("\nAre you sure you want to choose this day because this day are unusual lectures days.");
              System.out.print("\n\t1.Yes.\n\t2.No.\n\tChoose : ");
              int choice3 = in.nextInt();
              switch (choice3) {
                case 1:
                  courses[currentCRS].setDays(day[num - 1]);
                case 2:
                  break;
                default:
                  System.out.println("\nInvalid codeÂ¿\n");
                  break;
              }
            } else {
              courses[currentCRS].setDays(day[num - 1]);
            }
            if (!(courses[currentCRS].getNofD() == Course.MNofD)) {
              System.out.print("\nAre you want to choose another day.\n\t1.Yes.\n\t2.No.\n\tChoose : ");
              int choice2 = in.nextInt();
              switch (choice2) {
                case 1:
                  break;
                case 2:
                  loop1 = false;
                  break;
                default:
                  System.out.println("\nInvalid codeÂ¿\n");
                  break;
              }
            } else {
              loop1 = false;
            }
          }
        }
      }
      System.out.println("\nChoose the time(" + Course.MNofT + "hour at most) : ");
      for (int i = 0; i < time.length; i++) {
        System.out.println("\t" + (i + 1) + ". " + time[i]);
      }
      System.out.print("\n\t1.One hour.\n\t2.Two hours.\n\tChoose : ");      
      boolean loop2 = true;
      while (loop2) {
        int Choice2 = in.nextInt();
        switch (Choice2) {
          case 1:
            System.out.print("\t\tChoose time : ");
            int num2 = in.nextInt();
            if (num2 > 8 && num2 < 1) {
              System.out.println("\nInvalid timeÂ¿\n");
              continue;
            } else {
              courses[currentCRS].setTimes(time[num2 - 1]);
              conflict = checkTheDate(courses, currentCRS);
              loop2 = false;
            }
            break;
          case 2:
            for (int z = 0; z < courses[currentCRS].getTimes().length; z++) {
              System.out.print("\t\tChoose " + (z + 1) + "'s hour : ");
              int num3 = in.nextInt();
              if (num3 > 8 && num3 < 1) {
                System.out.println("\nInvalid timeÂ¿\n");
                continue;
              } else {
                courses[currentCRS].setTimes(time[num3 - 1]);
                conflict = checkTheDate(courses, currentCRS);
                loop2 = false;
              }
            }
            break;
          default:
            System.out.println("\nInvalid codeÂ¿\n");
            break;
        }
      }
    } while (conflict);
  }

  public static boolean checkTheDate(Course[] courses, int currentCRS) {
    boolean conflict = false;
    for (int c = 0; c < courses.length; c++) {
      if (c == currentCRS) {
        continue;
      }
      //if (!conflict) {
      for (int d = 0; d < courses[c].getDays().length; d++) {
        for (int ccd = 0; ccd < courses[currentCRS].getDays().length; ccd++) {
          if (courses[c].getDay(d) != null && courses[currentCRS].getDay(ccd) != null) {
            if (courses[c].getDay(d) == courses[currentCRS].getDay(ccd)) {
              for (int t = 0; t < courses[c].getTimes().length; t++) {
                for (int cct = 0; cct < courses[currentCRS].getTimes().length; cct++) {
                  if (courses[c].getTime(t) != null && courses[currentCRS].getTime(cct) != null) {
                    if (courses[c].getTime(t) == courses[currentCRS].getTime(cct)) {
                      System.out.println("\nThis course conflicted with " + courses[c].getName());
                      System.out.println("Are you sure you want to add this course.(If you add this course the other course will delete)");
                      System.out.print("\t1.Yes.\n\t2.No.\n\tChoose : ");
                      int choice = in.nextInt();
                      switch (choice) {
                        case 1:
                          currentSTD.removeOneCourse(courses[c].getName());
                          System.out.println("\nThe other course deleteÂ¡\n");
                          conflict = false;
                          break;
                        case 2:
                          courses[currentCRS].removeDays();
                          courses[currentCRS].removeTimes();
                          conflict = true;
                          break;
                        default:
                          System.out.println("\nInvalid codeÂ¿\n");
                          break;
                      }
                    }
                  }
                }
              }
              if (conflict) {
                break;
              }
            }
          }
        }
      }
      //}
      if (conflict) {
        break;
      }
    }
    return conflict;
  }

  public static void freeTime(Course[] courses) {
    System.out.println("----------list of free time----------");
    /*boolean found = false;*/
    boolean found2 = false;
    for (int d = 0; d < day.length; d++) {
      System.out.print("\n" + day[d] + " :");
      for (int t1 = 0; t1 < time.length; t1++) {
        for (int c = 0; c < courses.length; c++) {
          if(courses[c].getName() !=null){
            for (int cd = 0; cd < courses[c].getDays().length; cd++) {
              if (courses[c].getDay(cd) != null) {
                if (day[d] == courses[c].getDay(cd)) {
                  /*found = true;*/
              
                  for (int ct = 0; ct < courses[c].getTimes().length; ct++) {
                    if (courses[c].getTime(ct) != null) {
                      if (time[t1] == courses[c].getTime(ct)) {
                        found2 = true;
                        //break;
                      }
                    }
                  }
                  
                }
              }
            }
          }
          //break;
        } 
        if (!found2) {
          System.out.print("\t\t" + time[t1]);
        }
        found2 = false;       
      }
      /*if (!found) {
        for (int t2 = 0; t2 < time.length; t2++) {
          System.out.print("\t\t" + time[t2]);
        }                      
      }*/
      /*found=false;*/
      found2=false;
    }
  }

  public static void displaySchedule(Course[] courses) {
    System.out.println("--------------------");
    boolean found = false;
    if (currentSTD.getHaveSchedule()) {
      System.out.println("\nName : "+ currentSTD.getName()+ "\t\tCollege : "+ currentSTD.getCollege()+ "\nID : "+ currentSTD.getId()+ "\t\tLevel : "+ currentSTD.getLevel()+ "\n");
      System.out.printf(" %15s %15s %15s %10s %10s %10s %10s %10s %10s %10s %10s","Number","Name","Teacher","Room","Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday");
      System.out.println();
      for (int c = 0; c < courses.length; c++) {
        String Time = "";
        if (!(courses[c].getName() == null)) {
          System.out.printf(" %15s %15s %15s %10s",courses[c].getNumber(),courses[c].getName(),courses[c].getTeacher(),courses[c].getRoom());
          for (int d = 0; d < day.length; d++) {
            for (int cd = 0; cd < courses[c].getDays().length; cd++) {
              if (courses[c].getDay(cd) != null) {
                if (day[d] == courses[c].getDay(cd)) {
                  found = true;
                  for (int t = 0; t < time.length; t++) {
                    for (int ct = 0; ct < courses[c].getTimes().length; ct++) {
                      if (courses[c].getTime(ct) != null) {
                        if (time[t] == courses[c].getTime(ct)) {
                          Time = Time.concat(time[t]);
                        }
                      }
                    }
                  }
                  int p1 = Time.indexOf("-");
                  int p2 = Time.lastIndexOf("-");
                  String finalTime = Time.substring(0, p1) + Time.substring(p2);
                  System.out.printf(" %10s", finalTime);
                  break;
                }
              }
            }
            if (!found) {
              System.out.printf(" %10s", "_");
            }
            found = false;
          }
          System.out.println();
        }
      }
    } else {
      System.out.println("\nThe student not have a scheduleÂ¿\n");
    }
  }

  public static void modifySchedule(Course[] courses) {
    boolean loop = true;
    while (loop) {
      System.out.println("--------------------");
      if (currentSTD.getHaveSchedule()) {
        System.out.print("1.Enter new course.\n2.Delete course\n3.Change time course.\n4.back.\n\tChoose : ");
        int choice = in.nextInt();
        switch (choice) {
          case 1:
            creatCourse(currentSTD.getCourses());
            break;
          case 2:
            in.nextLine();
            System.out.print("\t\tEnter course name : ");
            String name = in.nextLine();
            currentSTD.removeOneCourse(name);
            break;
          case 3:
            in.nextLine();
            int currentCRS = 0;
            System.out.print("\t\tEnter course name : ");
            String name2 = in.nextLine();
            boolean found = false;
            for (int i = 0; i < courses.length; i++) {
              if (courses[i].getName() != null) {
                if (courses[i].getName().equals(name2)) {
                  currentCRS = i;
                  courses[i].removeDays();
                  courses[i].removeTimes();
                  creatDate(courses, currentCRS);
                  found = true;
                }
              }
            }
            if (!found) {
              System.out.println("\nThis course not foundÂ¿\n");
            }
            break;
          case 4:
            loop = false;
            break;
          default:
            System.out.println("\nInvalid codeÂ¿\n");
        }
      } else {
        System.out.println("\nThe student not have a scheduleÂ¿\n");
        loop = false;
      }
    }
  }

  public static void deleteSchedule() {
    System.out.println("--------------------");
    if (currentSTD.getHaveSchedule()) {
      System.out.print("Are you sure you want to delete your schedule?\n\t1.Yes.\n\t2.No.\n\tChoose : ");
      int choice = in.nextInt();
      switch (choice) {
        case 1:
          currentSTD.removeAllCourses();
          currentSTD.setHaveSchedule(false);
          System.out.println("\nSchedule deletedÂ¡\n");
          break;
        case 2:
          break;
        default:
          System.out.println("\nInvalid codeÂ¿\n");
          break;
      }
    } else {
      System.out.println("\nThe student not have a scheduleÂ¿\n");
    }
  }

  public static void main(String[] args) {

    Student std1 = new Student();
    Student std2 = new Student();
    Student std[] = {std1, std2};

    System.out.println("ã€‚ã€‚ã€ŽHelloã€ ã€‚ã€‚");
    boolean loop1 = true;
    while (loop1) {
      System.out.println("____________________");
      System.out.print("\n1.Sign in.\n2.Creat new student.\n3.Exit.\n\tchoose : ");
      int choice1 = in.nextInt();
      switch (choice1) {
        case 1:
          if (NofS == 0) {
            System.out.println("\nThere is not any studentÂ¿\n");
          } else {
            System.out.print("\tEnter the id:");
            int id = in.nextInt();
            boolean found = false;
            for (int i = 0; i < std.length; i++) {
              if (std[i].getId() == id) {
                currentSTD = std[i];
                found = true;
                view();
              }
            }
            if (!found) {
              System.out.println("\nThis id not foundÂ¿\n");
            }
          }
          break;
        case 2:
          if (NofS == MNofS) {
            System.out.println("\nCan't added because the number of students are exceeded maximumÂ¿\n");
          } else {
            for (int i = 0; i < std.length; i++) {
              if (std[i].getId() == 0) {
                currentSTD = std[i];
                break;
              }
            }
            System.out.print("\tEnter the first name : ");
            String f_name = in.next();
            System.out.print("\tEnter the last name : ");
            String l_name = in.next();
            System.out.print("\tEnter student id : ");
            int id = in.nextInt();
            boolean found = false;
            for (int x = 0; x < std.length; x++) {
              if (std[x].getId() == id) {
                System.out.println("\nThis student already existsÂ¿\n");
                found = true;
                break;
              }
            }
            if (!found) {
              System.out.print("\tEnter student college : ");
              String college = in.next();
              System.out.print("\tEnter student level : ");
              int level = in.nextInt();
              System.out.print("\n\tAre you sure you want to creat this student.\n\t\t1.Yes.\n\t\t2.No.\n\t\tChoose : ");
              int choice2 = in.nextInt();
              switch (choice2) {
                case 1:
                  System.out.println("\nStudent createdÂ¡\n");
                  NofS++;
                  currentSTD.add(f_name, l_name, id, level, college);
                  view();
                  break;
                case 2:
                  System.out.println("\nStudent has not createdÂ¡\n");
                  break;
                default:
                  System.out.println("\nInvalid codeÂ¿\n");
                  break;
              }
            }
          }
          break;
        case 3:
          System.out.println("\nGood byeÂ¡");
          loop1 = false;
          break;
        default:
          System.out.println("\nInvalid codeÂ¿\n");
      }
    }
  }
}
