<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="css/geral.css">
		<meta charset="UTF-8">
		<title>Fale conosco</title>
		<script src="js/faleConosco.js"></script>
	</head>
	<body>
		<%@ include file="/WEB-INF/jsp/header.jsp" %>
		<%@ include file="/WEB-INF/jsp/menuLateral.jsp" %>
		<form name="faleConosco" >
			<pre>
				Fale Conosco<br />
				Email
				<input name="email" type="text" />
				Telefone
				<input name="telefone" type="text" />
				<input value="Enviar" type="button" onclick="check(this.form)" />
			</pre>
		</form>
		<%@ include file="/WEB-INF/jsp/footer.jsp" %>
	</body>
</html>