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
		<c:choose>
			<c:when test="${isAdmin}">
				<%@ include file="/WEB-INF/jsp/menuAdministracao.jsp" %>
			</c:when>
			<c:otherwise>
				<%@ include file="/WEB-INF/jsp/menuLateral.jsp" %>
			</c:otherwise>			
		</c:choose>
		<h1>Lista de produtos</h1>
		
		<div id="conteudo">
			<c:choose>
				<c:when test="${listaDeProdutos != null && !listaDeProdutos.isEmpty()}">
					<div id="escolherProdutos">
						<div id="miniaturasBox">
							<c:forEach var="produto" items="${listaDeProdutos}" >
								<div class="miniatura">
									<a href="detalhesDeProduto?idProduto=${produto.id}">
										<img class="produto" src="<%=request.getContextPath()%>/getImagemProduto?idProduto=${produto.id}">
									</a>
								</div>
							</c:forEach>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<p>Não há produtos nessa categoria.</p>
				</c:otherwise>
			</c:choose>
		</div>
		<%@ include file="/WEB-INF/jsp/footer.jsp" %>
	</body>
</html>