import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Student {

    public void InsertStudent(Connection conn,String name,String address){
        Statement statement;
        try {
            String query=String.format("Insert into %s(name,address) values('%s','%s');","Student",name,address);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row Inserted");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void InsertCourse(Connection conn,String name){
        Statement statement;
        try {
            String query=String.format("Insert into %s(course) values('%s');","course",name);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row Inserted");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void EnterStudentMarks(Connection conn,String sname,String subject,String marks){
        Statement statement;
        try {
            String query=String.format("Insert into %s(student_name) values('%s');","student",sname);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            String queryb=String.format("Insert into %s(subject_name) values('%s');","subject",subject);
            statement = conn.createStatement();
            statement.executeUpdate(queryb);
            String queryc=String.format("Insert into %s(marks) values('%s');","marks",marks);
            statement = conn.createStatement();
            statement.executeUpdate(queryc);
            System.out.println("Row Inserted");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void searchByName(Connection conn, String name){
        Statement statement;
        ResultSet rs=null;
        try {
            String query="marks,subject_name\n" +
                    "  FROM student\n" +
                    "  NATURAL JOIN marks\n" +
                    "  NATURAL JOIN subject\n" +
                    "  WHERE student_name = '"+name+"';";
            statement = conn.createStatement();
            rs=statement.executeQuery(query);
            System.out.println("Name: "+name);
            while (rs.next()){
                System.out.println("Marks in "+rs.getString("subject_name")+":"+rs.getString("marks"));
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public String searchSubExist(Connection conn, String name,String Subject){
        Statement statement;
        ResultSet rs=null;
        String tem = "dExist";
        try {
            String query="SELECT student.student_name,subject_name\n" +
                    "  FROM student\n" +
                    "  NATURAL JOIN marks\n" +
                    "  NATURAL JOIN subject\n" +
                    "  WHERE student_name = '"+name+"' AND subject_name = '"+Subject+"';";
            statement = conn.createStatement();
            rs=statement.executeQuery(query);
            while (rs.next()){

                String value=rs.getString("subject_name");
                if(value.equals(Subject)){
                    tem ="exist";
                    return tem;
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return tem;
    }

    public void data(Connection conn, String name){
        Statement statement;
        ResultSet rs=null;
        try {
            String query="SELECT marks,subject_name\n" +
                    "  FROM student\n" +
                    "  NATURAL JOIN marks\n" +
                    "  NATURAL JOIN subject\n" +
                    "  WHERE student_name = '"+name+"';";
            statement = conn.createStatement();
            rs=statement.executeQuery(query);
            System.out.println("Name: "+name);
            while (rs.next()){
                System.out.println("Marks in "+rs.getString("subject_name")+":"+rs.getString("marks"));
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
