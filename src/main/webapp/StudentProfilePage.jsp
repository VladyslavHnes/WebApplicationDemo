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
    <p>Welcome back, ${student.firstName}!
        <br/><br/>There is you can watch info about your marks.</p>
</div>
<br>
<form action ="subscribe" method="get">
    <table>
        <tr>
            <th>Course</th>
            <th>Teacher</th>
            <th>Mark</th>
        </tr>
        <c:forEach items="${courses}" var="course" varStatus="loop">
            <tr>
                <td>${course.subject}</td>
                <td>${course.firstNameOfTeacher} ${course.lastNameOfTeacher}</td>
                <td>${marks.get(loop.index)}</td>
            </tr>
        </c:forEach>
    </table>
</form>
<form action="setImage">
    <DIV style="position: absolute; top:350px; left:100px; width:180px; height:45px"><input type = "text" name = "imageURL"/></DIV>
    <DIV style="position: absolute; top:380px; left:100px; width:180px; height:45px"><input type = "submit" value = "Change"/></DIV>
</form>
<img STYLE="position: absolute; TOP:25px; LEFT:100px; WIDTH:180px; HEIGHT:180px" src="${imageURL}">
<DIV style="position: absolute; top:220px; left:170px; width:180px; height:45px"><i>${student.firstName}</i></DIV>
<DIV style="position: absolute; top:245px; left:170px; width:180px; height:45px"><i>${student.lastName}</i></DIV>
<DIV style="position: absolute; top:305px; left:100px; width:180px; height:45px"><b>Paste URL of admire picture to change current!</b></DIV>



</body>
</html>