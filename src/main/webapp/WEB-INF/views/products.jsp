<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ page import="java.util.List" %><%@ page import="com.junjiexu.xyz.entities.Product" %>
<!DOCTYPE html>
<html>
	<head>
		<title>XYZ</title>
		<meta charset="UTF-8" />
		<meta name="description" content="XYZ" />
		<meta name="keywords" content="clothing, apparel, luxury" />
		<meta name="author" content="Junjie Xu" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
      crossorigin="anonymous"
    />
		<link href="
			<c:url value="/resources/css/styles.css" />" rel="stylesheet">
			<link href="
				<c:url value="/resources/css/display.css" />" rel="stylesheet">
				<link href="
					<c:url value="/resources/css/main.css" />" rel="stylesheet">
					<script
      src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
      integrity="sha256-4+XzXVhsDmqanXGHaHvgh1gMQKX40OUvDEBTu8JcmNs="
      crossorigin="anonymous"
    ></script>
					<script
      src="https://kit.fontawesome.com/b15d1bc6ae.js"
      crossorigin="anonymous"
    ></script>
				</head>
				<body>
					<jsp:include page="./header.jsp"/>
					<div class="container-fluid" id="main">
						<div class="row">
							<div class="col-md-12 col-sm-12 tile-container">
								<c:forEach items="${styles}" var="style">
									<div class="tile">
										<a href="${pageContext.request.contextPath}/product/${style.id}">
											<div class="inner">
												<img class="tile-img" src="${style.previewImages[0]}"/>
													<p class="product-name">
														<c:out value="${style.product.name}"/>
													</p>
													<p class="price]">$${style.price}</p>
												</div>
											</a>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
						<jsp:include page="./footer.jsp"/>
						<script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
      crossorigin="anonymous"
    ></script><%-- 
						<script src="
							<c:url value="/resources/js/products.js" />">
						</script> --%>
					</body>
				</html>
