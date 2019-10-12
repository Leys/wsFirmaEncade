<%-- 
    Document   : jspInicio
    Created on : 7/10/2019, 06:41:32 PM
    Author     : Adaleysi
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    //Cambiar la referencia de las páginas a : document.location.href='?op=jspPrincipal.jsp';
    
    //este código permitirá que se obtenga el nombre de 
    //la página a mostrar 
    //en el cuerpo de esta página
    String pagina="jspAcceso.jsp";
    //request.getParamer --> obtiene el valor enviado de 
    //alguna página
    if(request.getParameter("op")!=null)
    {
        pagina=request.getParameter("op").toString();
    }
    System.out.println(pagina);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        
        <title>Firma encadenada </title>
        <!--<link rel="stylesheet" href="css/bootstrap.min.css">-->
        <link rel="stylesheet" href="css/unicons.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <link rel="stylesheet" href="css/styles.css">
        <link rel="stylesheet" href="css/bootstrap-grid.min.css">
        <!-- MAIN STYLE -->
        <link rel="stylesheet" href="css/tooplate-style.css">
        <style type="text/css">
            <%@include file="css/unicons.css"%>                    
            <%@include file="css/owl.carousel.min.css"%>                    
            <%@include file="css/owl.theme.default.min.css"%>
        </style>
        <style type="text/css">
            .auto-style1 {
                display: block;
                width: 101%;
                height: calc(1.5em + .75rem + 2px);
                font-size: 1rem;
                font-weight: 400;
                line-height: 1.5;
                color: #495057;
                background-clip: padding-box;
                border-radius: .25rem;
                transition: none;
                border: 1px solid #ced4da;
                background-color: #fff;
            }
            .auto-style2 {
                display: block;
                width: 101%;
                height: calc(1.5em + .75rem + 2px);
                font-size: 1rem;
                font-weight: 400;
                line-height: 1.5;
                color: #495057;
                background-clip: padding-box;
                border-radius: .25rem;
                transition: none;
                border: 1px solid #ced4da;
                background-color: #fff;
            }
            .auto-style3 {
                left: 0px;
                top: 0px;
                width: 279px;
            }
            .auto-style4 {
                left: 1px;
                top: 0px;
            }
            #miid::placeholder {
              color: gray;
              text-align: center;
              padding-top: 30px;
            }
        </style>
        
        
    </head>
    <body>
        <!-- MENU -->
        <nav class="navbar navbar-expand-sm navbar-light">
        <div class="container">
            <a >
		<img src="images/LoFirma.png" alt="Firma Encadenada" id="logo" data-height-percentage="10" height="50"   />
            </a>
           <!-- <a class="navbar-brand" href="index.html"><i class='uil uil-user'></i> Vendedor</a> -->

           <div class="collapse navbar-collapse" id="navbarNav" >
                <ul class="navbar-nav mx-auto">
                    <li class="nav-item"  >
                        <a href="?op=jspPrincipal.jsp" class="nav-link"><span data-hover="Home">Home</span></a>
                        
                    </li>


                    <li class="nav-item">
                        <a href="?op=jspVerificarC.jsp" class="nav-link"><span data-hover="Verificar">Verificar</span></a>
                        <ul>
                          <li><a href="#">Envío</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a href="?op=jspHistorial.jsp" class="nav-link"><span data-hover="Historial">Historial</span></a>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link"><span data-hover="CerrarSesion">Mi cuenta</span></a>
                        <ul>
                            <li><a href="?op=jspFirmaMen.jsp">Firmar</a></li>
                            <li><a href="?op=jspHistorial.jsp">Mi historial</a></li>
                            <li><a href="?op=jspUsuarios.jsp">Mi cuenta</a></li>
                            <li><a href="?op=jspCerrarSes.jsp">Cerrar sesión</a></li>
                            
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        </nav>
        

        
        <jsp:include page="<%=pagina%>"/>
        
        
        <!-- FOOTER -->
        <footer class="footer py-5">
             <div class="container">
                <div class="row">
                     <div class="col-lg-12 col-12">
                        <p class="copyright-text text-center">Copyright &copy; FirmaEncadenada</p>
                     </div>
                 </div>
            </div>
        </footer>
   
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/Headroom.js"></script>
        <script src="js/jQuery.headroom.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/smoothscroll.js"></script>
        <script src="js/custom.js"></script>
        
        
        
    </body>
</html>
