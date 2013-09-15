<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>css/faleConosco.css">
		<meta charset="UTF-8">
		<title>Fale conosco</title>
		<script src="<%=request.getContextPath()%>js/faleConosco.js"></script>
	</head>
	<body>
		<div id="faleConosco">
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
		</div>
	</body>
</html>