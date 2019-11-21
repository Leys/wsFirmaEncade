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
public class clsUsuario extends clsConexion {

    private int Id;
    private String Nombre;
    private String Usuario;
    private String Pas;
    private String Foto;
    private int Estatus;
    private Date Fecha;

    String uh;
    String link;
    String llave;
    String ultFirma;

    public String getUh() {
        return uh;
    }

    public String getLink() {
        return link;
    }

    public String getLlave() {
        return llave;
    }

    public String getUltFirma() {
        return ultFirma;
    }

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
        consultaSql = "call tspRegistrarUsuarioI('" + nombre + "','" + usuario + "','" + contra + "','" + foto + "','" + h + "','" + firma + "');";
        st = (Statement) cnn.createStatement();
        rs = st.executeQuery(consultaSql);
        String res = "";
        while (rs.next()) {
            res = rs.getString(1);
        }
        rs.close();
        return res;
    }

    public String getUltH() throws SQLException {
        String consultaSql;
        ResultSet rs;
        consultaSql = "call tspObtenerUltH(" + this.Id + ");";
        st = (Statement) cnn.createStatement();
        rs = st.executeQuery(consultaSql);
        String res = "";
        while (rs.next()) {
            res = rs.getString(1);
        }
        rs.close();
        return res;
    }
    
    public String firmar(String link, String firma, String llave, String h) throws SQLException {
        String consultaSql;
        ResultSet rs;
        consultaSql="call tspFirmarNuevoMensaje("+this.Id+", '"+llave+"', '"+firma+"', '"+h+"', '"+link+"');";
        st= (Statement) cnn.createStatement();
        rs= st.executeQuery(consultaSql);
        String res="";
        while(rs.next()){
            res=rs.getString(1);
        }
        rs.close();
        return res;
    }

    public String getVFirma() throws SQLException {

        String consultaSql;
        ResultSet rs;
        consultaSql = "call tspVFirma(" + this.Id + ");";
        st = (Statement) cnn.createStatement();
        rs = st.executeQuery(consultaSql);
        String res = "";
        while (rs.next()) {
            res = rs.getString(1);
            if (!"0".equals(res)) {
                uh = rs.getString(1);
                link = rs.getString(2);
                llave = rs.getString(3);
                ultFirma = rs.getString(4);
            }
        }
        rs.close();
        return res;
    }

    public String buscarUsuario(String f) throws SQLException {
        String consultaSql;
        ResultSet rs;
        consultaSql = "call tspBuscarUsuario('" + f + "');";
        st = (Statement) cnn.createStatement();
        rs = st.executeQuery(consultaSql);
        String res = "";
        while (rs.next()) {
            res = rs.getString(1);
            if (!"0".equals(res)) {
                this.Id = Integer.parseInt(res);
                this.Nombre = rs.getString(2);
                this.Usuario = rs.getString(3);
            }
        }
        rs.close();
        return res;
    }

}
