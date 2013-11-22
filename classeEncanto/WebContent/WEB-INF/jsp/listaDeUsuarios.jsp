<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<link type="text/css" rel="stylesheet" href="css/geral.css"/>
		<link type="text/css" rel="stylesheet" href="css/listaDeUsuarios.css"/>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Classe e Encanto</title>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jQuery/jquery-1.10.2.min.js"></script>
		<script src="js/listaDeUsuarios.js"></script>
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
		<h1>Lista de Usuários
			<a title="Adicionar Administrador" href="cadastroDeUsuario" class="manterUsuario">Adicionar</a>
		</h1>
		
		<div id="conteudo">
			<table>
				<tr>
					<th><b>Usuário</b></th>
					<th><b>Tipo</b></th>
				</tr>
				<c:forEach var="usuario" items="${listaDeUsuarios}" >
					<tr>
						<td class="descricao">${usuario.login}</td>
						<td>
							<c:choose>
								<c:when test="${usuario.admin}">Administrador</c:when>
								<c:otherwise>Usuário</c:otherwise>
							</c:choose>
						
						</td>
						<td><a title="Alterar usuário" href="formAlterarDadosUsuario?idUsuario=${usuario.id}" class="manterUsuario">Alterar</a></td>
						<td>
							<form method="post" action="excluirUsuario" id="formRemoverUsuario${usuario.id}">
								<input name="id" type="hidden" value="${usuario.id}">
								<a onclick="excluirUsuario(${usuario.id})" title="Excluir Usuário" class="manterUsuario">Remover</a>
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<%@ include file="/WEB-INF/jsp/footer.jsp" %>
	</body>
</html>