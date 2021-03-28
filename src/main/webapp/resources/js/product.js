$(() => {
  let product = {
    productName: 'LOGO OVER COTTON & WOOL KNIT SWEATER',
    id: 1,
    category: 'CLOTHING/KNITWEAR',
    details: [
      'Embroidered front logo',
      'Model is wearing a size M',
      'Model height: 1.88m',
      'Cut for an oversize fit',
      'Buy your usual size',
      'Composition: 71% Cotton, 12% Wool, 17% Polyamide',
    ],
    price: 200,
    styleName: 'NAVY',
    relatedStyles: [
      { id: 2, styleName: 'BLACK' },
      { id: 3, styleName: 'GREEN' },
    ],
    images: [
      'https://case-study.s3.us-east-2.amazonaws.com/images/1/1.jpeg',
      'https://case-study.s3.us-east-2.amazonaws.com/images/1/2.jpeg',
      'https://case-study.s3.us-east-2.amazonaws.com/images/1/3.jpeg',
      'https://case-study.s3.us-east-2.amazonaws.com/images/1/4.webp',
      'https://case-study.s3.us-east-2.amazonaws.com/images/1/5.jpeg',
      'https://case-study.s3.us-east-2.amazonaws.com/images/1/6.jpeg',
    ],
    sizes: [
      { size: 'S', quantity: 3 },
      { size: 'M', quantity: 1 },
      { size: 'L', quantity: 2 },
    ],
  };

  let selectedSize;

  $('#styleSelection').text(product.styleName);

  $('.accordion-body').append('<ul id="details">');
  product.details.forEach((detail) => {
    $(`<li>${detail}</li>`).appendTo($('#details'));
  });

  product.images.forEach((image) => {
    $('<img>').attr('src', image).appendTo($('#carousel'));
  });

  if (product.relatedStyles.length) {
    let styleOptions = $('<div class="style-options options"></div>').appendTo(
      '#style'
    );
    product.relatedStyles.forEach((style) => {
      $(
        `<a href="../html/product.html?productId=${style.id}"><div class="style-option">${style.styleName}</div></a>`
      ).appendTo(styleOptions);
    });
    $('#styleSelection').click(() => {
      if (!$('.style-options').is(':visible')) $('.style-options').show();
      else $('.style-options').hide();
    });
  }

  if (product.sizes.length) {
    let sizeOptions = $('<div class="size-options options"></div>').appendTo(
      '#size'
    );
    product.sizes.forEach((size) => {
      $(`<div class="size-option" data-value="${size.size}">${size.size}</div>`)
        .click(() => {
          console.log(size);
          $('#sizeSelection').text(size.size);
          selectedSize = size.size;
          $('.size-options').hide();
        })
        .appendTo(sizeOptions);
    });
    $('#sizeSelection').click(() => {
      if (!$('.size-options').is(':visible')) $('.size-options').show();
      else $('.size-options').hide();
    });
  }

  $('#mainImg').attr('src', product.images[0]);

  $('html').click((e) => {
    // console.log('visible:', $('.style-options').is(':visible'));
    if (
      !$(e.target).closest('#styleSelection').length &&
      $('.style-options').is(':visible')
    ) {
      $('.style-options').hide();
    }
    if (
      !$(e.target).closest('#sizeSelection').length &&
      !$(e.target).closest('.size-option').length &&
      $('.size-options').is(':visible')
    ) {
      $('.size-options').hide();
    }
  });

  $('#carousel img').click(function () {
    $('#mainImg').attr('src', $(this).attr('src'));
  });

  $('#addBtn').click(() => {
    if (product.sizes.length > 1 && !selectedSize) {
      console.log('selectedSize', selectedSize);
      alert('MUST SELECT A SIZE');
    } else {
      console.log('selectedSize', selectedSize);
      $('.modal-title').text(product.productName);
      $('#modalStyleId').text(product.id);
      $('#modalPrice').text(product.price);
      $('#modalStyle').text(product.styleName);
      $('#modalSize').text(selectedSize);
      $('#bagModal').modal('show');
    }
  });

  $('#checkoutBtn').click(() => {
    location.href = '../html/checkout.html';
  });
});
