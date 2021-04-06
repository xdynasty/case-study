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
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/button.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/navbar.css" />" rel="stylesheet">
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
    <div class="row"><div class="col" style="text-align: center">${message}</div></div>
      <div class="row">
        <div class="col-md-2"></div>
        <div class="col">
          <h2 class="text-center">SIGN IN</h2>
          <form method="POST" action="signin">
            <div class="row">
              <div class="col">
                <input type="email" class="form-control" placeholder="Email" name="username"/>
              </div>
            </div>
            <div class="row">
              <div class="col">
                <input
                  type="password"
                  class="form-control"
                  placeholder="Password"
                  name="password"
                />
              </div>
            </div>
            <div class="row">
              <div class="col">
                <button type="submit" id="signInBtn" class="btn btn-primary" name="signIn">
                  SIGN IN
                </button>
              </div>
            </div>
          </form>
        </div>
        <div class="col-md-2"></div>
      </div>
      <div class="row">
        <div class="col-md-2"></div>
        <div class="col">
          <h2 class="text-center">NEW TO XYZ?</h2>
          <form method="POST" action="register">
            <div class="row">
              <div class="col">
                <input type="email" class="form-control" placeholder="Email" name="username"/>
              </div>
            </div>
            
            <div class="row">
              <div class="col">
                <input
                  type="password"
                  class="form-control"
                  placeholder="Password"
                  id="passwordInput"
                  name="password"
                />
              </div>
              <div class="col">
                <input
                  type="password"
                  class="form-control"
                  placeholder="Confirm Password"
                  id="confirmPasswordInput"
                />
              </div>
            </div>
            <div class="row">
              <div class="col">
                <button type="submit" id="registerBtn" class="btn btn-primary">
                  Register
                </button>
              </div>
            </div>
          </form>
        </div>
        <div class="col-md-2"></div>
      </div>
    </div>

    <jsp:include page="./footer.jsp"/>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
