import java.sql.*;
import java.sql.DriverManager;
import java.util.Date;
import java.util.Scanner;

public class Vente{
    public static void addVente(int id_m,int id_c,Date date,int quantite){
        String query = "INSERT INTO Vente VALUES(?,?,?,?,?)";
        String getP = "SELECT prix FROM Medicament WHERE id_m = ?";

        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacie","malek","password");
            PreparedStatement ps = conn.prepareStatement(query);
            PreparedStatement ps2 = conn.prepareStatement(getP);){
                ps2.setInt(1,id_m);
                ResultSet rs = ps.executeQuery();
                double prix = 0;
                if (rs.next()){
                    prix = rs.getFloat("prix") * quantite;
                }
                ps.setInt(1,id_m);
                ps.setInt(2,id_c);
                ps.setDate(3, (java.sql.Date) date);
                ps.setInt(4, quantite);
                ps.setDouble(5, prix);
                ps.executeUpdate();
            } catch(SQLException e){
                e.printStackTrace();
            }
    }
    public static ResultSet searchVente(int id_m,int id_c,Date date){
        String query = "SELECT * FROM Vent WHERE im_m = ? AND id_c = ? and dateV = ?";
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacie","malek","password");
            PreparedStatement ps = conn.prepareStatement(query)){
            ps.setInt(1,id_m);
            ps.setInt(2,id_c);
            ps.setDate(3, (java.sql.Date) date);
            ResultSet rs = ps.executeQuery();
            return rs;
//            if(rs.next()){
//                Date D = rs.getDate("dateV");
//                int q = rs.getInt("quantite");
//                float p = rs.getFloat("prix");
//                String res = ""; // a termine (b5olt)
//                return res;
//
//            }

        }
        catch(SQLException e){
            e.printStackTrace();

        }
        return null;
    }
    public static void modifVente(int id_m,int id_c,Date date){
        String query ="UPDATE Vente SET quantite = ? , prix = ?WHERE id_m = ? and id_c = ? and dateV = ?";
        String getP = "SELECT prix FROM Medicament WHERE id_m = ?";
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacie","malek","password");
            PreparedStatement ps = conn.prepareStatement(query);
            PreparedStatement ps2 = conn.prepareStatement(getP)){
            Scanner scan = new Scanner(System.in);
            ps2.setInt(1,id_m);
            ResultSet rs = ps.executeQuery();
            double prix = 0;
            if (rs.next()){
                prix = rs.getFloat("prix") ;
            }
            System.out.println("========================================");
            System.out.println("1.queantite");
            int q = scan.nextInt();
            ps.setInt(1,q);
            ps.setDouble(2,prix);
            ps.setInt(3,id_m);
            ps.setInt(4,id_c);
            ps.setDate(5, (java.sql.Date) date);

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}