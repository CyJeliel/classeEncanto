	<a href="" class="menuSubtituloLink">Eventos</a>
	<div class="itensMenu">
		<c:forEach var="categoria" items="${categoriasEventos}" >
			<a href="listaDeProdutos?idCategoria=${categoria.id}" class="menuLink">${categoria.descricao}</a>
		</c:forEach>
	</div>
	<a href="" class="menuSubtituloLink">Decorações</a>
	<div class="itensMenu">
		<a href="listaDeProdutos?idCategoria=07" class="menuLink">Convites</a>
		<a href="listaDeProdutos?idCategoria=08" class="menuLink">Lembrancinhas</a>
		<a href="listaDeProdutos?idCategoria=09" class="menuLink">Kit higiene</a>
		<a href="listaDeProdutos?idCategoria=10" class="menuLink">Kit ressaca</a>
		<a href="listaDeProdutos?idCategoria=11" class="menuLink">Mesa do Bolo</a>
		<a href="listaDeProdutos?idCategoria=12" class="menuLink">Mesa dos convidados</a>
	</div>