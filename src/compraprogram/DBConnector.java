package compraprogram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jvilarru
 */
public class DBConnector {
//    static {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch(ClassNotFoundException ex) {
//            System.err.println("Unable to load MySQL Driver" + ex.getMessage());
//        }
//    }
    private Connection con;

    public DBConnector(String server, int port, String username, String password, String DBName ) {
        //String jdbcUrl = "jdbc:mysql://" + server + ":" + port + "/" + DBName + "?user=" + username + "&password=" + password;
        String jdbcUrl = "jdbc:mysql://" + server + "/" + DBName + "?user=" + username + "&password=" + password;
        try {
            this.con = DriverManager.getConnection(jdbcUrl);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<String> getList() throws SQLException{
        List<String> results= new ArrayList<>();
        Statement st = this.con.createStatement();
        ResultSet rs = st.executeQuery("SELECT element,quantity,price FROM llista_compra");
        while (rs.next()){
            String result = rs.getString(1) + "," + rs.getInt(2) + "," + rs.getFloat(3);
            results.add(result);
        }
        return results;
    }
    
}
