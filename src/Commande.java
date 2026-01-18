//this is the product fiel
//it is a namespace for the methods for adding 
//deleting and updating products
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;


public class Commande {
    public static void addCommande( int id_m ,int id_f ,Date date_comm ,int quantite ,
            float prix_unit,Connection conn)
            throws SQLException{
            String sql = "INSERT INTO Commande(id_m,id_f,date_comm,quantite,prix_unit) VALUES (?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id_m);
            stmt.setInt(2,id_f);
            stmt.setDate(3,date_comm);
            stmt.setInt(4,quantite);
            stmt.setFloat(5,prix_unit);
            stmt.executeUpdate();
    }

    public static void modifierCommande( int id_m ,int id_f ,Date date_comm ,int quantite ,
            float prix_unit,Connection conn)
            throws SQLException {
            String sql = "UPDATE Commande SET Date=?,quantite=?,prix_unit=? WHERE id_m = ? AND id_f=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDate(1,date_comm);
            stmt.setInt(2,quantite);
            stmt.setFloat(3,prix_unit);
            stmt.setInt(4,id_m);
            stmt.setInt(5,id_f);
    }

    public static void supprimerCommande(int id_m,int id_f, Connection conn) throws SQLException {
        String sql = "DELETE FROM Commande WHERE id_m = ? AND id_f = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,id_m);
        stmt.setInt(2,id_f);
        stmt.executeUpdate();
    }

}
