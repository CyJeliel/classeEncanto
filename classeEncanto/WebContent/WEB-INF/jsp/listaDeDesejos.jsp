<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<link type="text/css" rel="stylesheet" href="css/geral.css"/>
		<link type="text/css" rel="stylesheet" href="css/listaDeDesejos.css"/>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Classe e Encanto</title>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jQuery/jquery-1.10.2.min.js"></script>
		<script src="js/listaDeDesejos.js"></script>
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
		
		<div id="conteudo">
			
			<c:if test="${feedbacks != null}">
				<c:forEach var="feedback" items="${feedbacks}">
					<div class="feedback"><c:out value="${feedback}"></c:out></div>
				</c:forEach>
			</c:if>
			<div id="conteudoListaDeDesejos">
				<a href="logout" class="logout">Logout</a>
			
				<h1>Lista de Desejos</h1>
				
				<c:choose>
					<c:when test="${listaDeDesejos != null && !listaDeDesejos.isEmpty()}">
						<form action="enviaEmailOrcamento" method="post">
							<input id="solicitarOrcamento" type="submit" value="Solicitar Orçamento"/>
							<table>
								<tr>
									<th>Item</th>
									<th>Descrição</th>
									<th>Quantidade</th>
									<th></th>
								</tr>
								<c:forEach var="item" items="${listaDeDesejos}" >
									<tr>
										<td>
											<a href="detalhesDeProduto?idProduto=<c:out value="${item.produto.id}"/>">
												<img id="miniatura" src="<%=request.getContextPath()%>/getImagemProduto?idProduto=${item.produto.id}">
											</a>
										</td>
										<td class="descricaoProduto">
											<b class="margemEsquerda20"><c:out value="${item.produto.nome}"/></b>
											<br/>
											<span class="margemEsquerda20"><c:out value="${item.produto.resumo}" /></span>
										</td>
										<td>
											<form method="post" action="alterarQuantidadeItemListaDeDesejos" id="formAtualizarQuantidade${item.produto.id}" class="formAtualizarQuantidade">
												<input name="quantidade" id="quantidade${item.produto.id}" value="${item.quantidade}" class="inputQuantidade"/>
												<input type="hidden" value="${item.produto.id}" name="produto.id"/>
												<a class="link" onclick="atualizarQuantidade(${item.produto.id})">Atualizar</a>
											</form>
										</td>
										<td>
											<a class="link" id="removerItem" href="excluirProdutoListaDeDesejos?idProduto=${item.produto.id}">Remover</a>
										</td>
									</tr>
								</c:forEach>
							</table>
						</form>
					</c:when>
					<c:otherwise>
						<br/>
						Não há produtos cadastrados na lista de desejos.
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		
		<%@ include file="/WEB-INF/jsp/footer.jsp" %>
	</body>
</html>
