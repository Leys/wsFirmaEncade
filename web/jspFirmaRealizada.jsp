<%-- 
    Document   : jspFirmaRealizada.jsp
    Created on : 31/10/2019, 11:21:39 AM
    Author     : diego
--%>

<section>
    <div class="succes">
        <div class="container">
            <div class="row" align="center">
                <h1 style="margin: 20px auto;">Firma agregada</h1>
            </div>
        </div>
    </div>
    
    <div class="container mt-4">
        <div class="row">
            <div style="margin: auto;">
                
            <a href="jspDownloadF.jsp" class="btn custom-btn custom-btn-bg custom-btn-link">Descargar firma</a>
            <a href="index.jsp?op=jspFirmaMen.jsp" class="btn custom-btn custom-btn-bg custom-btn-link">Regresar</a>
            
            </div>
        </div>
        <div class="row mt-3">
        <div class="col-8" style="margin: auto;">
            <textarea style="width: 100%; resize: vertical; height: 350px;" readonly="readonly">
                <%
                if (request.getAttribute("res") != null) {
            %>
            <%=request.getAttribute("res")%>
            <%
                }
            %>
            </textarea>
        </div>
            
        </div>
    </div>
</section>
