<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<link type="text/css" rel="stylesheet" href="css/geral.css"/>
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
							<input type="file" name="imagemDoProduto" id="imagemDoProduto" width="30">
						</td>
					</tr>
					<tr>
						<td>
							Resumo:
						</td>
						<td>
							<input type="text" name="resumoDoProduto" width="30">
						</td>
					</tr>
					<tr>
						<td>
							Detalhes:
						</td>
						<td>
							<input type="text" name="detalhesDoProduto" width="30" height="30">
						</td>
					</tr>
					<tr>
						<td>
							Grupo:
						</td>
						<td>
							<input type="text" name="grupoDoProduto" width="30" height="30">
						</td>
					</tr>
					<tr>
						<td>
							Tema:
						</td>
						<td>
							<input type="text"  name="temaDoProduto" width="30" height="30">
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


