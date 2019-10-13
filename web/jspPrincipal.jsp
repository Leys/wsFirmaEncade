<%-- 
    Document   : jspPrincipal
    Created on : 6/10/2019, 08:58:06 PM
    Author     : Adaleysi
--%>

<%@page import="clases.clsDatos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    clsDatos usu=(clsDatos)request.getSession().getAttribute("usuario1");
%>

        
        <!-- ABOUT -->

        <div class="container">

            <div class="about-text align-items-center">
                <center>
                <br><br>
                    <h3>
                        <span class="mr-2" > Bienvenido al sistema </span>
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
                    <p> <%= usu.getNombre()%></p>
                    <p> <%= usu.getUsu()%> </p>
                    
                    Tenemos que aprender a soltar
                  
                    pero vergazos, para que sepan
                    que uno no es pendejp de nadie
                    
                </table>
            </center>
            <br>
            </div>
        </section>
        
       