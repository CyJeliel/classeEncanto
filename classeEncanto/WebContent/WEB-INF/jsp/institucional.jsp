<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<link type="text/css" rel="stylesheet" href="css/geral.css"/>
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
		
		<h1>Missão</h1>
		<p>Nós da Classe e Encanto temos como missão oferecer produtos de qualidade aos nossos 
		clientes, buscando sua satisfação na realização de seus eventos, sem que eles precisem
		se preocupar com os detalhes de decoração, que ficam sob nossa responsabilidade.
		</p>
		<h1>Visão</h1>
		<p>Nós buscamos prover produtos personalizados de forma a agradar nossas clientes e seus
		convidados, sempre visando à produção sustentável e respeitando a natureza.</p>
		<%@ include file="/WEB-INF/jsp/footer.jsp" %>
	</body>
</html>