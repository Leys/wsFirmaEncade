/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clases.clsFirma;
import clases.clsUsuario;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author diego
 */
@MultipartConfig(location = "/tmp", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)

public class multipart extends HttpServlet {

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
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            List items = upload.parseRequest(request);
            String op = "";
            for (Object item : items) {
                FileItem uploaded = (FileItem) item;
                if (uploaded.isFormField()) {
                    if (!"org".equals(uploaded.getFieldName())) {
                        op = uploaded.getString();
                    }
                }
            }

            switch (op) {
                case "Firmar":
                    firmar(request, items);
                    request.setAttribute("op", "jspFirmaMen.jsp");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;

                default:
                    break;

            }
        } catch (FileUploadException | SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private void firmar(HttpServletRequest request, List items)
            throws ServletException, IOException, FileUploadException, SQLException {
        
        String token=null;
        byte[] archivo=null;
        
        for (Object item : items) {
            FileItem uploaded = (FileItem) item;
            if (!uploaded.isFormField()) {
               if(uploaded.getFieldName().equals("fluToken")){
                  token=leerArchivo(uploaded);
                  token=token.substring(0, token.length()-1);
               }
               else if(uploaded.getFieldName().equals("fluArchivo")){
                    archivo=uploaded.get();
               }
            }
        }
        
        if(token!=null && archivo!=null){
           
           clsFirma firmar=new clsFirma();
           
           //asignar ultima semilla
           firmar.setUltSeedHex(token.split("\n")[0],token.split("\n")[0]);
           
           //Asignar H
           clsUsuario user=(clsUsuario)request.getSession().getAttribute("usuario");
         
           user.conexion();
           String[] ultHAux=user.getUltH().split(",");
           int ultH[]=new int[ultHAux.length];
           for(int i=0;i<ultHAux.length;i++){
               ultH[i]=Integer.parseInt(ultHAux[1]);
           }
           firmar.setUltH(ultH);
           
           
           //firmar
           firmar.Firmar(archivo);
               
           
           System.out.println("Done");
        }
        else{
            request.setAttribute("det", "Error con los archivos");
        }
        
    }

    private String leerArchivo(FileItem flu) {
        String texto = "";
        try {
            InputStream is = flu.getInputStream();
            int r;
            do {
                r = is.read();
                texto += (char) r;
            } while (r != -1);
        } catch (IOException ex){
            System.out.println("Error: " + ex.getMessage());
        }
        return texto;
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
