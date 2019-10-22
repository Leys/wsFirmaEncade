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
    private String foto;
    
    //crear el constructor de usuario
    //clic dercho-- insert code -- constructor
    
    

    public clsDatos(int clave,String usuario, String pas, String nombre,int estatus, String foto) {
        this.cve = clave;
        this.usu = usuario;
        this.pas = pas;
        this.nombre = nombre;
        this.estatus = estatus;
        this.foto = foto;
    }
  
     public clsDatos() {
        
    }

    public String getUsu() {
        return usu;
    }

    public void setUsu(String usu) {
        this.usu = usu;
    }

    public String getPas() {
        return pas;
    }

    public void setPas(String pas) {
        this.pas = pas;
    }

    public int getCve() {
        return cve;
    }

    public void setCve(int cve) {
        this.cve = cve;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
       
    
    //Cadena de conexión
    Connection cnn;
    //Equivalente al DataSet
    ResultSet rs;
    //variable para manejar las instrucciones
    String consultaSql="";
    //Equivalente al command
    Statement st;
    
    
    public Connection conexion() throws SQLException{
        try{
            //Se agrega el driver de conexión
            Class.forName("com.mysql.jdbc.Driver");
            
            cnn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/BD_HASH","root","3209");
            
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
    
    public ResultSet validarAcceso() throws SQLException {
        consultaSql="call tspValidarAcceso('"+ usu + "','"+ pas + "');";
        //Establecer ejecución de comando
        st= (Statement) cnn.createStatement();
        //Ejeuta comando
        rs= st.executeQuery(consultaSql);
        return rs;
    }
    
    public ResultSet registrarUsu(String nombre, String contra ) throws SQLException {
        consultaSql="call tspRegistrarUsuario('"+ nombre + "','"+ contra + "');";
        //Establecer ejecución de comando
        st= (Statement) cnn.createStatement();
        //Ejeuta comando
        rs= st.executeQuery(consultaSql);
        return rs;
    }
    
    
}
