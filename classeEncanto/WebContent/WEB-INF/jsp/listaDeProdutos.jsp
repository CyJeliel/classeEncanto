<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<link type="text/css" rel="stylesheet" href="css/geral.css"/>
		<link type="text/css" rel="stylesheet" href="css/listaDeProdutos.css"/>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Classe e Encanto</title>
		<script src="js/listagemDeProdutos.js"></script>
	</head>
	<body>
		<%@ include file="/WEB-INF/jsp/header.jsp" %>
		<%@ include file="/WEB-INF/jsp/menuLateral.jsp" %>
		<h1>Lista de produtos</h1>
		
		<div id="conteudo">
			<div id="escolherProdutos">
				<div id="miniaturasBox">
					<c:forEach var="produto" items="${listaDeProdutos}" >
						<div class="miniatura">
							<a href="detalhesDeProduto?idProduto=${produto.id}">
								<img class="produto" src="${produto.local}">
							</a>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<%@ include file="/WEB-INF/jsp/footer.jsp" %>
	</body>
</html>