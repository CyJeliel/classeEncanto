<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<link type="text/css" rel="stylesheet" href="css/geral.css"/>
		<link type="text/css" rel="stylesheet" href="css/listaDeDesejos.css"/>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Classe e Encanto</title>
	</head>
	<body>
		<%@ include file="/WEB-INF/jsp/header.jsp" %>
		<%@ include file="/WEB-INF/jsp/menuLateral.jsp" %>
		
		<div id="conteudo">
			<div id="cabecalho">
				<span><b>Item</b></span>
				<span id="cabecalhoQuantidade"><b>Quantidade</b></span>
			</div>
			<img  id="miniatura" src="img/bandaid.jpg">
			<span id="descricaoReduzida"><b>Bandaid's personalizados</b></span>
			<br/>
			<span id="descricaoDetalhada">Bandaid's personalizados para Kit Banheiro</span>
			
			<span id="quantidade">
				<select>
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
					<option>6</option>
					<option>7</option>
					<option>8</option>
					<option>9</option>
					<option>10</option>
				</select>
			</span>
		</div>
		
		<%@ include file="/WEB-INF/jsp/footer.jsp" %>
	</body>
</html>
