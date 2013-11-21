<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<link type="text/css" rel="stylesheet" href="css/geral.css"/>
		<link type="text/css" rel="stylesheet" href="css/listaDeCategorias.css"/>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Classe e Encanto</title>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jQuery/jquery-1.10.2.min.js"></script>
		<script src="js/listaDeCategorias.js"></script>
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
		<h1>Lista de categorias
			<a title="Adicionar categoria" href="cadastroDeCategoria" class="manterCategoria">Adicionar</a>
		</h1>
		
		<div id="conteudo">
			<c:choose>
				<c:when test="${listaDeCategorias != null && !listaDeCategorias.isEmpty()}">
					<table>
						<th><b>Categoria</b></th>
						<th><b>Tipo</b></th>
						<c:forEach var="categoria" items="${listaDeCategorias}" >
							<tr>
								<td>${categoria.descricao}</td>
								<td>${categoria.tipo}</td>
								<td><a title="Alterar categoria" href="formAlterarDadosCategoria?idCategoria=${categoria.id}" class="manterCategoria">Alterar</a></td>
								<td>
									<form method="post" action="excluirCategoria" id="formRemoverCategoria${categoria.id}">
										<input name="id" type="hidden" value="${categoria.id}">
										<a onclick="excluirCategoria(${categoria.id})" title="Excluir Categoria" class="manterCategoria">Remover</a>
									</form>
								</td>
							</tr>
						</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
					Não há categorias cadastradas.
				</c:otherwise>
			</c:choose>
		</div>
		<%@ include file="/WEB-INF/jsp/footer.jsp" %>
	</body>
</html>