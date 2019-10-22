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
            <form action="procesador1.do" method="post" id="frmDatosU" name="frmDatosU"> 
            <table >
                
                <!-- agregar foto PENDIENTE  -->
                <tr>
                    <td>
                        <div class="auto-style4" align="center">
                            <img src="images/iconuser.jpg" class="small" width="200px" height="185px"   id="image" alt="image">
                            <!--<input type="image" class="auto-style2" name="image" id="image" width="40" size="40">-->
                        </div>
                    </td>
                    
                </tr>
                
                <tr>
                  <td>
                    <div class="small" align="right">
                        <h4>&nbsp;&nbsp; Usuario</h4>
                  </td>
                  <td>
                        <div class="auto-style4" align="center">
                          <input type="text" class="auto-style1" name="txtUsuario" id="miid" placeholder="Usuario" id="txtUsuario" width="20"size="40">
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
                        <div class="auto-style4" align="center">
                          <input type="text" class="auto-style1" name="txtNombre" id="miid" placeholder="Nombre" id="txtNombre" width="20"size="40">
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
                        <div class="auto-style4" align="center">
                          <input type="text" class="auto-style1" name="txtApp" id="miid" placeholder="Apellido" id="txtApp" width="20"size="40">
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
                        <div class="auto-style4" align="center">
                          <input type="text" class="auto-style1" name="txtApm" id="miid" placeholder="Apellido" id="txtApm" width="20"size="40">
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
                        <div class="auto-style4"align="center">
                          <input type="password" class="auto-style2" name="txtContra" id="miid" placeholder="Contraseña" id="txtContra" width="20"size="40">
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
                        <div class="auto-style4"align="center">
                          <input type="password" class="auto-style2" name="txtCContra" id="miid" placeholder="Contraseña" id="txtCContra" width="20"size="40">
                  </td>
                </tr>
                
                
                <!--Agregar más cajas de texto -->
                
                
                <br>
                <tr>
                  <td>
                  </td>
                  <td >
                      <div class="custom-btn-group mt-4" align="center">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input  type="submit" href="#contact" class="btn custom-btn custom-btn-bg custom-btn-link"name="btnRegistrar"value="Registrar"id="btnRegistrar" style="width: 172px" >
                      </div>
                        
                        <div>
                            <br>
                        &nbsp;&nbsp;
                        </div> 
                        <div>
                          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="?op=jspAcceso.jsp"> Iniciar Sesión </a>
                        </div>   
                        
                      
                  </td>
                  <td>
                  </td>
                </tr>
                
                </table>
            </form>
        </center>
        <br>
        </div>
        </section>
        
    