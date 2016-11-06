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
        body {
            background-image: url("");
            background-repeat: no-repeat;
            background-size: 100%;
        }
    </style>
</head>
<body>
<div class="text">
    <p>Welcome back, ${teacher.firstName}!
        <br/><br/>There is you can set marks.</p>
</div>
<br>
<form action ="setMark" method="get">
    <table>
        <tr>
            <th>Course</th>
            <th>Students</th>
            <th>Mark</th>
            <th>SetMark</th>
        </tr>
        <c:forEach items="${students}" var="student" varStatus="loop">
            <tr>
                <td>${subject}</td>
                <td>${student.firstName} ${student.lastName}</td>
                <td>${marks[loop.index]}</td>
                <td><input type="number" name="mark${loop.index}"/></td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <div align="center">
        <input type="submit" value="start">
    </div>
</form>
<c:if test="${illegalValues == false}">
    <script>
        alert('You can set mark only in diapason from 1 to 100, also you should to fill all the fields');
    </script>
</c:if>
<form action="setImageTeacher">
    <DIV style="position: absolute; top:350px; left:100px; width:180px; height:45px"><input type = "text" name = "imageURL"/></DIV>
    <DIV style="position: absolute; top:380px; left:100px; width:180px; height:45px"><input type = "submit" value = "Change"/></DIV>
</form>
<img STYLE="position: absolute; TOP:25px; LEFT:100px; WIDTH:180px; HEIGHT:180px" src="${imageURL}">
<DIV style="position: absolute; top:220px; left:170px; width:180px; height:45px"><i>${teacher.firstName}</i></DIV>
<DIV style="position: absolute; top:245px; left:170px; width:180px; height:45px"><i>${teacher.lastName}</i></DIV>
<DIV style="position: absolute; top:305px; left:100px; width:180px; height:45px"><b>Paste URL of admire picture to change current!</b></DIV>


<br><br>
</body>
</html>