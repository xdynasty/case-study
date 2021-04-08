$(() => {
	$("#registerForm").submit(function(e) {
		let passwordInput = $("#passwordInput").val();
		let confirmPasswordInput = $("#confirmPasswordInput").val();
		if (passwordInput !== confirmPasswordInput) {
			e.preventDefault();
			alert("PLEASE CONFIRM YOUR PASSWORD");
		}
	})
})