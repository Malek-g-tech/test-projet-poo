//this is the product fiel
//it is a namespace for the methods for adding 
//deleting and updating products
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Product {
    public static void addProduct(String name,int quantite,float price, Connection conn) 
    throws SQLException{
       String sql = "INSERT INTO Medicament(libelle,quantite,prix) VALUES (?,?,?)";
       PreparedStatement stmt = conn.prepareStatement(sql);
       stmt.setString(1,name);
       stmt.setInt(2,quantite);
       stmt.setFloat(3,price);
       stmt.executeUpdate();
    }
}
