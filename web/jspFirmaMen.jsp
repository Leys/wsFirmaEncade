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
                Suba sus semillas
            </li>
            <li>
                Suba sus archivos
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
                    <input type="button" name="btnToken" id="btnToken" value="Continuar" class="btn custom-btn custom-btn-bg custom-btn-link">
                </div>


                <div id="Archivo">
                    <div class="col-12 form-control " align="center" >
                        <div class="label">Selecciona el archivo</div>
                        <input type="file" name="fluArchivo" id="fluArchivo" class="form-control" onchange="fileSlected();">
                        <br>
                    </div>

                    <div class="custom-btn-group mt-4" align="center">
                        <input  type="button" href="" class="btn custom-btn custom-btn-bg custom-btn-link" name="btn_Regresar" value="Regresar" id="btn_Regresar" style="width: 172px" >
                        <input  type="submit" href="" class="btn custom-btn custom-btn-bg custom-btn-link" name="btn_Firmar" value="Firmar" id="btn_Firmar" style="width: 172px; display: none;" >
                    </div>
                </div>                 
            </form>

        </div>
    </div>
</section>

<script languaje="javascript">

    document.getElementById("btnToken").addEventListener("click", function () {
        if (document.getElementById("fluToken").value.length === 0) {
            document.getElementById("error").innerHTML = "Introducir un archivo";
        } else {
            document.getElementById("error").innerHTML = "";
            document.getElementById("Token").style.display = "none";
            document.getElementById("Archivo").style.display = "block";
        }
    });

    document.getElementById("btn_Regresar").addEventListener("click", function () {
        document.getElementById("Token").style.display = "block";
        document.getElementById("Archivo").style.display = "none";
    });

    function tokenSelected() {
            document.getElementById("error").innerHTML = "";
            document.getElementById("Token").style.display = "none";
            document.getElementById("Archivo").style.display = "block";
    }
    
    function fileSlected(){
            document.getElementById("btn_Firmar").style.display = "inline-block";
    }
    
</script>
