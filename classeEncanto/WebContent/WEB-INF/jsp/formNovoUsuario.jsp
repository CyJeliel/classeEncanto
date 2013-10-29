<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<link type="text/css" rel="stylesheet" href="css/geral.css"/>
		<link type="text/css" rel="stylesheet" href="css/cadastroDeProdutos.css"/>		
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Classe e Encanto</title>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jQuery/jquery-1.10.2.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/novoUsuario.js"></script>
	</head>
	<body>
		<%@ include file="/WEB-INF/jsp/header.jsp" %>
		<%@ include file="/WEB-INF/jsp/menuLateral.jsp" %>
		<div>
			<h1>Novo Usuário</h1>
			<form action="novoUsuario" method="post">
				<div class="ladoEsquerdo">
					<div class="itemLadoEsquerdo">* Login:</div>
					<div class="itemLadoEsquerdo">* Senha:</div>
					<div class="itemLadoEsquerdo">* Confirmação:</div>
					<div class="itemLadoEsquerdo">* Email:</div>
				</div>
				<div class="ladoDireito">
					<div class="itemLadoDireito">
						<input type="text" name="login"/>
					</div>
					<div class="itemLadoDireito">
						<input type="text" name="senha"/>
					</div>
					<div class="itemLadoDireito">
						<input type="text" name="confirmacaoSenha"/>
					</div>
					<div class="itemLadoDireito">
						<input type="text" name="email"/>
					</div>
					<div class="itemLadoDireito">
						<input type="button" onclick="check(this.form)" value="Criar"/>
						<input type="reset" value="Cancelar">
					</div>
				</div>
			</form>
		</div>
		<%@ include file="/WEB-INF/jsp/footer.jsp" %>
	</body>
</html>


