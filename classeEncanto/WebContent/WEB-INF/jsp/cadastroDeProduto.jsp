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
		<%@ include file="/WEB-INF/jsp/menuLateral.jsp" %>
		<div>
			<h3>Dados do Produto</h3>
			<form>
				<table id="tabelaDeProdutos">
					<tr>
						<td>
							Nome:
						</td>
						<td>
							<input type="text" name="nomeDoProduto">
						</td>
					</tr>
					<tr>
						<td>
							<label for="imagemDoProduto">
								Imagem:
							</label>
						</td>
						<td>
							<input type="file" name="imagemDoProduto" id="imagemDoProduto">
						</td>
					</tr>
					<tr>
						<td>
							Resumo:
						</td>
						<td>
							<input type="text" name="resumoDoProduto">
						</td>
					</tr>
					<tr>
						<td>
							Detalhes:
						</td>
						<td>
							<input type="text" name="detalhesDoProduto">
						</td>
					</tr>
					<tr>
						<td>
							Grupo:
						</td>
						<td>
							<select multiple name="grupoDoProduto">
								<option value="01">Grupo 01</option>
								<option value="02">Grupo 02</option>
								<option value="03">Grupo 03</option>
								<option value="04">Grupo 04</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							Tema:
						</td>
						<td>
							<select multiple name="temaDoProduto" />
								<option value="01">Tema 01</option>
								<option value="02">Tema 02</option>
								<option value="03">Tema 03</option>
								<option value="04">Tema 04</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							<input type="submit" value="Criar">  
						</td>
						<td>
							<input type="reset" value="Cancelar" >
						</td>
					</tr>
				</table>
			</form>
		</div>
		<%@ include file="/WEB-INF/jsp/footer.jsp" %>
	</body>
</html>


