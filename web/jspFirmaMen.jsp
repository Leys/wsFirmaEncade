<%-- 
    Document   : jspFirmaMen
    Created on : 6/10/2019, 10:35:30 PM
    Author     : Adaleysi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!-- ABOUT -->

<!-- CONTENIDO -->
<section class="container">
    <div class="offset-3">
        <div align="center">
            <h2>
                Firma del mensaje
            </h2>
            <div id="error">
                
            <%
                if (request.getAttribute("res") != null) {
            %>
            <%=request.getAttribute("res")%>
            <%
                }
            %>
            
            </div>
        </div>
    </div>
    <div class="Instrucciones col-3">
        <ul>
            <ol>
                <h3>
                    Instrucciones:
                </h3>
            </ol>
            <li value="1">
                Suba sus archivos
            </li>
            <li>
                Suba sus semillas
            </li>
            <li>
                Descargue la firma
            </li>
            <li>
                Comparta la firma junto su archivo
            </li>
        </ul>

    </div>


    <div class="row">
        <div class="col-12">
            <form action="multipart.do" align="center" class="firmar form-inline" enctype="multipart/form-data" method="post">
                <input  type="hidden" href="" class="btn custom-btn custom-btn-bg custom-btn-link" name="org" value="firmar" id="org">

                <div class="col-12 form-control" align="center" id="Token">
                    <div class="label">Selecciona la semilla</div>
                    <input type="file" name="fluToken" id="fluToken" class="form-control" accept=".key" onchange="tokenSelected();">
                    <br>
                    <input type="button" name="btnToken" id="btn_Regresar" value="Regresar" class="btn custom-btn custom-btn-bg custom-btn-link">
                    <input  type="submit" href="" class="btn custom-btn custom-btn-bg custom-btn-link" name="btn_Firmar" value="Firmar" id="btn_Firmar" style="width: 172px; display: none;" >

                </div>


                <div class="col-12 form-control" align="center" id="Archivo">
                    <div class="col-12 form-control " align="center" >
                        <div class="label">Selecciona el archivo</div>
                        <input type="file" name="fluArchivo" id="fluArchivo" class="form-control" onchange="fileSlected();">
                        <br>
                    </div>

                    <div class="custom-btn-group mt-4" align="center">
                        <input  type="button" href="" class="btn custom-btn custom-btn-bg custom-btn-link" name="btn_Regresar" value="Continuar" id="btn_Continuar" style="width: 172px" >
                    </div>
                </div>                 
            </form>

        </div>
    </div>
</section>

<script languaje="javascript">

    document.getElementById("btn_Continuar").addEventListener("click", function () {
        if (document.getElementById("fluArchivo").value.length === 0) {
            document.getElementById("error").innerHTML = "Introducir un archivo";
        } else {
            document.getElementById("error").innerHTML = "";
            document.getElementById("Archivo").style.display = "none";
            document.getElementById("Token").style.display = "block";
        }
    });

    document.getElementById("btn_Regresar").addEventListener("click", function () {
        document.getElementById("Archivo").style.display = "block";
        document.getElementById("Token").style.display = "none";
    });

    function fileSlected() {
        document.getElementById("error").innerHTML = "";
        document.getElementById("Archivo").style.display = "none";
        document.getElementById("Token").style.display = "block";
    }

    function tokenSelected() {
        document.getElementById("btn_Firmar").style.display = "inline-block";
    }

</script>
