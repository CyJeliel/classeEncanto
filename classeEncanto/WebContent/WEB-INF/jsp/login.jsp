<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/geral.css">
		<meta charset="UTF-8">
		<title>
			Login
		</title>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jQuery/jquery-1.10.2.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/login.js"></script>
		
	</head>
	<body>
		<%@ include file="/WEB-INF/jsp/header.jsp" %>
		<%@ include file="/WEB-INF/jsp/menuLateral.jsp" %>
		
		<a href="cadastroDeUsuario" class="logout">Criar Login</a>

		<div id="conteudo">
			<h1>Acesso à área do usuário</h1>
				
			<c:if test="${feedbacks != null}">
				<c:forEach var="feedback" items="${feedbacks}">
					<div class="feedback"><c:out value="${feedback}"></c:out></div>
				</c:forEach>
			</c:if>
	
			<form id="form" action="login" method="post">
					Login
					<br/>
					<input type="text" name="login"/>
					<br/>
					Senha
					<br/>
					<input type="password" name="senha"/>
					<br/>
					<input type="button" onclick="check(this.form)" value="Login"/>
			</form>
		</div>
		
		<%@ include file="/WEB-INF/jsp/footer.jsp" %>
	</body>
</html>