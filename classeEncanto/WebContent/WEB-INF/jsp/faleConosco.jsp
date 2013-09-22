<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="css/geral.css">
		<link rel="stylesheet" type="text/css" href="css/faleConosco.css">
		<meta charset="UTF-8">
		<title>Fale conosco</title>
		<script src="js/faleConosco.js"></script>
	</head>
	<body>
		<%@ include file="/WEB-INF/jsp/header.jsp" %>
		<%@ include file="/WEB-INF/jsp/menuLateral.jsp" %>
		<form name="faleConosco" class="faleConosco">
				<h1>Fale Conosco</h1>
				<span class="label">Email</span>
				<br/>
				<input name="email" type="text" />
				<br/>
				<span class="label">Telefone</span>
				<br/>
				<input name="telefone" type="text" />
				<br/>
				<span class="label">Mensagem</span>
				<br/>
				<textarea name="mensagem" cols="94" rows="10"></textarea>
				<br/>
				<input value="Enviar" type="button" onclick="check(this.form)" />
		</form>
		<%@ include file="/WEB-INF/jsp/footer.jsp" %>
	</body>
</html>