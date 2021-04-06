$(() => {
  $(".quantity-select").on("change", function() {
  	console.log($(this).find(':selected').val());
  	console.log($(this).data("style-id"));
  	axios.post("http://localhost:8080/case-study/update_quantity", null, {
      	params: {
      	newQuantity: $(this).find(':selected').val(),
      	styleId: $(this).data("style-id")	
      	}
      }).then(() => {
      console.log("sent post");
      }).catch(err => console.log);
  });
});
