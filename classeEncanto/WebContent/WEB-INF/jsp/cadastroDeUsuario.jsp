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
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/cadastroDeUsuario.js"></script>
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
			
			<div>
				<c:choose>
				<c:when test="${usuario != null}">
					<h1>Alterar Usuário</h1>
				</c:when>
				<c:otherwise>
					<h1>Novo Usuário</h1>
				</c:otherwise>
				
				</c:choose>
				<form action="salvarUsuario" method="post">
					<input type="hidden" name="id" value="${usuario != null ? usuario.id: 0}"/>
				
					<table>
						<tr>
							<td>* Login:</td>
							<td>
								<input type="text" name="login" value="${usuario != null ? usuario.login: ''}"/>
							</td>						
						</tr>
						<tr>
							<td>* Senha:</td>
							<td>
								<input type="password" name="senha" value="${usuario != null ? usuario.senha: ''}"/>
							</td>						
						</tr>
						<tr>
							<td>* Confirmação:</td>
							<td>
								<input type="password" name="confirmacaoSenha" value="${usuario != null ? usuario.senha: ''}"/>
							</td>						
						</tr>
						<tr>
							<td>* Email:</td>
							<td>
								<input type="text" name="email" value="${usuario != null ? usuario.email: ''}"/>
							</td>	
						</tr>
						<c:if test="${isAdmin}">
							<tr>
								<td>Administrador:</td>
								<td>
									<c:choose>
										<c:when test="${usuario != null && usuario.admin}">
											<input type="checkbox" name="admin" checked/>
										</c:when>									
										<c:otherwise>
											<input type="checkbox" name="admin"/>
										</c:otherwise>
									</c:choose>
								</td>	
							</tr>
						</c:if>
						<tr>
							<td>
								<input type="button" onclick="check(this.form)" value="${usuario != null ? 'Alterar': 'Criar'}" name="admin"/>
							</td>
							<td>
								<input type="reset" value="Cancelar">
							</td>						
						</tr>
					</table>
				</form>
			</div>
		</div>
		<%@ include file="/WEB-INF/jsp/footer.jsp" %>
	</body>
</html>


