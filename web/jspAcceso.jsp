<%-- 
    Document   : jspAcceso
    Created on : 6/10/2019, 06:38:28 PM
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
                        <span class="mr-2" > Acceso al sistema</span>
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
                          <input type="text" class="auto-style1" name="txtUsuario" id="miid" placeholder="Nombre Usuario" id="txtUsuario"  width="20"size="40">
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
                          <input type="password" class="auto-style2" name="txtContra" id="miid" placeholder="Contraseña" id="txtContra"  width="20"size="40">
                  </td>
                </tr>
                <br>
                <tr>
                  <td>
                  </td>
                  <td >
                    <form action=""align="center">
                      <div class="custom-btn-group mt-4" align="center">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input  type="submit" href="#contact" class="btn custom-btn custom-btn-bg custom-btn-link"name="btnEntrar"value="Acceder"id="btnEntrar" style="width: 172px"onclick="acceso();" >
                      </div>
                        <div>
                            <br>
                        &nbsp;&nbsp;
                        </div>
                        <br>
                        &nbsp;&nbsp;
                        <div class="auto-style4"align="center">
                            ¿No tienes cuenta? <a href="?op=jspRegistroUsuario.jsp"> Regístrate aquí </a>
                            <!--document.location.href="jspRegistroUsuario.jsp";-->
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
        
       
   
    
    

<script language="javascript">
    function acceso()
    {
        //obtiene el valor de caja de textos
        var usuario=document.getElementById("txtUsuario").value;
        var contra=document.getElementById("txtContra").value;
        
        if(usuario!==null&& contra!==null && usuario!==""&& contra!=="")
        {
            document.location.href="?op=jspAcceso.jsp&usu="+usuario+"&cont="+contra;
        }
        else
        {
            alert("Inserte datos a los campos");
        }
    }
</script>
