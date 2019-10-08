/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import com.mysql.jdbc.Statement;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Adaleysi
 */
public class clsDatos {
    
    
   //se crean atributos para que sean accesibles fesde la vista
    private String usu;
    private String pas;
    //private String nombre;
    
    //atributos de validar acceso como resultado
    private int cve;
    private String nombre;
    private int estatus;
    private String fechReg;
    
    //crear el constructor de usuario
    //clic dercho-- insert code -- constructor
    
    

    public clsDatos(int clave,String usuario, String pas, String nombre,int estatus) {
        this.cve = clave;
        this.usu = usuario;
        this.pas = pas;
        this.nombre = alias;
        this.estatus = foto;
    }
    
    
    //Cadena de conexión
    Connection cnn;
    //Equivalente al DataSet
    ResultSet rs;
    //variable para manejar las instrucciones
    String consultaSql="";
    //Equivalente al command
    Statement st;
    
    //Se crea la conexión a ka case de datos
    public Connection conexion() throws SQLException{
        try{
            //Se agrega el driver de conexión
            Class.forName("com.mysql.jdbc.Driver");
            
            cnn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/BD_HASH","root","adaleysi97yo");
            
            System.out.println("Se hizo la conexión a la base de datos");
        }
        catch (ClassNotFoundException | SQLException e){
            System.out.println("Error" + e.getMessage());
        }
        return cnn;
    }
    
    Statement createStatement(){
        throw new UnsupportedOperationException("No soporta la conexión a la base de datos");
    }
    
    public ResultSet validarAcceso(String usuario, String contra ) throws SQLException {
        consultaSql="call tspValidarAcceso('"+ usuario + "','"+ contra + "');";
        //Establecer ejecución de comando
        st= (Statement) cnn.createStatement();
        //Ejeuta comando
        rs= st.executeQuery(consultaSql);
        return rs;
    }
    
    
}
