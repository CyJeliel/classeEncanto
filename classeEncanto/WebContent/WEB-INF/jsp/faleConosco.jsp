<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="css/geral.css">
<!-- 		<link rel="stylesheet" type="text/css" href="css/faleConosco.css">
-->
		<meta charset="UTF-8">
		<title>Fale conosco</title>
		<script src="js/faleConosco.js"></script>
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
		<form name="faleConosco" class="faleConosco">
				<h1>Fale Conosco</h1>
				<table>
					<tr>
						<td>Email
						</td>
						<td><div id="email_alert" style="display:inline; color: red;"></div>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input name="email" type="text" />			
						</td>
					</tr>
					<tr>
						<td>Telefone
						</td>
						<td><div id="telefone_alert" style="display:inline; color: red;"></div>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input name="telefone" type="text" />
						</td>
					</tr>
					<tr>
						<td>Mensagem
						</td>
						<td><div id="message_alert" style="display:inline; color: red;"></div>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<textarea name="mensagem" cols="94" rows="10"></textarea>
						</td>
					</tr>
				</table>
				<input value="Enviar" type="button" onclick="check(this.form)" />
		</form>
		<%@ include file="/WEB-INF/jsp/footer.jsp" %>
	</body>
</html>