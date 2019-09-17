<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="asserts/css/bootstrap.min.css">
    <title>Document</title>
</head>
<body>
 <jsp:include page="header.jsp"></jsp:include>
        <div class="row justify-content-center">
            <div class="col-md-6">
                <h5>Fund request</h5>
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <div class="input-group-text">
                                Request Type
                            </div>
                        </div>
                        <select id="requestType" class="form-control">
                            <option>--Request type--</option>
                            <option value="EDUCATION">Education</option>
                            <option value="FOOD">Food</option>
                            <option value="MEDICAL">Medical</option>
                            <option value="AGRICULTURE">Agriculture</option>
                            <option value="OTHERS">Others</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <div class="input-group-text">
                                Description
                            </div>
                        </div>
                        <input type="text" name="description" id="description" class="form-control" placeholder="Description" required>
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <div class="input-group-text">
                                Amount
                            </div>
                        </div>
                        <input type="number" name="amount" id="amount" class="form-control" placeholder="Amount" required>
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <div class="input-group-text">
                                Expire date
                            </div>
                        </div>
                        <input type="date" name="expireDate" id="expireDate" class="form-control" required>
                    </div>
                </div>
                <button onclick="fundRequest()" class="btn btn-outline-secondary">Send</button>
            </div>
        </div>
    <script src="asserts/js/jquery-3.4.1.min.js"></script>
  	<script src="asserts/js/bootstrap.min.js"></script>
    <script>
        function fundRequest()
        {

        	var data = localStorage.getItem('Donor_Data');
			var adminData = JSON.parse(data);
			var id = JSON.stringify(adminData.id);
            
        	var donorId = id;
            var requestType = $('#requestType').val(); 
            var description = $('#description').val();
            var amount = $('#amount').val();
            var date = $('#expireDate').val();
            console.log("ID=>"+donorId);
            console.log("requestType=>"+requestType);
            console.log("description=>"+description);
            console.log("amount=>"+amount);
            console.log("date=>"+date);
            var formData = "id="+donorId+"&requestType="+requestType+"&description="+description+"&amount="+amount+"&date="+date;
            var url = "http://localhost:8080/CharityApplication/FundRequestServlet?"+formData;
            $.get(url,function(data){
                console.log(data)
                console.log('fund request success!');
            });
        }
    </script>
</body>
</html>