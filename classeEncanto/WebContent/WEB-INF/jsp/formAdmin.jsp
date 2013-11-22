<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<link type="text/css" rel="stylesheet" href="css/geral.css"/>
		<link type="text/css" rel="stylesheet" href="css/cadastroDeProdutos.css"/>		
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Classe e Encanto</title>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jQuery/jquery-1.10.2.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/novoUsuario.js"></script>
	</head>
	<body>
		<%@ include file="/WEB-INF/jsp/header.jsp" %>
		<%@ include file="/WEB-INF/jsp/menuAdministracao.jsp" %>
			
		<c:if test="${feedbacks != null}">
			<c:forEach var="feedback" items="${feedbacks}">
				<div class="feedback"><c:out value="${feedback}"></c:out></div>
			</c:forEach>
		</c:if>
		
		<div>
			<h1>Novo Administrador</h1>
			<form action="novoAdministrador" method="post">
				<table>
					<tr>
						<td>* Login:</td>
						<td>
							<input type="text" name="login"/>
						</td>						
					</tr>
					<tr>
						<td>* Senha:</td>
						<td>
							<input type="password" name="senha"/>
						</td>						
					</tr>
					<tr>
						<td>* Confirmação:</td>
						<td>
							<input type="password" name="confirmacaoSenha"/>
						</td>						
					</tr>
					<tr>
						<td>* Email:</td>
						<td>
							<input type="text" name="email"/>
						</td>	
					</tr>
					<tr>
						<td>
							<input type="button" onclick="check(this.form)" value="Criar"/>
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


