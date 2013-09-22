<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<link type="text/css" rel="stylesheet" href="css/geral.css"/>
		<link type="text/css" rel="stylesheet" href="css/cadastroProdutosEmDestaque.css"/>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Classe e Encanto</title>
	</head>
	<body>
		<%@ include file="/WEB-INF/jsp/header.jsp" %>
		<%@ include file="/WEB-INF/jsp/menuLateral.jsp" %>

		<div id="conteudo">
			<div class="produtoDestaque" id="destaqueEsquerda">
				<a href="#" class="linkAdicionar">Adicionar</a>
			</div>
			<div class="produtoDestaque" id="destaqueDireita">
				<a href="#" class="linkAdicionar">Adicionar</a>
			</div>
			<div class="produtoDestaque" id="destaqueEsquerda">
				<a href="#" class="linkAdicionar">Adicionar</a>
			</div>
			<div class="produtoDestaque" id="destaqueDireita">
				<a href="#" class="linkAdicionar">Adicionar</a>
			</div>
		</div>

		<%@ include file="/WEB-INF/jsp/footer.jsp" %>
	</body>
</html>