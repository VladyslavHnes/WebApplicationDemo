<%@page contentType="text/html" pageEncoding="UTF-8" language="java" isELIgnored="false" session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Subscribe page</title>
    <style type="text/css">
        TABLE {
            width: 300px; /* Ширина таблицы */
            border-collapse: collapse; /* Убираем двойные линии между ячейками */
            margin: auto;
        }
        TD, TH {
            padding: 3px; /* Поля вокруг содержимого таблицы */
            border: 1px solid black; /* Параметры рамки */
            text-align: center;
        }
        TH {
            background: #b0e0e6; /* Цвет фона */
        }
    </style>
    <style>
        .text {
            text-align:  center;
        }
        .submit{
            text-align:  center;
        }
    </style>
</head>
<body>
<div class="text">
    <p>Welcome to our University, ${student.firstName}!
        <br/><br/>Please, choose your courses. <br> Type "+" at the fields of admired courses</p>
</div>
<br><br><br>
<form action="subscribe" method="post">
    <table>
        <tr>
            <th>Enroll</th>
            <th>Course</th>
            <th>Instructor</th>
        </tr>
        <c:forEach items="${courses}" var="course" varStatus="count">
            <tr>
                <td><input type="text" name="${course.nameOfCourse}"  style="text-align:center; vertical-align:middle;"></td>
                <td>${course.nameOfCourse}</td>
                <td>${course.teacherLastName}</td>
            </tr>
        </c:forEach>
    </table>
    <center><input type="submit" name="subs" value="start"></center>
</form>
</body>
</html>