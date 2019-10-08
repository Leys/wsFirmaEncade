<%-- 
    Document   : jspRegistroUsuario
    Created on : 6/10/2019, 07:37:24 PM
    Author     : Adaleysi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.Connection" %>
<%@page import="clases.clsDatos" %>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>


        
        <!-- ABOUT -->

        <div class="container">

            <div class="about-text align-items-center">
                <center>
                <br><br>
                    <h3>
                        <span class="mr-2" > Registro de usuario</span>
                    </h3>
                <br>
                </center>

            </div>
        </div>
        
        </section>
        
        
        <!-- CONTENIDO -->
        <section>
        <center>
            <table >
                <tr>
                  <td>
                    <div class="small" align="right">
                        <h4>&nbsp;&nbsp; Usuario</h4>
                  </td>
                  <td>
                    <form action="" method="get" align="right">
                        <div class="auto-style4" align="center">
                          <input type="text" class="auto-style1" name="txt_Usuario" id="miid" placeholder="Usuario" id="txt_Usuario" width="20"size="40">
                  </td>
                </tr>
                
                <tr>
                  <td>
                      <br>
                        &nbsp;&nbsp;
                    <div class="small" align="right">
                        <h4>&nbsp;&nbsp; Nombre</h4>
                  </td>
                  <td>
                    <form action="" method="get" align="right">
                        <div class="auto-style4" align="center">
                          <input type="text" class="auto-style1" name="txt_Nombre" id="miid" placeholder="Nombre" id="txt_Nombre" width="20"size="40">
                  </td>
                </tr>
                
                <tr>
                  <td>
                      <br>
                        &nbsp;&nbsp;
                    <div class="small" align="right">
                        <h4>&nbsp;&nbsp; Apellido Paterno</h4>
                  </td>
                  <td>
                    <form action="" method="get" align="right">
                        <div class="auto-style4" align="center">
                          <input type="text" class="auto-style1" name="txt_ApPat" id="miid" placeholder="Apellido" id="txt_ApPat" width="20"size="40">
                  </td>
                </tr>
                
                <tr>
                  <td>
                      <br>
                        &nbsp;&nbsp;
                    <div class="small" align="right">
                        <h4>&nbsp;&nbsp; Apellido Materno</h4>
                  </td>
                  <td>
                    <form action="" method="get" align="right">
                        <div class="auto-style4" align="center">
                          <input type="text" class="auto-style1" name="txt_ApMat" id="miid" placeholder="Apellido" id="txt_ApMat" width="20"size="40">
                  </td>
                </tr>
                
                <tr>
                  <td>
                      <br>
                        &nbsp;&nbsp;
                    <div class="small" align="right">
                        <h4 >&nbsp;&nbsp;Contraseña</h4>
                  </td>
                  <td>
                      <br>
                      <form action="" method="get">
                        <div class="auto-style4"align="center">
                          <input type="password" class="auto-style2" name="txt_Contra" id="miid" placeholder="Contraseña" id="txt_Contra" width="20"size="40">
                  </td>
                </tr>
                
                <tr>
                  <td>
                      <br>
                        &nbsp;&nbsp;
                    <div class="small" align="right">
                        <h4 >&nbsp;&nbsp;Confirmar contraseña</h4>
                  </td>
                  <td>
                      <br>
                      <form action="" method="get">
                        <div class="auto-style4"align="center">
                          <input type="password" class="auto-style2" name="txt_CContra" id="miid" placeholder="Contraseña" id="txt_CContra" width="20"size="40">
                  </td>
                </tr>
                
                
                <!--Agregar más cajas de texto -->
                
                
                <br>
                <tr>
                  <td>
                  </td>
                  <td >
                    <form action=""align="center">
                      <div class="custom-btn-group mt-4" align="center">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input  type="submit" href="#contact" class="btn custom-btn custom-btn-bg custom-btn-link"name="btn_Registrar"value="Registrar"id="btn_Registrar" style="width: 172px" >
                      </div>
                        
                        <div>
                            <br>
                        &nbsp;&nbsp;
                        </div> 
                        <div>
                          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="jspAcceso.jsp"> Iniciar Sesión </a>
                        </div>   
                        
                      
                  </td>
                  <td>
                  </td>
                </tr>
                
                </table>
        </center>
        <br>
        </div>
        </section>
        
    