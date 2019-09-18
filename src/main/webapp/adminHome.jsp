<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="asserts/css/bootstrap.min.css">
    <title>Document</title>
    <script>
  		/* Redirect page if user didn't login */
		var data = localStorage.getItem('Logged_In_Admin');
	 	var donorData = JSON.parse(data);
		if(!donorData)
		{
			window.location.replace('adminLogin.jsp');
		}
  	</script>
</head>
<body>
 <jsp:include page="adminHeader.jsp"></jsp:include>
        <div class="row justify-content-center">
            <div class="col-md-6">
				<div class="alert alert-success alert-dismissible fade show" id="loginStatus" style="display:none;" role="alert">
			  		Login success!
					  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
					    <span aria-hidden="true">&times;</span>
					  </button>
				</div>
            </div>
        </div>
    <script src="asserts/js/jquery-3.4.1.min.js"></script>
  	<script src="asserts/js/bootstrap.min.js"></script>
    <script>
    $(function(){
    	$('#loginStatus').css({"display":"block"});
        });
		function logout()
	  	{
	  	  	console.log('logout success!');
	  	  	localStorage.clear();
	  	  	window.location.replace('adminLogin.jsp');
	  	}
	  	$(function(){
	  		var data = localStorage.getItem('Logged_In_Admin');
			var adminData = JSON.parse(data);
			var id = JSON.stringify(adminData.id);
			$('#dropdownId').html(adminData.name);
			console.log(adminData);
		  	});

    </script>
</body>
</html>