$(() => {
  let images = [
    'https://th.bing.com/th/id/OIP.Jf0NnGpH2AhNM3BtwZufwwHaJ4?w=117&h=180&c=7&o=5&dpr=2&pid=1.7',
    'https://th.bing.com/th/id/OIP.YVhCc6EJPGY-rieLuOXmegHaLG?pid=ImgDet&rs=1',
    'https://i.pinimg.com/originals/50/b8/4c/50b84c2c87f6bc767bd0fdac2e8fda26.png',
    'https://th.bing.com/th/id/OIP.jolYGxsmIwxGCtwX24-fYwHaE7',
  ];

  $('#color').click(() => {
    $('.options').toggleClass('show');
  });

  $('.option').click(function () {
    console.log($(this).data('value'));
    $('#color').text($(this).data('value'));
  });
});
