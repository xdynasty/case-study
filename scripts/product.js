$(() => {
  let images = [
    'https://th.bing.com/th/id/OIP.Jf0NnGpH2AhNM3BtwZufwwHaJ4?w=117&h=180&c=7&o=5&dpr=2&pid=1.7',
    'https://th.bing.com/th/id/OIP.YVhCc6EJPGY-rieLuOXmegHaLG?pid=ImgDet&rs=1',
    'https://i.pinimg.com/originals/50/b8/4c/50b84c2c87f6bc767bd0fdac2e8fda26.png',
    'https://th.bing.com/th/id/OIP.jolYGxsmIwxGCtwX24-fYwHaE7',
  ];

  $('html').click((e) => {
    // console.log('visible:', $('.color-options').is(':visible'));
    if (
      !$(e.target).closest('.color-options').length &&
      !$(e.target).closest('#colorSelection').length &&
      $('.color-options').is(':visible')
    ) {
      $('.color-options').hide();
    }
    if (
      !$(e.target).closest('.size-options').length &&
      !$(e.target).closest('#sizeSelection').length &&
      $('.size-options').is(':visible')
    ) {
      $('.size-options').hide();
    }
  });

  $('#carousel img').click(function () {
    console.log('clicked');
    console.log($(this).attr('src'));
    $('#mainImg').attr('src', $(this).attr('src'));
  });

  $('#colorSelection').click(() => {
    if (!$('.color-options').is(':visible')) $('.color-options').show();
    else $('.color-options').hide();
  });
  $('#sizeSelection').click(() => {
    if (!$('.size-options').is(':visible')) $('.size-options').show();
    else $('.size-options').hide();
  });

  $('.color-option').click(function () {
    $('.color-options').hide();
    $('#colorSelection').text($(this).data('value'));
  });

  $('.size-option').click(function () {
    $('.size-options').hide();
    $('#sizeSelection').text($(this).data('value'));
  });
});
