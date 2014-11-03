<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<link type="text/css" rel="stylesheet" href="css/geral.css"/>
		<link type="text/css" rel="stylesheet" href="css/home.css"/>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Classe e Encanto</title>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jQuery/jquery-1.10.2.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/home.js"></script>
	</head>
	<body onload="exibeProximoDestaque()">
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
			<div id="conteudoHome">
				<a href="#" onclick="exibeDestaqueAnterior()" id="setaTras"><img src="img/anterior.png"></img></a>
				
				<c:forEach var="destaque" items="${listaDeDestaques}" >
					<a id="${destaque.posicao}" href="detalhesDeProduto?idProduto=${destaque.id}">
						<img  id="destaqueHome"	src="<%=request.getContextPath()%>/getDestaquehome?posicao=${destaque.posicao}">
					</a>
				</c:forEach>
				<a href="#" onclick="exibeProximoDestaque()" id="setaFrente"><img src="img/proximo.png"></img></a>
			</div>
		</div>
		<%@ include file="/WEB-INF/jsp/footer.jsp" %>
	</body>
</html>