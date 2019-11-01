/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clases.clsDatos;
import clases.clsUsuario;
import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Adaleysi
 */
public class procesador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        String usuario=request.getParameter("txtUsuario");
        String pwd=request.getParameter("txtContra");
        System.out.println(usuario+":"+pwd);
        if(!usuario.equals("")&& !pwd.equals("")) {
                
                //int clave,String usuario, String pas, String nombre,int estatus, String foto
                    clsDatos usu = new clsDatos(0,usuario, pwd,"",0,"");

                    Connection cnn=usu.conexion();
                    clsUsuario user=new clsUsuario();
                    
                    ResultSet rsFrm;
                    rsFrm =usu.validarAcceso();
                    while(rsFrm.next())
                    {
                        user.setId(Integer.parseInt(rsFrm.getString(1)));
                        usu.setCve(Integer.parseInt(rsFrm.getString(1)));
                        if(usu.getCve()!=0)
                        {
                            user.setNombre(rsFrm.getString(2));
                            usu.setNombre(rsFrm.getString(2));

                            user.setEstatus(Integer.parseInt(rsFrm.getString(3)));
                            usu.setEstatus(Integer.parseInt(rsFrm.getString(3)));
                        }
                    }

                    //se cierra la conexin
                    rsFrm.close();

                    if(usu.getCve()!=0)
                    {
                       //se genera una sesion con los datos del modelo
                        request.getSession().setAttribute("usuario1", usu);
                        request.getSession().setAttribute("usuario", user);
                        
                        
                        clsUsuario aux=(clsUsuario)request.getSession().getAttribute("usuario");
                        request.setAttribute("op", "jspPrincipal.jsp");
                        request.getRequestDispatcher("index.jsp").forward(request, response); 
                    }
                    else{
                        request.setAttribute("es", "Datos incorrectos");
                        request.setAttribute("op", "jspAcceso.jsp");
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }

            }
            else
            {
                request.setAttribute("es", "Campos vacios");
                        request.setAttribute("op", "jspAcceso.jsp");
                        request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(procesador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(procesador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
