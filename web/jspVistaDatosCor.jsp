<%-- 
    Document   : jspVistaDatosCor
    Created on : 11/10/2019, 08:33:20 PM
    Author     : Adaleysi
--%>

<%@page import="clases.clsDatos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    clsDatos usu=(clsDatos)request.getSession().getAttribute("usuario1");
%>
 <!-- ABOUT -->
 <!-- CONTENIDO -->
        <section>
            <center>
                <table >
                    <tr>
                        <td>
                        </td>
                        <td >
                            <form action=""align="center">
                                

                                <div>
                                    <br>
                                    &nbsp;&nbsp;
                                </div> 
                                <div>
                                    <h1>Datos aceptados</h1>
                                    <p> <%= usu.getNombre()%></p>
                                    <p> <%= usu.getUsu()%> </p>
                                    <br><br/>
                                    <h1></h1>
                                    <a href="?op=jspPrincipal.jsp">Ir a mi Perfil...</a>
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
       