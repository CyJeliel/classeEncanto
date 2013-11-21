<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<link type="text/css" rel="stylesheet" href="css/geral.css"/>
		<link type="text/css" rel="stylesheet" href="css/cadastroDeProdutos.css"/>		
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Classe e Encanto</title>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jQuery/jquery-1.10.2.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/cadastroDeProduto.js"></script>
	</head>
	<body>
		<%@ include file="/WEB-INF/jsp/header.jsp" %>
		<%@ include file="/WEB-INF/jsp/menuAdministracao.jsp" %>
		<div id="conteudo">
			<a href="logoutAdmin" class="logout">Logout</a>
			
			<c:if test="${feedbacks != null}">
				<c:forEach var="feedback" items="${feedbacks}">
					<div class="feedback"><c:out value="${feedback}"></c:out></div>
				</c:forEach>
			</c:if>
			<h1>Novo Produto</h1>
			<form method="post" action="salvarProduto" enctype="multipart/form-data">
				<input name="id" type="hidden" value="${produto != null? produto.id: 0}"/>
				<table>
					<tr>
						<td>Nome:</td>
						<td>
							<input type="text" name="nome" value="${produto != null? produto.nome: ''}">
						</td>
					</tr>
					<tr>
						<td>Imagem:</td>
						<td>
							<c:if test="${produto != null}">
								<img id="imagem" alt="" src="<%=request.getContextPath()%>/getImagemProduto?idProduto=${produto.id}">
								<br />
							</c:if>
							<input type="file" name="arquivo" id="imagemDoProduto" value="${produto != null? produto.imagem: ''}" onchange="alterarVisibilidadeDaImagem(this)">
						</td>
					</tr>
					<tr>
						<td>Resumo:</td>
						<td>
							<input type="text" name="resumo" value="${produto != null? produto.resumo: ''}">
						</td>
					</tr>
					<tr>
						<td>Detalhes:</td>
						<td>
							<textarea name="descricao" cols="50">${produto != null? produto.descricao: ''}</textarea>
						</td>
					</tr>
					<tr>
						<td>Eventos:</td>
						<td>
							<select multiple name="grupoDoProduto">
								<c:forEach var="categoria" items="${gruposCategoria}">
									<option value="${categoria.id}">${categoria.descricao}</option>								
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td>Decorações:</td>
						<td>
							<select multiple name="temaDoProduto">
								<c:forEach var="categoria" items="${temasCategoria}">
									<option value="${categoria.id}">${categoria.descricao}</option>								
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							<input type="submit" value="${produto != null? 'Alterar': 'Criar'}">
						</td>
						<td>
							<input type="reset" value="Cancelar">
						</td>
					</tr>
				</table>
			</form>
		</div>
		<%@ include file="/WEB-INF/jsp/footer.jsp" %>
	</body>
</html>


