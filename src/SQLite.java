import java.sql.*;

public class SQLite {

    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            //Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\autores.sqlite");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:autores.sqlite");
           
            Statement stat = conn.createStatement();
//            stat.execute("DELETE FROM autores");
 /*          
            PreparedStatement prep = conn.prepareStatement("INSERT INTO autores (id,nombre) VALUES (?, ?);");
            prep.setInt(1,1);
            prep.setString(2,"Deitel");
            prep.addBatch();
            prep.setInt(1,2);
            prep.setString(2,"Ceballos");
            prep.addBatch();
            prep.setInt(1,3);
            prep.setString(2,"Joyanes Aguilar");
            prep.addBatch(); 
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);        
*/
           //ResultSet rs = stat.executeQuery("select * from autores;");
            ResultSet rs = stat.executeQuery("select autores.* from autores,publicaciones where autores.id=publicaciones.id_autor AND publicaciones.id_libro=1233;");
            System.out.println("\t\tCONSULTAMOS");
            if(rs.isBeforeFirst()){//
            	System.out.println("\t\tIMPRIMIMOS");
            	}
            
            else
            	System.out.println("\t\tNADA QUE IMPRIMIR");
            while (rs.next()) {
            	System.out.println("ID_AUTOR...: " + rs.getString("id"));
                System.out.println("NOMBRE.....: " + rs.getString("nombre"));
                System.out.println("-----------------------------------");
            }
            System.out.println("\t\tTERMINAMOS.");
            rs.close();
            stat.close();
            conn.close();
             
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
     
    }
}
