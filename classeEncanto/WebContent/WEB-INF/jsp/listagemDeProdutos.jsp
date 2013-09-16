<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/geral.css"/>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Classe e Encanto</title>
		<script src="<%=request.getContextPath()%>/js/listagemDeProdutos.js"></script>
	</head>
	<body>
		<%@ include file="/jsp/header.jsp" %>
		<%@ include file="/jsp/menuLateral.jsp" %>
			<h3>Lista de produtos</h3>
			<div id="listagemDeProdutos">
				
			</div>
		<%@ include file="/jsp/footer.jsp" %>
	</body>
</html>