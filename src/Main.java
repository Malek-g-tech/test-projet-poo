import java.sql.*;

public class Main{
    public static void main(String[] args){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacie",
                    "talel",
                    "123");
            Product.addProduct("dolpran",1,123.0f,conn);
        }catch  (SQLException e){
            System.out.println(e.getMessage());
        }
        System.out.println("hello world");
    }
}
