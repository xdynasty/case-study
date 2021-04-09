<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/button.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/order.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/navbar.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/footer.css" />" rel="stylesheet">

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
   <jsp:include page="./navbar.jsp"/>

    <div class="container-fluid" id="main">
      <div class="row">
        <div class="col"><h2 class="text-center">CHECKOUT</h2></div>
      </div>
      <div class="row">
        <div class="col">
        <form>
        
          <div class="row">
            <div class="col">
              <div class="row">
                <div class="col"><h3>ADDRESSES</h3></div>
              </div>
              <div class="row">
                <div class="col">
                  <label for="shippingAddrnput" class="form-label"
                    >SHIPPING ADDRESS</label
                  ><input
                    type="text"
                    id="shippingAddrInput"
                    class="form-control"
                    name="shippingAddress"
                  />
                </div>
              </div>
              <div class="row">
                <div class="col">
                  <label for="billingAddrInput" class="form-label"
                    >BILLING ADDRESS</label
                  ><input
                    type="text"
                    id="billingAddrInput"
                    class="form-control"
                    name="billingAddress"
                  />
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col">
              <div class="row">
                <div class="col"><h3>PAYMENT</h3></div>
              </div>
              <div class="row">
                <div class="col"><label for="creditCardInput" class="form-label">CREDIT CARD NO.</label><input  id="creditCardInput" class="form-control" name="creditCardNum"/></div>
              </div>
            </div>
          </div>
         	</form>
        </div>
        <div class="col-md-1 order">
          <div class="row">
            <div class="col"><h3>ORDER</h3></div>
          </div>
          <div class="row">
            <div class="col">SUBTOTAL</div>
            <div class="col order-value">
				<c:set var="subtotal" value="${0}"/>
				<c:forEach items="${cartItems}" var="cartItem">
				<c:set var="subtotal" value="${subtotal + (cartItem.style.price * cartItem.cartQuantity)}"/>
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
                <button type="submit" class="btn btn-primary">PURCHASE</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <jsp:include page="./footer.jsp"/>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
      crossorigin="anonymous"
    ></script>
    <script src="<c:url value="/resources/js/checkout.js" />"></script>
  </body>
</html>
