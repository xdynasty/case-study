$(() => {
  let products = [
    {
      productName: 'LOGO OVER COTTON & WOOL KNIT SWEATER',
      id: 3,
      price: 300,
      image: 'https://case-study.s3.us-east-2.amazonaws.com/images/1/1.jpeg',
      size: 3,
      style: 'BLUE',
      quantity: 1,
      availableQuantities: 4,
    },
    {
      productName: 'P2',
      id: 4,
      price: 400,
      image: 'https://case-study.s3.us-east-2.amazonaws.com/images/1/6.jpeg',
      size: 'OS',
      style: 'BLUE',
      quantity: 2,
      availableQuantities: 10,
    },
  ];

  products.forEach((product) => {
    let productTile = $('<div class="row product-tile">').appendTo(
      '.product-tiles-container'
    );
    $(
      `<div class="col-md-4"><img src="${product.image}" class="product-img"/></div>`
    ).appendTo(productTile);
    let rightCol = $('<div class="col-md-8">').appendTo(productTile);
    $(`<div class="row">
    <div class="col"><h3>${product.productName}</h3></div>
  </div>
  <div class="row">
    <div class="col">SIZE</div>
    <div class="col">${product.size}</div>
  </div>
  <div class="row">
    <div class="col">STYLE</div>
    <div class="col">${product.style}</div>
  </div>
  <div class="row">
    <div class="col">PRICE</div>
    <div class="col">${product.price}</div>
  </div>`).appendTo(rightCol);
    let quantityRow = $(`<div class="row"></div>`).appendTo(rightCol);
    let quantityLabelCol = $('<div class="col">Quantity</div>').appendTo(
      quantityRow
    );
    let quantityCol = $(`<div class="col"></div>`).appendTo(quantityRow);
    let quantitySelect = $('<select>').appendTo(quantityCol);
    $(`<option>REMOVE</option>`).appendTo(quantitySelect);
    [...new Array(product.availableQuantities)].forEach((quantity, index) => {
      let option;
      if (index + 1 === product.quantity) {
        option = $(`<option selected>${index + 1}</option>`).appendTo(
          quantitySelect
        );
      } else
        option = $(`<option>${index + 1}</option>`).appendTo(quantitySelect);
    });
  });
});
