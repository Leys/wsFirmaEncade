
<%@page import="java.io.OutputStream"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
System.out.println("Here");
    if (request.getSession().getAttribute("firma") != null) {

        String firma = request.getSession().getAttribute("firma").toString();
                System.out.println(firma);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=firma.key");
        //response.setHeader("Expires", "0");//Se elimina del browser

        OutputStream ouputStream = response.getOutputStream();
        ouputStream.write(firma.getBytes());
        ouputStream.flush();
        ouputStream.close();
        
    }
%>