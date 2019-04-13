<!DOCTYPE html>
<html lang="en">
<head>
  <title>Get link fshare</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<style>
	h1, .form-group {
		TEXT-ALIGN: CENTER;
	}
	.btn {
		TEXT-ALIGN: CENTER;
		width: 150px;
		height: 50px
	}
	.loader {
	  display: none;
	  border: 16px solid #f3f3f3;
	  border-radius: 50%;
	  border-top: 16px solid #3498db;
	  width: 120px;
	  height: 120px;
	  -webkit-animation: spin 2s linear infinite; /* Safari */
	  animation: spin 2s linear infinite;
	  margin: auto;
	}
	
	/* Safari */
	@-webkit-keyframes spin {
	  0% { -webkit-transform: rotate(0deg); }
	  100% { -webkit-transform: rotate(360deg); }
	}
	
	@keyframes spin {
	  0% { transform: rotate(0deg); }
	  100% { transform: rotate(360deg); }
	}
	
	.activedLoader {
		
	}
</style>
<div class="container">
  <h1>GET LINK VIP FSHARE</h1>
  <form>
    <div class="form-group">
      <input type="text" class="form-control" id="link" placeholder="Nhập link">
    </div>
    <div class="form-group">
      <input id="btnGetLink" class="btn btn-primary" type="button" value="GET LINK">
    </div>
    <div class="form-group">
      <a id="linkVip" target="_blank"></a>
    </div>
    
    
  </form>
</div>
<div class="form-group">
      <div class="loader"></div>
</div>

</body>
<script type="text/javascript">
	$("#btnGetLink").click(function(){
		$(".loader").css("display", "block");
		$(".container").css("opacity", "0.5");
		  var link = $("#link").val();
		  $.ajax({url: "/fshare/getlinkvip?linkFshare=" + link, success: function(result){
			  	var result = JSON.parse(result);
		    	if(result.statusCode == 1) {
		    		$("#linkVip").attr("href", result.linkVip);
		    		$("#linkVip").text(result.linkVip);
		    	} else {
		    		alert("Xin hãy kiểm tra lại usernam và password")
		    	}
		    	$(".loader").css("display", "none");
		    	$(".container").css("opacity", "1");
		  }});
	});
</script>
</html>
