<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    
    if (request.getSession().getAttribute("semilla") != null) {

        String semilla = request.getSession().getAttribute("semilla").toString();
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=token.key");
        //response.setHeader("Expires", "0");//Se elimina del browser

        OutputStream ouputStream = response.getOutputStream();
        ouputStream.write(semilla.getBytes());
        ouputStream.flush();
        ouputStream.close();
        
    }

%>