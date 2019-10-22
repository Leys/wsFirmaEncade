/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author diego
 */
public class clsConexion {
    Connection cnn;
    Statement st;

    public clsConexion() {
    }
    
    public Connection conexion() throws SQLException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cnn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/BD_HASH","root","3209");
        }
        catch (ClassNotFoundException | SQLException e){
            System.out.println("Error" + e.getMessage());
        }
        return cnn;
    }
    
    Statement createStatement(){
        throw new UnsupportedOperationException("No soporta la conexión a la base de datos");
    }
    
    
}
