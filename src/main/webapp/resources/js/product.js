$(() => {
  
let styleId = window.location.href.split("/");
styleId = styleId[styleId.length - 1];
  let selectedSize;
  
  $('#styleSelection').click(() => {
      if (!$('.style-options').is(':visible')) $('.style-options').show();
      else $('.style-options').hide();
    });

    $('#sizeSelection').click(() => {
      if (!$('.size-options').is(':visible')) $('.size-options').show();
      else $('.size-options').hide();
    });
  
	$(".size-option").click(function() {
		selectedSize = $(this).data('value');
		console.log('selectedSize:', selectedSize);
		$("#sizeSelection").text(selectedSize);
		$(".size-options").hide();
	})

	$('html').click((e) => {
    // console.log('visible:', $('.style-options').is(':visible'));
    if (
    	!$(e.target).closest('#styleSelection').length && 
      !$(e.target).closest('.style-options').length &&
      $('.style-options').is(':visible')
    ) {
      $('.style-options').hide();
    }
    if (
    !$(e.target).closest('#sizeSelection').length && 
      !$(e.target).closest('.size-options').length &&
      $('.size-options').is(':visible')
    ) {
      $('.size-options').hide();
    }
  });
	
  
  $('#carousel img').click(function () {
    $('#mainImg').attr('src', $(this).attr('src'));
  });

  $('#addBtn').click(() => {
    if (!selectedSize) {
      console.log('selectedSize', selectedSize);
      alert('MUST SELECT A SIZE');
    } else {
      console.log('selectedSize', selectedSize);
      $('.modal-title').text($("#productName").text());
      $('#modalStyleId').text(styleId);
      $('#modalPrice').text($("#price").text());
      $('#modalStyle').text($("#styleSelection").text());
      $('#modalSize').text(selectedSize);
      $('#bagModal').modal('show');
    }
  });

 
});
