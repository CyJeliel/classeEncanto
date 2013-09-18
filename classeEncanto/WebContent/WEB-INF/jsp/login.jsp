<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/geral.css">
		<meta charset="UTF-8">
		<title>
			Login page
		</title>
		<script src="<%=request.getContextPath()%>/js/login.js"></script>
	</head>
	<body>
		<%@ include file="../header.jsp" %>
		<%@ include file="../menuLateral.jsp" %>
		<form name="login">
			<pre>
				Entrada<br />
				Login
				<input type="text" name="login"/>
				Senha
				<input type="password" name="senha"/>
				<input type="button" onclick="check(this.form)" value="Login"/>
			</pre>
		</form>
		<%@ include file="../footer.jsp" %>
	</body>
</html>