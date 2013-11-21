<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<link type="text/css" rel="stylesheet" href="css/geral.css"/>
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
			<h1>Nova Categoria</h1>
			<form method="post" action="salvarCategoria">
				
				<input name="id" type="hidden" value="${categoria != null? categoria.id: 0}"/>
				
				Descrição:
				
				<input type="text" name="descricao" value="${categoria != null? categoria.descricao: ''}">
				<input type="submit" value="${categoria != null? 'Alterar': 'Criar'}">
				<input type="reset" value="Cancelar">
			</form>
		</div>
		<%@ include file="/WEB-INF/jsp/footer.jsp" %>
	</body>
</html>


