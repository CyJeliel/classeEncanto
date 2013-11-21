<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<link type="text/css" rel="stylesheet" href="css/geral.css"/>
		<link type="text/css" rel="stylesheet" href="css/cadastroDeProdutos.css"/>		
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Classe e Encanto</title>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jQuery/jquery-1.10.2.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/cadastroDeProduto.js"></script>
	</head>
	<body>
		<%@ include file="/WEB-INF/jsp/header.jsp" %>
		<%@ include file="/WEB-INF/jsp/menuAdministracao.jsp" %>
		<div id="conteudo">
			<a href="logoutAdmin" class="logout">Logout</a>
			
			<c:if test="${feedbacks != null}">
				<c:forEach var="feedback" items="${feedbacks}">
					<div class="feedback"><c:out value="${feedback}"></c:out></div>
				</c:forEach>
			</c:if>
			<h1>Novo Produto</h1>
			<form method="post" action="salvarProduto" enctype="multipart/form-data">
				<div class="ladoEsquerdo">
					<div class="itemLadoEsquerdo">Nome:</div>
					<div class="itemImagem">
						<label for="imagemDoProduto">Imagem:</label>
					</div>
					<div class="itemLadoEsquerdo">Resumo:</div>
					<div class="itemLadoEsquerdo">Detalhes:</div>
					<div class="itemMaior">Eventos:</div>
					<div class="itemMaior">Decorações:</div>
					<div class="itemBotao">
					</div>
				</div>
				<div class="ladoDireito">
					<input name="id" type="hidden" value="${produto != null? produto.id: 0}"/>
				
					<div class="itemLadoDireito">
						<input type="text" name="nome" value="${produto != null? produto.nome: ''}">
					</div>
					<div class="itemLadoDireito">
						<c:if test="${produto != null}">
							<img id="imagem" alt="" src="<%=request.getContextPath()%>/getImagemProduto?idProduto=${produto.id}">
							<br />
						</c:if>
						<input type="file" name="arquivo" id="imagemDoProduto" value="${produto != null? produto.imagem: ''}" onchange="alterarVisibilidadeDaImagem(this)">
					</div>
					<div class="itemLadoDireito">
						<input type="text" name="resumo" value="${produto != null? produto.resumo: ''}">
					</div>
					<div class="itemLadoDireito">
						<textarea name="descricao" cols="50"  value="${produto != null? produto.descricao: ''}"></textarea>
					</div>
					<div class="itemLadoDireito">
						<select multiple name="grupoDoProduto">
							<option value="01">Aniversário</option>
							<option value="02">Batizado</option>
							<option value="03">Casamento</option>
							<option value="04">Chá de Bebê</option>
							<option value="05">Debutante</option>
							<option value="06">Nascimento</option>
						</select>
					</div>
					<div class="itemLadoDireito">
						<select multiple name="temaDoProduto">
							<option value="01">Convites</option>
							<option value="02">Lembrancinhas</option>
							<option value="03">Kit Higiene</option>
							<option value="04">Kit Ressaca</option>
							<option value="05">Mesa do Bolo</option>
							<option value="06">Mesa dos Convidados</option>
						</select>
					</div>
					<br/>
					<div class="itemLadoDireito">
						<input type="submit" value="${produto != null? 'Alterar': 'Criar'}">
						<input type="reset" value="Cancelar">
					</div>
				</div>
			</form>
		</div>
		<%@ include file="/WEB-INF/jsp/footer.jsp" %>
	</body>
</html>


