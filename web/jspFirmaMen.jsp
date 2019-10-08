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
            <form action="" align="center" class="firmar form-inline">
                <div class="col-6 form-control" align="center">
                    <div class="label">Selecciona la semilla</div>
                    
                    <input type="file" name="seed" id="seed" class="form-control">
                </div>
                <div class="col-5 form-control " align="center">
                    <div class="label">Selecciona el archivo</div>
                    
                    <input type="file" name="seed" id="seed" class="form-control">
                </div>
                
                <div class="custom-btn-group mt-4" align="center">
                    <input  type="button" href="" class="btn custom-btn custom-btn-bg custom-btn-link"name="btn_Descargar"value="Descargar Firma"id="btn_Descargar" style="width: 172px; display: inline-block;" >
                    <input  type="submit" href="" class="btn custom-btn custom-btn-bg custom-btn-link"name="btn_Firmar"value="Firmar"id="btn_Firmar" style="width: 172px" >
                </div>                 
            </form>
            
            <div align="center">
                <div class="col-8 center-block mt-4" align="center">
                    <div id="details" style="display: none;">
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum
                    </div>
                    <div>
                        <a id="m-o-det" onclick="details()">Ver detalles</a>
                    </div>
                </div> 
            </div>
        </div>
    </div>
</section>

<script languaje="javascript">
    function details(){
        
        if(document.getElementById("details").style.display==="none"){
            document.getElementById("details").style.display="block";
            document.getElementById("m-o-det").innerHTML="Ocultar detalles";
        }
        else{
            document.getElementById("details").style.display="none";
            document.getElementById("m-o-det").innerHTML="Ver detalles";
        }
    }
    
</script>
