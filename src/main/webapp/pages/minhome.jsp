<%-- 
    Document   : minhome
    Created on : Aug 13, 2014, 10:26:51 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Министр</title>
        <script type="text/javascript" src="../js/prototype.js"></script>
        <script type="text/javascript" src="../js/app.js"></script>
            
    </head>
    <body onload="app.loadTable();">
        <%@include file="../components/listApplicants.jspf" %>
        <input type="button" onclick="app.setStatus('Пропустить')" value="Пропустить"/>
        <input type="button" onclick="app.setStatus('Отказать')" value="Отказать в приеме"/>
        <input type="button" onclick="app.setStatus('Перезвоню')" value="Перезвоню"/>
        <input type="button" onclick="app.setStatus('Перевести звонок')" value="Перевести звонок"/>
    </body>
</html>
