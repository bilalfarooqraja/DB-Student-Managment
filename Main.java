import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DBConnection db= new DBConnection();
        Connection conn=db.connectToDb("postgres","postgres","admin");

        Student s= new Student();

        Scanner input = new Scanner(System.in);
        boolean exit= true;
        while(exit){
        System.out.println("Press 1 to enter student marks\nPress 2 to see student marks\nPress 3 to exist");

        int num = Integer.parseInt(input.nextLine());


            if (num == 1) {
                System.out.println("Enter Student name\n");
                String Sname = input.nextLine();
                System.out.println("Existing Result of "+Sname);
                s.data(conn, Sname);
                System.out.println("Press 1 to Enter oop marks\n" +
                                   "Press 2 to Enter math marks\n" +
                                   "Press 3 to Enter network marks\n" +
                                   "Press 4 to Enter itcp marks\n");
                int subNum = Integer.parseInt(input.nextLine());
                if(subNum==1){

                    if (s.searchSubExist(conn, Sname, "oop") == "dExist") {
                        System.out.println("Enter Student marks\n");
                        String marks = input.nextLine();
                        s.EnterStudentMarks(conn, Sname, "oop", marks);
                    } else {
                        System.out.println("Subject Numbers Already Exist");
                    }

                }
                if(subNum==2){

                    if (s.searchSubExist(conn, Sname, "math") == "dExist") {
                        System.out.println("Enter Student marks\n");
                        String marks = input.nextLine();
                        s.EnterStudentMarks(conn, Sname, "math", marks);
                    } else {
                        System.out.println("Subject Numbers Already Exist");
                    }

                }
                if(subNum==3){

                    if (s.searchSubExist(conn, Sname, "network") == "dExist") {
                        System.out.println("Enter Student marks\n");
                        String marks = input.nextLine();
                        s.EnterStudentMarks(conn, Sname, "network", marks);
                    } else {
                        System.out.println("Subject Numbers Already Exist");
                    }

                }
                if(subNum==4){

                    if (s.searchSubExist(conn, Sname, "itcp") == "dExist") {
                        System.out.println("Enter Student marks\n");
                        String marks = input.nextLine();
                        s.EnterStudentMarks(conn, Sname, "itcp", marks);
                    } else {
                        System.out.println("Subject Numbers Already Exist");
                    }

                }
            }
            if (num == 2) {
                System.out.println("Enter your name to see your result");
                String N = input.nextLine();
                s.searchByName(conn, N);
            }

            if (num == 3) {
                exit=false;
            }
        }
    }
}
