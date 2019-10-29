/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import com.mysql.jdbc.Statement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author diego
 */
public class clsUsuario extends clsConexion{
    
    private int Id;
    private String Nombre;
    private String Usuario;
    private String Pas;
    private String Foto;
    private int Estatus;
    private Date Fecha;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPas() {
        return Pas;
    }

    public void setPas(String Pas) {
        this.Pas = Pas;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String Foto) {
        this.Foto = Foto;
    }

    public int getEstatus() {
        return Estatus;
    }

    public void setEstatus(int Estatus) {
        this.Estatus = Estatus;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public clsUsuario() {
    }
    
   public String registrarUsuI(String nombre, String contra, String usuario, String foto, String h, String firma) throws SQLException {
        String consultaSql;
        ResultSet rs;
        consultaSql="call tspRegistrarUsuarioI('"+ nombre + "','"+ usuario + "','"+ contra + "','"+ foto + "','"+ h + "','"+ firma + "');";
        st= (Statement) cnn.createStatement();
        rs= st.executeQuery(consultaSql);
        String res="";
        while(rs.next()){
            res=rs.getString(1);
        }
        rs.close();
        return res;
    }
    
}
