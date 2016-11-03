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
	</head>

	<body>
		<form action="loginStudent">

			Please enter your username 		
			<input type="text" name="login"/><br>		
		
			Please enter your password
			<input type="text" name="password"/>
			
			<input type="submit" value="log in">

		</form>
		<form action="signUpRedirectStudent">
			<input type="submit" value="sign up">
		</form>
		<c:if test="${wrongLoginOrPassword == false}">
			<script>
				alert('Wrong login or password');
			</script>
		</c:if>
	</body>
</html>