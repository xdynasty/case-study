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
    <link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/flash.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/product.css" />" rel="stylesheet">
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
   <jsp:include page="./header.jsp"/>
    <div class="container-fluid" id="main">
      <div class="row">
        <div class="col-md-2 col-sm-12">
          <div id="carousel"></div>
        </div>
        <div class="col-md col-sm-12 d-flex justify-content-center">
          <img id="mainImg" />
        </div>
        <div class="col-md col-sm-12">
          <div class="row">
            <div class="col"><p id="productName"></p></div>
          </div>
          <div class="row">
            <div class="col"><p id="price"></p></div>
          </div>

          <div class="row">
            <div class="col">
              <label for="style">STYLE</label>
              <div id="style">
                <div id="styleSelection"></div>
              </div>
            </div>
            <div class="col">
              <label for="size">SIZE</label>
              <div id="size">
                <div id="sizeSelection"></div>
                <div class="size-options options">
                  <div class="size-option" data-value="OPTION 1">OPTION 1</div>
                  <div class="size-option" data-value="OPTION 2">OPTION 2</div>
                  <div class="size-option" data-value="OPTION 3">OPTION 3</div>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col">
              <p>IN STOCK</p>
              <div class="d-grid">
                <button type="submit" id="addBtn" class="button btn-dark">
                  ADD TO SHOPPING BAG
                </button>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col">
              <div class="accordion accordion-flush" id="accordion">
                <div class="accordion-item">
                  <h2 class="accordion-header">
                    <button
                      class="accordion-button collapsed"
                      type="button"
                      data-bs-toggle="collapse"
                      data-bs-target="#flush-collapseOne"
                      aria-expanded="false"
                      aria-controls="flush-collapseOne"
                    >
                      DETAILS
                    </button>
                  </h2>
                  <div
                    id="flush-collapseOne"
                    class="accordion-collapse collapse"
                    aria-labelledby="flush-headingOne"
                    data-bs-parent="#accordion"
                  >
                    <div class="accordion-body"></div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <footer class="container-fluid">
      <div class="row"><div class="col"></div></div>
      <div class="row">
        <div class="col text-center">
          <small>Copyright © 2021 Junjie Xu. All Rights Reserved</small>
        </div>
      </div>
    </footer>

    <div class="modal" id="bagModal">
      <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
          <div class="modal-header">
            <h3 class="modal-title"></h3>
            <button
              type="button"
              class="btn-close"
              data-bs-toggle="modal"
              data-bs-target="#bagModal"
              aria-label="Close"
            ></button>
          </div>
          <div class="modal-body">
            <div class="container-fluid">
              <div class="row">
                <div class="col">Product No.</div>
                <div class="col" id="modalStyleId"></div>
              </div>
              <div class="row">
                <div class="col">PRICE</div>
                <div class="col" id="modalPrice"></div>
              </div>
              <div class="row">
                <div class="col">STYLE</div>
                <div class="col" id="modalStyle"></div>
              </div>
              <div class="row">
                <div class="col">SIZE</div>
                <div class="col" id="modalSize"></div>
              </div>
              <div class="row">
                <div class="col">
                  <div class="d-grid">
                    <button
                      type="button"
                      data-bs-toggle="modal"
                      data-bs-target="#bagModal"
                      class="btn btn-dark"
                    >
                      CONTINUE SHOPPING
                    </button>
                  </div>
                </div>
                <div class="col">
                  <div class="d-grid">
                    <button type="button" class="btn btn-dark" id="checkoutBtn">
                      CHECKOUT
                    </button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
      crossorigin="anonymous"
    ></script>
    <script src="<c:url value="/resources/js/product.js" />"></script>
  </body>
</html>