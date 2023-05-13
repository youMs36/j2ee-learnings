<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign up</title>
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col m6 offset-m3">
				<div class="card">
					<div class="card content">
						<h3>Register Now</h3>
						<h5 id="message" class="center-align"></h5>
						<div class="form center-align" style="margin: 10px">
							<form id="registrationForm" action="registrationServlet" method="post">
								<div class="row">
									<div class="input-field col s6">
										<input name="firstName" id="first_name" type="text" class="validate"> <label
											for="first_name">First Name</label>
									</div>
								</div>
								<div class="row">
									<div class="input-field col s12">
										<input name="password" id="password" type="password" class="validate">
										<label for="password">Password</label>
									</div>
								</div>
								<div class="row">
									<div class="input-field col s12">
										<input name="email_id" id="email" type="email" class="validate"> <label
											for="email">Email</label>
									</div>
								</div>
								<button class="btn waves-effect waves-light" type="submit"
									name="action">
									Submit
									<!-- <i class="material-icons right">send</i> -->
								</button>
							</form>
						</div>
						<div class="loader center-align"
							style="margin-top: 10px; display: none;">
							<div class="preloader-wrapper active">
								<div class="spinner-layer spinner-red-only">
									<div class="circle-clipper left">
										<div class="circle"></div>
									</div>
									<div class="gap-patch">
										<div class="circle"></div>
									</div>
									<div class="circle-clipper right">
										<div class="circle"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.3.min.js"
		integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
		crossorigin="anonymous"></script>
	<script>
		$(document).ready(function() {
			console.log("Umesh is here!!!;")
			$('#registrationForm').on('submit', function(event) {
				event.preventDefault();
				var f = $(this).serialize();
				console.log(f);
				$(".loader").show();
				$(".form").hide();
				$.ajax({
					url:"registrationServlet",
					data: f,
					type: 'POST',
					success:function(data,textStatus, jqXHR){
						console.log(data);
						console.log("success..");
						$(".loader").hide();
						$(".form").show();
						if(data.trim() === 'done'){
							$("#message").html("Successfully Registerd....");
							$("#message").addClass("green-text");
						}
						else{
							$("#message").html("Something went wrong.");
							$("#message").addClass("red-text");
						}
						
					},
					error:function(jqXHR, textStatus, errorThrown){
						console.log(data);
						console.log("error..");
						$(".loader").hide();
						$(".form").show();
						$("#message").addClass("red-text");
					}
				
				})
				
			}
					
			)
		}) 
	</script>
</body>
</html>