<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<link type="text/css" rel="stylesheet" href="css/geral.css"/>
		<link type="text/css" rel="stylesheet" href="css/cadastroDeProdutos.css"/>		
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Classe e Encanto</title>
	</head>
	<body>
		<%@ include file="/WEB-INF/jsp/header.jsp" %>
		<%@ include file="/WEB-INF/jsp/menuAdministracao.jsp" %>
		<div>
			<h1>Novo Produto</h1>
			<form action="novoProduto">
				<div class="ladoEsquerdo">
					<div class="itemLadoEsquerdo">Nome:</div>
					<div class="itemLadoEsquerdo">
						<label for="imagemDoProduto">Imagem:</label>
					</div>
					<div class="itemLadoEsquerdo">Resumo:</div>
					<div class="itemLadoEsquerdo">Detalhes:</div>
					<div class="itemMaior">Eventos:</div>
					<div class="itemMaior">Decora��es:</div>
					<div class="itemBotao">
					</div>
				</div>
				<div class="ladoDireito">
					<div class="itemLadoDireito">
						<input type="text" name="nomeDoProduto">
					</div>
					<div class="itemLadoDireito">
						<input type="file" name="imagemDoProduto" id="imagemDoProduto">
					</div>
					<div class="itemLadoDireito">
						<input type="text" name="resumoDoProduto">
					</div>
					<div class="itemLadoDireito">
						<textarea name="detalhesDoProduto" cols="50"></textarea>
					</div>
					<div class="itemLadoDireito">
						<select multiple name="grupoDoProduto">
							<option value="01">Anivers�rio</option>
							<option value="02">Batizado</option>
							<option value="03">Casamento</option>
							<option value="04">Ch� de Beb�</option>
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
						<input type="submit" value="Criar">
						<input type="reset" value="Cancelar">
					</div>
				</div>
			</form>
		</div>
		<%@ include file="/WEB-INF/jsp/footer.jsp" %>
	</body>
</html>


