<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="beans.TableRow" %>
<jsp:useBean id="results" class="beans.MyBean" scope="session"/>
<html>

<head>
    <title>Лабораторная работа №1 по Веб-программированию</title>
    <meta charset="UTF-8" >
    <link rel = "stylesheet" href ="styles.css">
</head>
<body>
<table border="1" cellpadding="0" cellspacing="0" width="100%" class="page_table">
    <tr class="shapka">
        <th colspan=2> Кузнеченков Алексей Сергеевич, Р3212, вариант 3164 </th>
    </tr>
    <tr>
        <th width = 25%>
            <div id = "graphic_container">
                <canvas width="320px" height="320px" id="graphic"></canvas>
            </div>
        </th>
        <th width = 75%>
            <form method="get" action="controller" name="sendForm" class="send_form">
                <labl>Выберите значение <varb>Х</varb></labl>: <br>
                <input type="radio" id="x-4" value="-4" name="x" class="X_group"> -4
                <input type="radio" id="x-3" value="-3" name="x" class="X_group"> -3
                <input type="radio" id="x-2" value="-2" name="x" class="X_group"> -2
                <input type="radio" id="x-1" value="-1" name="x" class="X_group"> -1
                <input type="radio" id="x0" value="0" name="x" class="X_group" checked> 0
                <input type="radio" id="x1" value="1" name="x" class="X_group"> 1
                <input type="radio" id="x2" value="2" name="x" class="X_group"> 2
                <input type="radio" id="x3" value="3" name="x" class="X_group"> 3
                <input type="radio" id="x4" value="4" name="x" class="X_group"> 4 <br>
                <labl>Выберите значение <varb>Y</varb></labl> (от -3 до 3): <br>
                <input type="text", name="y" id="y" maxlength="8"> <br>
                <labl>Выберите значение <varb>R</varb></labl>: <br>
                <select id="r" name="r">
                    <option value="1">1</option>
                    <option value="1.5">1.5</option>
                    <option value="2" selected>2</option>
                    <option value="2.5">2.5</option>
                    <option value="3">3</option>
                </select>> <br>
                <button value="Отправить" id="submitButton" class="submitButton"/>
            </form>
            <br>

        </th>
    </tr> </table>
<tr>
    <th colspan="1" width =  100%>
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
                    <th class="y_col">${result.y}</th>
                    <th class="r_col">${result.r} </th>
                    <th> ${result.startTime}</th>
                    <th> ${result.workTime} </th>
                    <th> ${result.result} </th>
                </tr>
            </c:forEach>
        </table></th>
</tr>
</table>
<script src="script.js"></script>
<script src="canvas_area.js"></script>
</body>