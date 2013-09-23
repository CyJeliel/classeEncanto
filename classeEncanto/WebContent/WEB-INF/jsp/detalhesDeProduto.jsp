<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<link type="text/css" rel="stylesheet" href="css/geral.css"/>
		<link type="text/css" rel="stylesheet" href="css/detalhesDoProduto.css"/>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Classe e Encanto</title>
		<script src="js/listagemDeProdutos.js"></script>
	</head>
	<body>
		<%@ include file="/WEB-INF/jsp/header.jsp" %>
		<%@ include file="/WEB-INF/jsp/menuLateral.jsp" %>
		
		<h1>
			<c:out value="${produto.nome}"/> 
			<a href="#"><img id="adicionarListaDeDesejos" src="img/listaDeDesejos.png" title="Adicionar à Lista de Desejos"/></a>
		</h1>
		<img src="img/produto<c:out value="${idProduto}"/>.png" alt="imagem do produto <c:out value="${idProduto}"/>" class="imagem_produto" />
		<h2>Resumo</h2>
		<p>
			Lorem ipsum dolor sit amet, consectetur adipiscing elit.
		</p>

		<h2>Detalhes</h2>
		<p>Mauris vitae neque elementum dolor commodo malesuada non id arcu. 
		Proin commodo porta justo, nec ornare ligula lobortis quis. Nulla 
		rutrum elit quam, sit amet tristique est blandit in. Nullam sed sapien 
		et elit ultricies tincidunt. Quisque lacinia eleifend dui ut interdum. 
		Nullam eleifend faucibus nulla eu tristique. Praesent quis velit sapien. 
		Nulla facilisi. Proin non massa ut tortor lobortis varius at in dolor.
		</p>

		<h2>Itens relacionados</h2>		
		<div id="conteudo">
			<div id="escolherProdutos">
				<div id="miniaturasBox">
					<c:forEach var="item" items="${itensRelacionados}" >
						<div class="miniatura">
							<a href="detalhesDeProduto?idProduto=<c:out value="${item}"/>">
								<img class="produto" src="img/bandaid.jpg">
							</a>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		
		<%@ include file="/WEB-INF/jsp/footer.jsp" %>
	</body>
</html>