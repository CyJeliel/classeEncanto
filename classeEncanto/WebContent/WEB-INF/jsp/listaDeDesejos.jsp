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
			<div id="conteudoListaDeDesejos">
				<a href="logout" class="logout">Logout</a>
			
				<h1>Lista de Desejos</h1>
				
				<c:choose>
					<c:when test="${listaDeDesejos != null && !listaDeDesejos.isEmpty()}">
						<input id="solicitarOrcamento" type="submit" value="Solicitar Orçamento"/>
						<div id="cabecalho">
							<span><b>Item</b></span>
							<span id="cabecalhoQuantidade"><b>Quantidade</b></span>
						</div>
						<c:forEach var="item" items="${listaDeDesejos}" >
							<div class="item">
								<a href="detalhesDeProduto?idProduto=<c:out value="${item.produto.id}"/>">
									<img id="miniatura" src="<%=request.getContextPath()%>/getImagemProduto?idProduto=${item.produto.id}">
								</a>
								<span id="descricaoReduzida"><b><c:out value="${item.produto.nome}"/></b></span>
								<br/>
								<span id="descricaoDetalhada"><c:out value="${item.produto.resumo}"/></span>
								
								<span id="quantidade">
									<select>
										<option>1</option>
										<option>2</option>
										<option>3</option>
										<option>4</option>
										<option>5</option>
										<option>6</option>
										<option>7</option>
										<option>8</option>
										<option>9</option>
										<option>10</option>
									</select>
								</span>
								
								<a class="link" href="#">Atualizar</a>
								
								<a class="link" id="removerItem" href="excluirProdutoListaDeDesejos?idProduto=${item.produto.id}">Remover</a>
							</div>
						</c:forEach>
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
