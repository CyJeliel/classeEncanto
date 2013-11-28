<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<link type="text/css" rel="stylesheet" href="css/geral.css"/>
		<link type="text/css" rel="stylesheet" href="css/cadastroProdutosEmDestaque.css"/>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Classe e Encanto</title>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jQuery/jquery-1.10.2.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/cadastroProdutosEmDestaque.js"></script>
	</head>
	<body>
		<%@ include file="/WEB-INF/jsp/header.jsp" %>
		<%@ include file="/WEB-INF/jsp/menuAdministracao.jsp" %>

		<a href="logoutAdmin" class="logout">Logout</a>
		<div id="conteudo">
			<div id="produtosEscolhidos" >
				<div class="produtoDestaque" id="destaqueEsquerda">
					<c:choose>
						<c:when test="${listaDeDestaques != null && listaDeDestaques.size() >= 1}">
							<span class="linkAdicionar">
								<img class="produto" src="<%=request.getContextPath()%>/getImagemProduto?idProduto=${listaDeDestaques.get(0).produto.id}">
								<a onclick="excluirDestaque(${listaDeDestaques.get(0).id})" title="Excluir Destaque" class="manterDestaque">Remover</a>
								<form method="post" id="formRemoverDestaque${listaDeDestaques.get(0).id}" action="excluirDestaque">
									<input type="hidden" value="${listaDeDestaques.get(0).id}" name="id"/>
								</form>
							</span>
						</c:when>
						<c:otherwise>
							<span class="linkAdicionar" onclick="escolheProduto(1);">Adicionar</span>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="produtoDestaque" id="destaqueDireita">
					<c:choose>
						<c:when test="${listaDeDestaques != null && listaDeDestaques.size() >= 2}">
							<span class="linkAdicionar">
								<img class="produto" src="<%=request.getContextPath()%>/getImagemProduto?idProduto=${listaDeDestaques.get(1).produto.id}">
								<a onclick="excluirDestaque(${listaDeDestaques.get(1).id})" title="Excluir Destaque" class="manterDestaque">Remover</a>
								<form method="post" id="formRemoverDestaque${listaDeDestaques.get(1).id}" action="excluirDestaque">
									<input type="hidden" value="${listaDeDestaques.get(1).id}" name="id"/>
								</form>
							</span>
						</c:when>
						<c:otherwise>
							<span class="linkAdicionar" onclick="escolheProduto(2);">Adicionar</span>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="produtoDestaque" id="destaqueEsquerda">
					<c:choose>
						<c:when test="${listaDeDestaques != null && listaDeDestaques.size() >= 3}">
							<span class="linkAdicionar">
								<img class="produto" src="<%=request.getContextPath()%>/getImagemProduto?idProduto=${listaDeDestaques.get(2).produto.id}">
								<a onclick="excluirDestaque(${listaDeDestaques.get(2).id})" title="Excluir Destaque" class="manterDestaque">Remover</a>
								<form method="post" id="formRemoverDestaque${listaDeDestaques.get(2).id}" action="excluirDestaque">
									<input type="hidden" value="${listaDeDestaques.get(2).id}" name="id"/>
								</form>
							</span>
						</c:when>
						<c:otherwise>
							<span class="linkAdicionar" onclick="escolheProduto(3);">Adicionar</span>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="produtoDestaque" id="destaqueDireita">
					<c:choose>
						<c:when test="${listaDeDestaques != null && listaDeDestaques.size() >= 4}">
							<span class="linkAdicionar">
								<img class="produto" src="<%=request.getContextPath()%>/getImagemProduto?idProduto=${listaDeDestaques.get(3).produto.id}">
								<a onclick="excluirDestaque(${listaDeDestaques.get(3).id})" title="Excluir Destaque" class="manterDestaque">Remover</a>
								<form method="post" id="formRemoverDestaque${listaDeDestaques.get(3).id}" action="excluirDestaque">
									<input type="hidden" value="${listaDeDestaques.get(3).id}" name="id"/>
								</form>
							</span>
						</c:when>
						<c:otherwise>
							<span class="linkAdicionar" onclick="escolheProduto(4);">Adicionar</span>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			<div id="escolherProdutos" style="display: none;">
				<div id="miniaturasBox">
					<c:forEach var="produto" items="${listaDeProdutos}" >
						<div class="miniatura">
							<form method="post" id="selecionaProduto${produto.id}" action="selecionaProduto">
								<input type="hidden" value="1" name="posicao" class="posicao"/>
								<input type="hidden" value="${produto.id}" name="produto.id"/>
								<img onclick="selecionaProduto(${produto.id});" class="produto" src="<%=request.getContextPath()%>/getImagemProduto?idProduto=${produto.id}">
							</form>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>

		<%@ include file="/WEB-INF/jsp/footer.jsp" %>
	</body>
</html>