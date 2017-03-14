<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<spring:url value="/resources/css/hello-world-spring.css" var="helloCss" />
<spring:url value="/resources/css/font-awesome.css" var="fontAwesome" />
<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCSS" />

<link href="${helloCss}" rel="stylesheet" />
<link href="${fontAwesome}" rel="stylesheet" />
<link href="${bootstrapCSS}" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cart contents</title>
</head>
<body>
	<div class="container-fluid">
		<div class="page-header">
			<h1>Contenido del carrito</h1>
		</div>
		<div class="row">
			<div class="col-md-9">
				<table class="table table-striped table-hover table-bordered">
					<tr>
						<th>id</th>
						<th>name</th>
						<th>brand</th>
						<th>price</th>
						<th>addToCart</th>
						<th>delete</th>
					</tr>
					<c:forEach items="${cart}" var="product">
						<spring:url value="/products/${product.id}" var="productURL" />
						<tr class="clickable-row" data-href="${productURL}">
							<td class="vert-align"><c:out value="${product.id}" /></td>
							<td class="vert-align"><c:out value="${product.name}" /></td>
							<td class="vert-align"><c:out value="${product.brand}" /></td>
							<td class="vert-align"><c:out value="${product.price}" /></td>
							<spring:url value="/addToCart/${product.id}" var="addToCartURL" />
							<td class="vert-align"><a href="${addToCartURL}"><i
									class="fa fa-cart-arrow-down" aria-hidden="true"></i>Buy!</a></td>
							<spring:url value="/products/${product.id}/delete" var="deleteURL" />
							<td class="vert-align"><a href="${deleteURL}"><i
									class="fa fa-cart-arrow-down" aria-hidden="true"></i>X</a></td>
						</tr>
					</c:forEach>
				</table>

			</div>
		</div>
	</div>

</body>
<spring:url value="/resources/js/hello-world-spring.js" var="helloJS" />
<spring:url value="/resources/js/jquery.min.js" var="helloJQuery" />
<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJS" />
<script src="${helloJQuery}"></script>
<script src="${bootstrapJS}"></script>
<script src="${helloJS}"></script>
</html>