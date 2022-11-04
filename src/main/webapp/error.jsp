<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
<link rel="stylesheet" href="css/errorpage.css">
</head>
<body>
<div class="cont_principal">
<div class="cont_error">
  
<h1>Oops</h1>  
  <p>The Page you're looking for isn't here.</p>
  <a href="index.jsp">Click to go back to the home page.</a>
  </div>
<div class="cont_aura_1"></div>
<div class="cont_aura_2"></div>
</div>
<script>
window.onload = function(){
	document.querySelector('.cont_principal').className= "cont_principal cont_error_active";  
	  
	}
</script>
</body>
</html>