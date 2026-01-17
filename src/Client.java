//this is the client file
//it is a namespace for the methods for adding 
//deleting and updating products
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Client {
    public static void addClient(String name,Connection conn) throws SQLException{
       String sql = "INSERT INTO Client(nom_client) VALUES (?)";
       PreparedStatement stmt = conn.prepareStatement(sql);
       stmt.setString(1,name);
       stmt.executeUpdate();
    }
    public static void modifierClient(int id,String name,Connection conn) throws SQLException {
        String sql = "UPDATE Client SET nom_client=? WHERE id_c = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1,name);
        stmt.setInt(2,id);
        stmt.executeUpdate();
    }
    public static void supprimerClient(int id,Connection conn) throws SQLException {
        String sql = "DELETE FROM Client WHERE id_client = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,id);
        stmt.executeUpdate();
    }
}
