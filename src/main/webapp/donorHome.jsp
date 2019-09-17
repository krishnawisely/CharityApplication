<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="asserts/css/bootstrap.min.css">
    <title>Donor Home</title>
  
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
    <div class="row justify-content-center">
        <div class="col-md-8">
            <select id="requestType" class="form-control" onchange="listRequest()">
                <option>--SELECT--</option>
                <option value="EDUCATION">Education</option>
                <option value="FOOD">Food</option>
                <option value="MEDICAL">Medical</option>
                <option value="AGRICULTURE">Agriculture</option>
                <option value="OTHERS">Others</option>
            </select>
            <!--  <div class="row" id="transaction" style="display:none;">
            	<div class="col">
            		
            		<button onclick=""></button>
            	</div>
            </div>-->
            <table class="table">
                <thead>
                    <tr>
                        <th>Request Type</th>
                        <th>Description</th>
                        <th>Amount</th>
                        <th>Expire Date</th>
                        <th>PayAmount</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody id="requestTable">
                   
                </tbody>
            </table>
        </div>
    </div>
    
    <script src="asserts/js/jquery-3.4.1.min.js"></script>
  	<script src="asserts/js/bootstrap.min.js"></script>
  	<script>
  	function donate(fundRequestId){
  		/* Get donor details */
		var data = localStorage.getItem('Logged_In_Donor');
  		 var donorData = JSON.parse(data);
  		 var donorId = donorData.id;
		/* Get amount */
  		var amount = $("#amount").val();
  		 
  	  	console.log("fund_req_id=>"+fundRequestId);
  	  	console.log("donor_id=>"+donorId);
  		console.log("amount=>"+amount);

  		var formData = "id="+donorId+"&fundRequestId="+fundRequestId+"&amount="+amount;
  		var url = "http://localhost:8080/CharityApplication/TransactionServlet?"+formData;

  		$.get(url,function(data){
			console.log('transaction success!');
			console.log(data);
  		});
  		
  	}
  	
  	function listRequest()
    {

		
    	   
        var requestType = $('#requestType').val();
        var formData = "requestType="+requestType;
        var url = "http://localhost:8080/CharityApplication/ListFundRequestServlet?"+formData;
        $.get(url,function(datas){

        	
        
            var requestData = JSON.parse(datas);
            var tbody = $('#requestTable');
            var content = "";
            for(data of requestData)
            {
            	content += '<tr><td>';
                content += data.requestType;
                content += '</td><td>';
                content += data.description;
                content += '</td><td>';
                content += data.amount
                content += '</td><td>';
                content += data.expireDate.day+"-"+ data.expireDate.month+"-"+data.expireDate.year;
                content += '</td><td>';
                content += '<input type="number" id="amount" placeholder="PayAmount"/>';
                content += '</td><td>';
                var click = "donate('"+ data.id + "')";
                content += '<button class="btn btn-outline-success" onclick=' + click + '>Donate</button>';
                content += '</td></tr>';
            }
            console.log("content=>"+content);
            tbody.html(content);
        });
    }
  	</script>
</body>
</html>