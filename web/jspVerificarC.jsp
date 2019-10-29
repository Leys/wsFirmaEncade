<%-- 
    Document   : jspVerificarC
    Created on : 6/10/2019, 10:47:49 PM
    Author     : Adaleysi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

          <!-- CONTENIDO -->
          
        <section class="container">
        <div class="container">

    <div class="about-text align-items-center">
        <center>
            <br><br>
            <h3>
                <span class="mr-2" > Verificación de cadena</span>
            </h3>
            <br>
        </center>

            </div>
            <div class="Instrucciones col-3">
                <ul>
                    <ol>
                        <h3>
                            Instrucciones para verificación:
                        </h3>
                    </ol>
                    <li value="1">
                        Suba documento
                    </li>
                    <li>
                        suba firma
                    </li>
                    <li>
                        Consultar resultados
                    </li>
                </ul>

            </div>
            
            <div class="row">
                <div class="col-12">
                    <form action="" align="center" class="verificar form-inline">
                        <div class="col-6 form-control" align="center">
                            <div class="label">Subir archivo</div>

                            <input type="file" name="doc" id="doc" class="form-control">
                        </div>
                        <div class="col-6 form-control" align="center">
                            <div class="label">Subir firma</div>

                            <input type="file" name="firma" id="firma" class="form-control">
                        </div>
                        <div class="custom-btn-group mt-4" align="center">
                            <input  type="button" href="" class="btn custom-btn custom-btn-bg custom-btn-link"name="btnVerificar"value="Verificar"id="btnVerificar" style="width: 172px; display: inline-block;" >
                        </div>
                    </form>

                    <div align="center">
                        <div class="col-8 center-block mt-4" align="center">
                            <div id="details" style="display: none;">
                                Correcto / Incorrecto
                            </div>
                            <div>
                                <a id="m-o-det" onclick="details()">Ver detalles</a>
                            </div>
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
  