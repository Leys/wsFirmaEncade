/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clases.clsFirma;
import clases.clsUsuario;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletOutputStream;

/**
 *
 * @author Adaleysi
 */
public class procesador1 extends HttpServlet {

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
            throws ServletException, IOException {

        try {
            String org = request.getParameter("org");
            switch (org) {
                case "regUsu":
                    registrarUsuario(request, response);
                    break;
                    
                default:
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(procesador1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void registrarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        
        double inicio=System.currentTimeMillis();
        
        clsFirma obj = new clsFirma();
        obj.iniciarNuevo();

        String usuario = request.getParameter("txtUsuario");
        String nombre = request.getParameter("txtNombre");
        String ap = request.getParameter("txtAp");
        String pwd = request.getParameter("txtContra");
        String confpwd = request.getParameter("txtCContra");
        String foto = "";
        String firma = "";
        String h = "";
        //decargar semillas, guardar llave publica y h
        
        firma=obj.getUltFirmaHex();
        
        for (int uh : obj.getUltH()){
            h += String.valueOf(uh) + ",";
        }
        h=h.substring(0, h.length()-1);
        
        clsUsuario us = new clsUsuario();
        us.conexion();
        String res = us.registrarUsuI(nombre, confpwd, usuario, foto, h, firma);
        
        if(res.equals("0")){
            request.setAttribute("edo", "El usuario ya existe");
        }
        else{
            String[] aux=obj.getUltSeedHex();
            String semilla=aux[0]+"\n"+aux[1];
            request.getSession().setAttribute("semilla", semilla);
            request.setAttribute("edo", "Exito, por favor almacene su token en un lugar seguro");
            request.setAttribute("ban", "1");
        }
        
        
        System.out.println("Tiempo registro: "+(System.currentTimeMillis()-inicio));
        
        request.setAttribute("op", "jspRegistroUsuario.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);

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
        processRequest(request, response);
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
        processRequest(request, response);
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
