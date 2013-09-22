<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<link type="text/css" rel="stylesheet" href="css/geral.css"/>
		<link type="text/css" rel="stylesheet" href="css/cadastroProdutosEmDestaque.css"/>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Classe e Encanto</title>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jQuery/jquery-1.10.2.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/cadastroProdutosEmDestaque.js"></script>
	</head>
	<body>
		<%@ include file="/WEB-INF/jsp/header.jsp" %>
		<%@ include file="/WEB-INF/jsp/menuLateral.jsp" %>

		<div id="conteudo">
			<div id="produtosEscolhidos" >
				<div class="produtoDestaque" id="destaqueEsquerda">
					<span class="linkAdicionar" onclick="escolheProduto();">Adicionar</span>
				</div>
				<div class="produtoDestaque" id="destaqueDireita">
					<span class="linkAdicionar" onclick="escolheProduto();">Adicionar</span>
				</div>
				<div class="produtoDestaque" id="destaqueEsquerda">
					<span class="linkAdicionar" onclick="escolheProduto();">Adicionar</span>
				</div>
				<div class="produtoDestaque" id="destaqueDireita">
					<span class="linkAdicionar" onclick="escolheProduto();">Adicionar</span>
				</div>
			</div>
			<div id="escolherProdutos" style="display: none;">
				<div id="miniaturasBox">
					<div class="miniatura">
						<img onclick="selecionaProduto();" class="produto" src="img/bandaid.jpg">
					</div>
					<div class="miniatura">
						<img onclick="selecionaProduto();" class="produto" src="img/bandaid.jpg">
					</div>
					<div class="miniatura">
						<img onclick="selecionaProduto();" class="produto" src="img/bandaid.jpg">
					</div>
					<div class="miniatura">
						<img onclick="selecionaProduto();" class="produto" src="img/bandaid.jpg">
					</div>
					<div class="miniatura">
						<img onclick="selecionaProduto();" class="produto" src="img/bandaid.jpg">
					</div>
					<div class="miniatura">
						<img onclick="selecionaProduto();" class="produto" src="img/bandaid.jpg">
					</div>
					<div class="miniatura">
						<img onclick="selecionaProduto();" class="produto" src="img/bandaid.jpg">
					</div>
					<div class="miniatura">
						<img onclick="selecionaProduto();" class="produto" src="img/bandaid.jpg">
					</div>
					<div class="miniatura">
						<img onclick="selecionaProduto();" class="produto" src="img/bandaid.jpg">
					</div>
					<div class="miniatura">
						<img onclick="selecionaProduto();" class="produto" src="img/bandaid.jpg">
					</div>
					<div class="miniatura">
						<img onclick="selecionaProduto();" class="produto" src="img/bandaid.jpg">
					</div>
					<div class="miniatura">
						<img onclick="selecionaProduto();" class="produto" src="img/bandaid.jpg">
					</div>
					<div class="miniatura">
						<img onclick="selecionaProduto();" class="produto" src="img/bandaid.jpg">
					</div>
					<div class="miniatura">
						<img onclick="selecionaProduto();" class="produto" src="img/bandaid.jpg">
					</div>
					<div class="miniatura">
						<img onclick="selecionaProduto();" class="produto" src="img/bandaid.jpg">
					</div>
				</div>
			</div>
		</div>

		<%@ include file="/WEB-INF/jsp/footer.jsp" %>
	</body>
</html>