<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java"
    contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
		<title>Login Page</title>
		<style>
			body {
				background-image: url("http://3.bp.blogspot.com/-W7qGPyNz-Tw/TaEqahQntzI/AAAAAAAAAWQ/I6_1a8nXZWg/s1600/Professor+wallpaper.jpg");
				background-repeat: no-repeat;
				background-size: 100%;
			}
			.login{
				position: relative;
				top: 5%;
				left: 70%;
				width: 10%;
				padding: 6% 6%;
				background: rgba(0, 0, 0, 0.3);
				border: 1px solid rgba(147, 184, 189,0.8);
				box-shadow:
						0 2px 5px rgba(105, 108, 109,  0.7),
						0 0 8px 5px rgba(208, 223, 226, 0.4) inset;
				border-radius: 5px;
			}
			.login{
				z-index: 22;
			}
			.login h1 {
				margin: -20px -20px 21px;
				line-height: 40px;
				font-size: 15px;
				font-weight: bold;
				color: white;
				text-align: center;
				text-shadow: 0 1px white;
				border-bottom: 1px solid #cfcfcf;
				border-radius: 3px 3px 0 0;
				-webkit-box-shadow: 0 1px whitesmoke;
				box-shadow: 0 1px whitesmoke;
			}

			.login input[type=text], .login input[type=password] {
				width: 110%;
			}
			input[type=submit] {
				padding: 0 18px;
				height: 29px;
				font-size: 12px;
				font-weight: bold;
				color: #527881;
				text-shadow: 0 1px #e3f1f1;
				background: #cde5ef;
				border: 1px solid;
				border-color: #b4ccce #b3c0c8 #9eb9c2;
				border-radius: 16px;
				outline: 0;
				-webkit-box-sizing: content-box;
				-moz-box-sizing: content-box;
				box-sizing: content-box;
				background-image: -webkit-linear-gradient(top, #edf5f8, #cde5ef);
				background-image: -moz-linear-gradient(top, #edf5f8, #cde5ef);
				background-image: -o-linear-gradient(top, #edf5f8, #cde5ef);
				background-image: linear-gradient(to bottom, #edf5f8, #cde5ef);
				-webkit-box-shadow: inset 0 1px white, 0 1px 2px rgba(0, 0, 0, 0.15);
				box-shadow: inset 0 1px white, 0 1px 2px rgba(0, 0, 0, 0.15);
			}
			input[type=submit]:active {
				background: #cde5ef;
				border-color: #9eb9c2 #b3c0c8 #b4ccce;
				-webkit-box-shadow: inset 0 0 3px rgba(0, 0, 0, 0.2);
				box-shadow: inset 0 0 3px rgba(0, 0, 0, 0.2);
			}
		</style>
	</head>

	<body>
	<div class="container">
		<div class="login">
			<h1>Login</h1>
			<form action="loginTeacher">
				<p><input type="text" name="login" placeholder="Username"></p>
				<p><input type="passwo+rd" name="password" placeholder="Password"></p>
				<p class="submit"><input type="submit" value="sign in"></p>
			</form>
		</div>
	</div>
	<c:if test="${wrongLoginOrPassword == false}">
		<script>
			alert('Wrong login or password');
		</script>
	</c:if>
	</body>
</html>