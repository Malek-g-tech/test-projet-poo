import java.sql.*;

public class Main{
    public static void main(String[] args){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacie",
                    "talel",
                    "123");
            System.out.println("reussi");
        }catch  (SQLException e){
            System.out.println("no conn");
        }
        System.out.println("hello world");
    }
}
