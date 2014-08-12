<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Секретарь</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script type="text/javascript" src="../js/prototype.js"></script>
        <script type="text/javascript" language="javascript">
    
    /**
 * Comment
 */


    function loadTable() {
//        alert("lolo");
        new Ajax.Request('/minrec/list', {
            method:'get',
            onSuccess:function(response) {
                var resp = response.responseText.evalJSON();
                var array = $A(resp.array);
//                array.each(function(e) {
//                    $('header').insert("<tr><th>"+e.time+"</th><th>"+e.name+"</th><th>"+e.comment+"</th><th>"+e.status+"</th>");
//                });
alert('lolo');
                for(i=0;i<array.length;i++) {
                    var e = array[i];
                   $('listApplicants').insert('after','<tr><td>'+e.time+'</td><td>'+e.name+'</td><td>'+e.comment+'</td><td>'+e.status+'</td>'); 
                }
//                $('listApplicants').innerHTML=array;
            },
            onComplete: function(response) {
                
            }
    });
}

        </script>
    </head>
    <body onload="loadTable()">
        <table id="listApplicants" border="3">
            <tr id="header"><th>Время</th><th>ФИО</th><th>Комментарий</th><th>Статус</th></tr>
         
        </table>
        <br>
        
        <form id="addApp" action="/minrec/add" method="post">
            <label for="name">ФИО:</label>
            <input type="text" name="name"/><br>
            <label for="comment">Комментарий(опционально):</label>
            <input type="text" name="comment"/><br>    
            <input type="submit" value="Добавить"/>
        </form>
    </body>
    
</html>
