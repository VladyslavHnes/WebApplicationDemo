<%@page contentType="text/html" pageEncoding="UTF-8" language="java" isELIgnored="false" session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Subscribe page</title>
    <style type="text/css">
		html,body {
			height: 100%;
			width: 100%;
			padding: 0;
		}
        .container {
        	width: 100%;
        	position: relative;
			margin: 0 auto;

        }
        .header {
        	height: 30vh;
        	background-image: url('https://cdn.pixabay.com/photo/2015/07/06/13/58/arlberg-pass-833326_960_720.jpg');
        	-webkit-background-size: cover;
        	background-size: cover;
        	position: relative;
        }
        .name {
        	position: absolute;
        	bottom: 0;
        	left: 0;
        	width: 100%;
        	background: rgba(255,255,255, 0.5);
        	color: #444;
			text-align: center;
			font-size: 20px;
			font-style: italic;
        }
        .rnd-photo {
        	border-radius: 100%;
			position: relative;
			margin-top: -12vh;
			height: 25vh;
			width: 25vh;
			left: 5%;
			border: 3px solid #fff;
			overflow: hidden;
        }
        .rnd-photo img {
			width: 100%;
			height: 100%;
        }
        .settings {
        	width: 19%;
        	display: inline-block;
			float: left;
			border-right: 1px solid #444;
			padding: 10px;
        }
        .content {
			width: 80%;
			display: inline-block;
			float: left;
			padding: 10px;
        }
    </style>
</head>
<body>
<div class="container">
	<div class="header">
		<div class="name">${teacher.firstName} ${teacher.lastName}</div>
	</div>
	<div class="rnd-photo"><img src="${imageURL}"></div>
	<div class="settings">
		<form action="setImageTeacher">
			<p>Paste URL of admire picture to change current!</p>
		    <DIV><input type = "text" name = "imageURL"/></DIV>
		    <DIV><input type = "submit" value = "Change"/></DIV>
		</form>
	</div>
	<div class="content">
		<form action ="setMark" method="get">
			<p>There is you can set marks.</p>
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
	</div>
</div>
<br>

<c:if test="${illegalValues == false}">
    <script>
        alert('You can set mark only in diapason from 1 to 100, also you should to fill all the fields');
    </script>
</c:if>

<br><br>
</body>
</html>