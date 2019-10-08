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




<% //codigo java
    //copia de la clase
    clsDatos con = new clsDatos();
    //establece conexion a bd
    Connection cnn=con.conexion();
    //va recibir los resultados de la consulta
    ResultSet rsFrm;
    //recibir los datos de las cajas de texto
    String usuario=request.getParameter("usu");
    String contra=request.getParameter("cont");
    
    //variable para dar menaje de bienvenida
    String cad="", usu="", mensaje="",nombre="";
    //valida que las cajas de texto tengan datos
    if(usuario!=null&& contra!=null&& usuario!=""&& contra!="")
    {
        try
        {
            //ejecutamos el método de la clase
            rsFrm=con.validarAcceso(usuario, contra);
            //se recorren los resultados obtenidos en bd
            while(rsFrm.next()){
                //se obtiene el primer campo de la consulta
                usu=rsFrm.getString(1);
                if(!usu.equals("0")){
                    nombre=rsFrm.getString(2);
                    //cad= rsFrm.getString(3);
                }
            }
            //se cierra la conexión
            rsFrm.close();
            //verificmos si permite el acceso o no...
            if(usu.equals("0"))
            {
                out.println("<script language='javascript'>alert('Acceso Denegado al sistema');document.location.href='?op=jspAcceso.jsp'; </script>");
            }
            else 
            {
                mensaje= "Bienvenido "+usuario +"";
               out.println("<script language='javascript'>alert(' "+mensaje+"  ');document.location.href='jspPrincipal.jsp'; </script>");

            }


        }catch(Exception ex){
            out.println("<script language='javascript'>alert('"+ex.toString() +"');</script>");

        }
    }
    else{
                usuario="";
                contra="";

    }
%>


   
       
        
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
                          <input type="text" class="auto-style1" name="txtUsuario" id="miid" placeholder="Nombre Usuario" id="txtUsuario" value="<%=usuario%>" width="20"size="40">
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
                          <input type="password" class="auto-style2" name="txtContra" id="miid" placeholder="Contraseña" id="txtContra" value="<%=contra%>" width="20"size="40">
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
