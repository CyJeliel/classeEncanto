<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<link type="text/css" rel="stylesheet" href="css/geral.css"/>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Classe e Encanto</title>
		<script src="js/listagemDeProdutos.js"></script>
	</head>
	<body>
		<%@ include file="/WEB-INF/jsp/header.jsp" %>
		<%@ include file="/WEB-INF/jsp/menuLateral.jsp" %>
		<h3>Produto<c:out value="${idProduto}"/></h3>
		<img src="/WEB-INF/img/produto<c:out value="${idProduto}"/>.jpg" alt="imagem do produto <c:out value="${idProduto}"/>" class="imagem_produto" />
		<h4>Resumo do produto<c:out value="${idProduto}"/></h4>
		<h4>Detalhes do produto<c:out value="${idProduto}"/></h4>
		<div class="block">
			<h4>Itens relacionados ao produto <c:out value="${idProduto}"/></h4>		
			<ul>
				<c:forEach var="item"
           items="${itensRelacionados}" >
 				<li><a href="detalhesDeProduto?idProduto=<c:out value="${item}"/>">Produto<c:out value="${item}"/></a></li>
				</c:forEach>
			</ul>
		</div>
		<%@ include file="/WEB-INF/jsp/footer.jsp" %>
	</body>
</html>