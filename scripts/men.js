$(() => {
  let products = [
    {
      id: 1,
      productId: 1,
      productName: 'LOGO OVER COTTON & WOOL KNIT SWEATER',
      category: 'CLOTHING/KNITWEAR',
      styleName: 'NAVY',
      previewImages: [
        'https://case-study.s3.us-east-2.amazonaws.com/images/1/t1.jpeg',
        'https://case-study.s3.us-east-2.amazonaws.com/images/1/t2.jpeg',
      ],
      price: 240,
      sizes: ['S', 'M', 'L'],
    },
    {
      id: 2,
      productId: 2,
      productName: 'LOGO PATCH COTTON JERSEY SWEATPANTS',
      category: 'CLOTHING/PANTS',
      styleName: 'BLACK',
      previewImages: [
        'https://case-study.s3.us-east-2.amazonaws.com/images/2/t1.webp',
        'https://case-study.s3.us-east-2.amazonaws.com/images/2/t2.webp',
      ],
      price: 200,
      sizes: ['M', 'L'],
    },
    {
      id: 3,
      productId: 3,
      productName: '991 SNEAKERS',
      category: 'SHOES/SNEAKERS',
      styleName: 'NAVY',
      previewImages: [
        'https://case-study.s3.us-east-2.amazonaws.com/images/3/t1.webp',
        'https://case-study.s3.us-east-2.amazonaws.com/images/3/t2.webp',
      ],
      price: 190,
      sizes: [6.5, 8, 9],
    },
  ];

  products.forEach((product, index) => {
    let tile = $('<div class="tile">');
    let link = $(
      `<a href=./product.html?productId=${product.id}></a>`
    ).appendTo(tile);
    let inner = $('<div class="inner">').appendTo(link);
    let img = $('<img class="tile-img">')
      .attr('src', product.previewImages[0])
      .appendTo(inner);
    img.on('mouseenter', () => {
      console.log('hover');
      img.attr('src', product.previewImages[1]);
    });
    img.on('mouseleave', () => {
      console.log('hover');
      img.attr('src', product.previewImages[0]);
    });
    $(
      `<p class="product-name">${product.productName}</p><p class="price">${
        product.price
      }</p><p class="sizes">${product.sizes.join(' | ')}</p>`
    ).appendTo(inner);
    tile.appendTo($('.tile-container'));
  });
  $('#img1').on('mouseenter', () => {
    console.log('hover');
    $('#img1').attr(
      'src',
      'https://img.thrfun.com/img/083/608/panting_dog_x1.jpg'
    );
  });
});
