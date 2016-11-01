<%@page contentType="text/html" pageEncoding="UTF-8" language="java" isELIgnored="false" session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Subscribe page</title>
    <style type="text/css">
        TABLE {
            width: 300px;
            border-collapse: collapse;
            margin: auto;
        }
        TD, TH {
            padding: 3px;
            border: 1px solid black;
            text-align: center;
        }
        TH {
            background: #b0e0e6;
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
        <br/><br/>Please, choose your courses. <br> Set mark at the fields of admired courses</p>
</div>
<br><br>
<!--form action="subscribe" method="post"!-->
<table>
    <tr>
        <th>Enroll</th>
        <th>Course</th>
        <th>Teacher</th>
    </tr>
    <form action ="subscribe" method="get">
        <c:forEach items="${courses}" var="course" varStatus="count">
            <tr>
                <td>
                    <input type = "checkbox" name = "subscribeBox" value=${course.subject}
                    <c:if test="${course.subject}">checked="checked"</c:if>>${course.subject}&nbsp
                </td>
                <td>${course.subject}</td>
                <td>${course.firstNameOfTeacher} ${course.lastNameOfTeacher}</td>
            </tr>
        </c:forEach>
            <input type="submit" value="start">
    </form>
    <c:if test="${isFirst == false}">
        <script>
            alert('sos pisos');
        </script>
    </c:if>>
</table>
<!--/form!-->
<br><br>
</body>
</html>