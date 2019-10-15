/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;

import org.apache.commons.io.IOUtils;

/**
 *
 * @author diego
 */

@MultipartConfig(location="/tmp", fileSizeThreshold=1024*1024,maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
   
public class multipartProcessor extends HttpServlet {

    
    
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
            throws ServletException, IOException, Exception {

        String uploadPath = getServletContext().getRealPath("") + File.separator + "tmp";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        
        
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);


        List items = upload.parseRequest(request);

        for (Object item : items) {
            FileItem uploaded = (FileItem) item;
            if (!uploaded.isFormField()) {
                leerArchivo(uploaded);
                System.out.println("File");
            } else {
                String key = uploaded.getFieldName();
                String valor = uploaded.getString();
                System.out.print("No file= ");
                System.out.println(key + ":" + valor);

            }

        }

        //http://chuwiki.chuidiang.org/index.php?title=File_upload_con_JSP
    }
    
    private String leerArchivo(FileItem flu){
        String texto="";
        try {
            InputStream is=flu.getInputStream();
            int r;
            do{
                r=is.read();
                texto+=(char)r;
            }while(r!=-1);
            System.out.println("leido: "+texto);
        } catch (IOException ex) {
            Logger.getLogger(multipartProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return texto;
    }
        
    private void firmar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //request.getPart("flu");
        System.out.println("Firmar");
        
        request.getRequestDispatcher("jspInicio.jsp").forward(request, response);
        
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
        } catch (Exception ex) {
            Logger.getLogger(multipartProcessor.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (Exception ex) {
            Logger.getLogger(multipartProcessor.class.getName()).log(Level.SEVERE, null, ex);
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
