<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="xyz.junjie.xu.entities.CartItem" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		<link href="<c:url value="/resources/css/navbar.css" />" rel="stylesheet">
			<link href="
				<c:url value="/resources/css/main.css" />" rel="stylesheet">
				<link href="
					<c:url value="/resources/css/button.css" />" rel="stylesheet">
					<link href="
						<c:url value="/resources/css/order.css" />" rel="stylesheet">
						<link href="
							<c:url value="/resources/css/bag.css" />" rel="stylesheet">
							<link href="<c:url value="/resources/css/flash.css" />" rel="stylesheet">
							<script
      src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
      integrity="sha256-4+XzXVhsDmqanXGHaHvgh1gMQKX40OUvDEBTu8JcmNs="
      crossorigin="anonymous"
    ></script>
							<script
      src="https://kit.fontawesome.com/b15d1bc6ae.js"
      crossorigin="anonymous"
    ></script>
    
 <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
 
						</head>
						<body>
							<jsp:include page="./navbar.jsp"/>
							<div class="container-fluid" id="main">
								<div class="row">
									<div class="col">
										<h2 class="text-center">SHOPPING BAG</h2>
									</div>
								</div>
								<section>
									<div class="container product-tiles-container">
										<c:forEach items="${cartItems}" var="cartItem">
											<div class="row product-tile">
												<div class="col-md-4">
													<img src="${cartItem.style.previewImages[0]}" class="product-img"/>
												</div>
												<div class="col-md-8">
													<div class="row">
														<div class="col">
															<h3><a href="${pageContext.request.contextPath}/product/${cartItem.style.id}" style="color: black">${cartItem.style.product.name}</a></h3>
														</div>
													</div>
													<div class="row">
														<div class="col">SIZE</div>
														<div class="col">${cartItem.size}</div>
													</div>
													<div class="row">
														<div class="col">STYLE</div>
														<div class="col">${cartItem.style.name}</div>
													</div>
													<div class="row">
														<div class="col">PRICE</div>
														<div class="col">$<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${cartItem.style.price}"/></div>
													</div>
													<div class="row">
														<div class="col">QUANTITY</div>
														<div class="col"><select data-style-id="${cartItem.style.id}" class="quantity-select"><option value="0">REMOVE</option>
														<c:forEach items="${cartItem.style.quantities}" var="quantity">
														<c:if test="${quantity.style == cartItem.style && quantity.id.size == cartItem.size}">
															<c:forEach begin="1" end="${quantity.stockQuantity}" varStatus="loop">
															<c:choose>
															<c:when test="${loop.index == cartItem.cartQuantity }"><option selected value="${loop.index}">${loop.index }</option></c:when>
															<c:otherwise><option value="${loop.index}">${loop.index }</option></c:otherwise>
															</c:choose>
															</c:forEach>
														</c:if>
														</c:forEach>
														</select></div>
														
													</div>
												</div>
											</div>
										</c:forEach>
									</div>
									<aside class="container order">
										<div class="row">
											<div>
												<div class="row">
													<div class="col">
														<h3>ORDER</h3>
													</div>
												</div>
												<div class="row">
													<div class="col">SUBTOTAL</div>
													<div class="col order-value">
														<c:set var="subtotal" value="${0}"/>
														<c:forEach items="${cartItems}" var="cartItem">
															<c:set var="subtotal" value="${subtotal + (cartItem.style.price * cartItem.cartQuantity) }"/>
														</c:forEach>
														$<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${subtotal}"/>
													</div>
												</div>
												<div class="row">
													<div class="col">SHIPPING</div>
													<div class="col order-value">$100</div>
												</div>
												<div class="row">
													<div class="col">TOTAL</div>
													<div class="col order-value">$<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${subtotal + 100}"/></div>
												</div>
												<div class="row">
													<div class="col">
														<div class="d-grid">
															<a href="${pageContext.request.contextPath}/checkout" id="purchaseBtn">PURCHASE</a>
														</div>
													</div>
												</div>
											</div>
										</div>
									</aside>
								</section>
							</div>
							<jsp:include page="./footer.jsp"/>
							<script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
      crossorigin="anonymous"
    ></script>
							<script src="
								<c:url value="/resources/js/bag.js" />">
							</script>
						</body>
					</html>
