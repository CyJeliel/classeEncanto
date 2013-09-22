<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<link type="text/css" rel="stylesheet" href="css/geral.css"/>
		<link type="text/css" rel="stylesheet" href="css/listaDeProdutos.css"/>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Classe e Encanto</title>
		<script src="js/listagemDeProdutos.js"></script>
	</head>
	<body>
		<%@ include file="/WEB-INF/jsp/header.jsp" %>
		<%@ include file="/WEB-INF/jsp/menuLateral.jsp" %>
		<h1>Lista de produtos</h1>
		
		<div id="conteudo">
			<div id="escolherProdutos">
				<div id="miniaturasBox">
					<div class="miniatura">
						<a href="detalhesDeProduto">
							<img onclick="selecionaProduto();" class="produto" src="img/bandaid.jpg">
						</a>
					</div>
					<div class="miniatura">
						<a href="detalhesDeProduto">
							<img onclick="selecionaProduto();" class="produto" src="img/bandaid.jpg">
						</a>
					</div>
					<div class="miniatura">
						<a href="detalhesDeProduto">
							<img onclick="selecionaProduto();" class="produto" src="img/bandaid.jpg">
						</a>
					</div>
					<div class="miniatura">
						<a href="detalhesDeProduto">
							<img onclick="selecionaProduto();" class="produto" src="img/bandaid.jpg">
						</a>
					</div>
					<div class="miniatura">
						<a href="detalhesDeProduto">
							<img onclick="selecionaProduto();" class="produto" src="img/bandaid.jpg">
						</a>
					</div>
					<div class="miniatura">
						<a href="detalhesDeProduto">
							<img onclick="selecionaProduto();" class="produto" src="img/bandaid.jpg">
						</a>
					</div>
					<div class="miniatura">
						<a href="detalhesDeProduto">
							<img onclick="selecionaProduto();" class="produto" src="img/bandaid.jpg">
						</a>
					</div>
					<div class="miniatura">
						<a href="detalhesDeProduto">
							<img onclick="selecionaProduto();" class="produto" src="img/bandaid.jpg">
						</a>
					</div>
					<div class="miniatura">
						<a href="detalhesDeProduto">
							<img onclick="selecionaProduto();" class="produto" src="img/bandaid.jpg">
						</a>
					</div>
					<div class="miniatura">
						<a href="detalhesDeProduto">
							<img onclick="selecionaProduto();" class="produto" src="img/bandaid.jpg">
						</a>
					</div>
					<div class="miniatura">
						<a href="detalhesDeProduto">
							<img onclick="selecionaProduto();" class="produto" src="img/bandaid.jpg">
						</a>
					</div>
					<div class="miniatura">
						<a href="detalhesDeProduto">
							<img onclick="selecionaProduto();" class="produto" src="img/bandaid.jpg">
						</a>
					</div>
					<div class="miniatura">
						<a href="detalhesDeProduto">
							<img onclick="selecionaProduto();" class="produto" src="img/bandaid.jpg">
						</a>
					</div>
					<div class="miniatura">
						<a href="detalhesDeProduto">
							<img onclick="selecionaProduto();" class="produto" src="img/bandaid.jpg">
						</a>
					</div>
					<div class="miniatura">
						<a href="detalhesDeProduto">
							<img onclick="selecionaProduto();" class="produto" src="img/bandaid.jpg">
						</a>
					</div>
				</div>
			</div>
		</div>
			
			
			
			<!-- <div class="block">
				<ul>
					<li><a href="detalhesDeProduto?idProduto=01">Produto 01</a><!-- TODO Adicionar imagem e dados do produto. -- ></li>
					<li><a href="detalhesDeProduto?idProduto=02">Produto 02</a><!-- TODO Adicionar imagem e dados do produto. -- ></li>
					<li><a href="detalhesDeProduto?idProduto=03">Produto 03</a><!-- TODO Adicionar imagem e dados do produto. - -></li>
					<li><a href="detalhesDeProduto?idProduto=04">Produto 04</a><!-- TODO Adicionar imagem e dados do produto. -- ></li>
					<li><a href="detalhesDeProduto?idProduto=05">Produto 05</a><!-- TODO Adicionar imagem e dados do produto. - -></li>
					<li><a href="detalhesDeProduto?idProduto=06">Produto 06</a><!-- TODO Adicionar imagem e dados do produto. -- ></li>
					<li><a href="detalhesDeProduto?idProduto=07">Produto 07</a><!-- TODO Adicionar imagem e dados do produto. - -></li>
					<li><a href="detalhesDeProduto?idProduto=08">Produto 08</a><!-- TODO Adicionar imagem e dados do produto. -- ></li>
				</ul>
			</div> -->
		<%@ include file="/WEB-INF/jsp/footer.jsp" %>
	</body>
</html>