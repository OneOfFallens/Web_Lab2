<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="beans.TableRow" %>
<%@ page import="java.util.List" %>
<%@ page import="beans.MyBean" %>
<jsp:useBean id="results" class="beans.MyBean" scope="session"/>
<html>
<head>
    <?xml version="1.0" encoding="UTF-8"?>
    <title>Ответ</title>
    <meta charset="UTF-8" >
    <link rel = "stylesheet" href ="styles.css">
</head>
<body>
<table align="center" id="result_table">
    <tr>
        <th width="15%">X</th>
        <th width="15%">Y</th>
        <th width="15%">R</th>
        <th width="15%">Время запуска</th>
        <th width="15%">Время работы</th>
        <th width="15%">Результат</th>
    </tr>
<c:forEach var="result" items="${results.tableRows}">
    <tr>
        <th class="x_col"> ${result.x} </th>
        <th class="y_col">${result.y} </th>
        <th class="r_col">${result.r} </th>
        <th> ${result.startTime}</th>
        <th> ${result.workTime} </th>
        <th> ${result.result} </th>
    </tr>
</c:forEach>
    </table> <br>
<button align="center" class="special_button" onclick="location.href='${pageContext.request.contextPath}/controller'">Вернуться на главную</button>
</body>
</html>
