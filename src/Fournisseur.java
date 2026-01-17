//this is the fournisseru file
//it is a namespace for the methods for adding 
//deleting and updating products
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Fournisseur {
    public static void addFournisseur(String name,Connection conn) throws SQLException{
       String sql = "INSERT INTO Fournisseur(nom_fournisseur) VALUES (?)";
       PreparedStatement stmt = conn.prepareStatement(sql);
       stmt.setString(1,name);
       stmt.executeUpdate();
    }
    public static void modifierFournisseur(int id,String name,Connection conn) throws SQLException {
        String sql = "UPDATE Fournisseur SET nom_fournisseur = ? WHERE id_f = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1,name);
        stmt.setInt(2,id);
        stmt.executeUpdate();
    }
    public static void supprimerFournisseur(int id,Connection conn) throws SQLException {
        String sql = "DELETE FROM Fournisseur WHERE id_f = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,id);
        stmt.executeUpdate();
    }
}
