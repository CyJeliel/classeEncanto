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
		<%@ include file="/WEB-INF/jsp/menuLateral.jsp" %>
		<div id="conteudo">
			<a href="#" onclick="exibeProximoDestaque()" id="setaFrente"><img src="img/setaFrente.png"></img></a>
			<a href="#" onclick="exibeDestaqueAnterior()" id="setaTras"><img src="img/setaTras.png"></img></a>
			
			<c:forEach var="destaque" items="${listaDeDestaques}" >
				<a id="${destaque.posicao}" href="detalhesDeProduto?idProduto=${destaque.id}">
					<img  id="destaqueHome"	src="${destaque.local}">
				</a>
			</c:forEach>
		</div>
		<%@ include file="/WEB-INF/jsp/footer.jsp" %>
	</body>
</html>