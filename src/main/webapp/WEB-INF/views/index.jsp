<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  	<link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/flash.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/footer.css" />" rel="stylesheet">
    <script
      src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
      integrity="sha256-4+XzXVhsDmqanXGHaHvgh1gMQKX40OUvDEBTu8JcmNs="
      crossorigin="anonymous"
    ></script>
  </head>
  <body>
    <header class="container-fluid" id="header">
      <div class="row">
        <div class="col"><div id="flash"></div></div>
      </div>
      <div class="row">
        <div class="col">
          <h1 style="color: white">
            <a href="./">XYZ</a>
          </h1>
        </div>
      </div>
    </header>
    <div class="container-fluid">
      <div class="row">
        <div class="col-md-6 col-sm-12 panel" id="men">
          <a href="${pageContext.request.contextPath}/men" class="panel-link"
            ><div
              class="panel-menu d-flex align-items-center justify-content-center"
            >
              MEN
            </div></a
          >
        </div>
        <div class="col-md-6 col-sm-12 panel" id="women">
          <a href="${pageContext.request.contextPath}/women" class="panel-link"
            ><div
              class="panel-menu d-flex align-items-center justify-content-center"
            >
              WOMEN
            </div></a
          >
        </div>
        <div class="col-md-6 col-sm-12 panel" id="kids">
          <a href="${pageContext.request.contextPath}/kids" class="panel-link"
            ><div
              class="panel-menu d-flex align-items-center justify-content-center"
            >
              KIDS
            </div></a
          >
        </div>
        <div class="col-md-6 col-sm-12 panel" id="home">
          <a href="${pageContext.request.contextPath}/home" class="panel-link"
            ><div
              class="panel-menu d-flex align-items-center justify-content-center"
            >
              HOME
            </div></a
          >
        </div>
      </div>
    </div>
    <jsp:include page="./footer.jsp"/>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
      crossorigin="anonymous"
    ></script>
   <script src="<c:url value="/resources/js/flash.js" />"></script>
  </body>
</html>
