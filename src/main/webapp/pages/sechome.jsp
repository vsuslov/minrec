<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Секретарь</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script type="text/javascript" src="../js/prototype.js"></script>
        <script type="text/javascript" src="../js/app.js"></script>
           
    </head>
    <body onload="app.loadTable()">
        
        <%@include file="../components/listApplicants.jspf" %>
        <input type="button" onclick="app.setStatus('Исполнено')" value="Исполнено"/>
        <br><br>
        <form id="addApp" action="/minrec/add" method="post">
            <label for="name">ФИО:</label>
            <input type="text" name="name" id="name"/><br>
            <label for="comment">Комментарий(опционально):</label>
            <input type="text" name="comment" id="comment"/><br>    
            <input type="button" id="addButton" onclick="app.save()" value="Добавить"/>
        </form>
    </body>
    
</html>
