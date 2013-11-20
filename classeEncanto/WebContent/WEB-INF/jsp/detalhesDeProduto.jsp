<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<link type="text/css" rel="stylesheet" href="css/geral.css"/>
		<link type="text/css" rel="stylesheet" href="css/detalhesDeProduto.css"/>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Classe e Encanto</title>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jQuery/jquery-1.10.2.min.js"></script>
		<script src="js/detalhesDeProduto.js"></script>
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
		
		<h1>
			<c:out value="${produto.nome}"/> 
			<a href="adicionarListaDeDesejos?produtoId=${produto.id}"><img src="img/listaDeDesejos.png" id="adicionarListaDeDesejos" title="Adicionar à Lista de Desejos"/></a>
			<c:if test="${isAdmin}">
				<a title="Alterar Produto" href="formAlterarDadosProduto?idProduto=${produto.id}" class="manterProduto">Alterar</a>
				<form method="post" action="excluirProduto" id="formRemoverProduto">
					<input name="id" type="hidden" value="${produto.id}">
					<a onclick="excluirProduto(this.form)" title="Excluir Produto" class="manterProduto">Remover</a>
				</form>
			</c:if>
		</h1>
		<div>
			<img src="img/produto<c:out value="${produto.id}"/>.png" alt="imagem do produto <c:out value="${produto.id}"/>" class="imagem_produto" />
		</div>
		<h2>Resumo</h2>
		<p>
			<c:out value="${produto.resumo}"/>
		</p>

		<h2>Detalhes</h2>
		<p>
			<c:out value="${produto.descricao}"/>
		</p>

		<h2>Itens relacionados</h2>		
		<div id="conteudo">
			<div id="escolherProdutos">
				<div id="miniaturasBox">
					<c:forEach var="item" items="${itensRelacionados}" >
						<div class="miniatura">
							<a href="detalhesDeProduto?idProduto=<c:out value="${item}"/>">
								<img class="produto" src="img/bandaid.jpg">
							</a>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		
		<%@ include file="/WEB-INF/jsp/footer.jsp" %>
	</body>
</html>