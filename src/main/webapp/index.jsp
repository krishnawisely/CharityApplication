<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="asserts/css/bootstrap.min.css" />
    <style>
    	.img{
	background-image: url("asserts/pics/donate.jpg");
	width: 100%;
	height: 80vh;
	transform: skewY(-0.1deg);
	background-repeat: no-repeat;
	background-size: cover;
	}
    </style>
    <title>CharityApp</title>
</head>
<body class="bg-light">
<jsp:include page="header.jsp"></jsp:include>
    <div class="row justify-content-center align-items-center img" style="height: 80vh;margin:0;">
        <div class="col-md-8 text-center text-light">
            <h3 class="b">Welcome to charity application</h3>
            <a href="donorRegister.jsp" class="btn btn-outline-light">Register Here</a>
        </div>
    </div>
	<script src="asserts/js/jquery-3.4.1.min.js"></script>
  	<script src="asserts/js/bootstrap.min.js"></script>
</body>
</html>