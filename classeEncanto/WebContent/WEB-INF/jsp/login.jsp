<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/geral.css">
		<meta charset="UTF-8">
		<title>
			Login
		</title>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jQuery/jquery-1.10.2.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/login.js"></script>
		
		<style>
.error {
	color: #ff0000;
}
 
.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
		
	</head>
	<body>
		<%@ include file="/WEB-INF/jsp/header.jsp" %>
		<%@ include file="/WEB-INF/jsp/menuLateral.jsp" %>
		
		<h1>Acesso à administração</h1>
		
		<form id="form" action="admin" method="post">
				Login
				<br/>
				<input type="text" name="login"/>
				<br/>
				Senha
				<br/>
				<input type="password" name="senha"/>
				<br/>
				<input type="button" onclick="check(this.form)" value="Login"/>
		</form>
		<%@ include file="/WEB-INF/jsp/footer.jsp" %>
	</body>
</html>