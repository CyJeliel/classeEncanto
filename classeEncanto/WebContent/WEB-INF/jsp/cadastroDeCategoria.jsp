<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<link type="text/css" rel="stylesheet" href="css/geral.css"/>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/cadastroDeCategoria.js"></script>
		<title>Classe e Encanto</title>
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
			
			<c:choose>
				<c:when test="${categoria != null}">
					<h1>Alterar Categoria</h1>
				</c:when>
				<c:otherwise>
					<h1>Nova Categoria</h1>
				</c:otherwise>
			</c:choose>
			
			<form method="post" action="salvarCategoria">
				
				<input name="id" type="hidden" value="${categoria != null? categoria.id: 0}"/>
				
				<table>
					<tr>
						<td>Descrição:</td>
						<td><input type="text" name="descricao" value="${categoria != null? categoria.descricao: ''}"></td>
					</tr>
					<tr>
						<td>Tipo:</td>
						<td>
							<c:choose>
								<c:when test="${categoria != null && categoria.tipo.equals('Evento')}">
									<input type="hidden" name="tipo" value="Evento">
									<select disabled="disabled">
										<option value="Evento" selected="selected">Evento</option>
										<option value="Decoracao">Decoração</option>
									</select>
								</c:when>
								<c:when test="${categoria != null && categoria.tipo.equals('Decoracao')}">
									<input type="hidden" name="tipo" value="Decoracao">
									<select disabled="disabled">
										<option value="Evento">Evento</option>
										<option value="Decoracao" selected="selected">Decoração</option>
									</select>
								</c:when>
								<c:otherwise>
									<select name="tipo">
										<option value="Evento">Evento</option>
										<option value="Decoracao">Decoração</option>
									</select>
								</c:otherwise>
							</c:choose>
					</tr>
					<tr>
						<td>
							<input type="button" onclick="check(this.form)" value="${categoria != null? 'Alterar': 'Criar'}">
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


