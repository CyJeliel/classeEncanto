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
						<c:when test="${destaque1 != null}">
							<span class="linkAdicionar">
								<img class="produto" src="<%=request.getContextPath()%>/getImagemProduto?idProduto=${destaque1.produto.id}">
								<a onclick="excluirDestaque(${destaque1.id})" title="Excluir Destaque" class="manterDestaque">Remover</a>
								<form method="post" id="formRemoverDestaque${destaque1.id}" action="excluirDestaque">
									<input type="hidden" value="${destaque1.id}" name="id"/>
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
						<c:when test="${destaque2 != null}">
							<span class="linkAdicionar">
								<img class="produto" src="<%=request.getContextPath()%>/getImagemProduto?idProduto=${destaque2.produto.id}">
								<a onclick="excluirDestaque(${destaque2.id})" title="Excluir Destaque" class="manterDestaque">Remover</a>
								<form method="post" id="formRemoverDestaque${destaque2.id}" action="excluirDestaque">
									<input type="hidden" value="${destaque2.id}" name="id"/>
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
						<c:when test="${destaque3 != null}">
							<span class="linkAdicionar">
								<img class="produto" src="<%=request.getContextPath()%>/getImagemProduto?idProduto=${destaque3.produto.id}">
								<a onclick="excluirDestaque(${destaque3.id})" title="Excluir Destaque" class="manterDestaque">Remover</a>
								<form method="post" id="formRemoverDestaque${destaque3.id}" action="excluirDestaque">
									<input type="hidden" value="${destaque3.id}" name="id"/>
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
						<c:when test="${destaque4 != null}">
							<span class="linkAdicionar">
								<img class="produto" src="<%=request.getContextPath()%>/getImagemProduto?idProduto=${destaque4.produto.id}">
								<a onclick="excluirDestaque(${destaque4.id})" title="Excluir Destaque" class="manterDestaque">Remover</a>
								<form method="post" id="formRemoverDestaque${destaque4.id}" action="excluirDestaque">
									<input type="hidden" value="${destaque4.id}" name="id"/>
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