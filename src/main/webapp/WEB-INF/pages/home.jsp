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

</body>
<script type="text/javascript">
	$("#btnGetLink").click(function(){
		  var link = $("#link").val();
		  $.ajax({url: "/fshare/getlinkvip?linkFshare=" + link, success: function(result){
			  	var result = JSON.parse(result);
		    	if(result.statusCode == 1) {
		    		$("#linkVip").attr("href", result.linkVip);
		    		$("#linkVip").text(result.linkVip);
		    	} else {
		    		alert("Xin hãy kiểm tra lại usernam và password")
		    	}
		  }});
	});
</script>
</html>
