	<a href="" class="menuSubtituloLink">Eventos</a>
	<div class="itensMenu">
		<c:forEach var="categoria" items="${categoriasEventos}" >
			<a href="listaDeProdutos?idCategoria=${categoria.id}" class="menuLink">${categoria.descricao}</a>
		</c:forEach>
	</div>
	<a href="" class="menuSubtituloLink">Decora��es</a>
	<div class="itensMenu">
		<c:forEach var="categoria" items="${categoriasDecoracoes}" >
			<a href="listaDeProdutos?idCategoria=${categoria.id}" class="menuLink">${categoria.descricao}</a>
		</c:forEach>
	</div>