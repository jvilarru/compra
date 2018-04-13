package compraprogram;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CompraProgram {
    private DBConnector dbcon;
    public CompraProgram() {
        this.dbcon = new DBConnector("server.lan", 3306, "compra_test", "test", "compra_test");
    }
    public List<String> getList(){
        try {
            return dbcon.getList();
        } catch (SQLException ex) {
            Logger.getLogger(CompraProgram.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }
}
