$(() => {
  $('#img1').on('mouseenter', () => {
    console.log('hover');
    $('#img1').attr(
      'src',
      'https://img.thrfun.com/img/083/608/panting_dog_x1.jpg'
    );
  });
});
