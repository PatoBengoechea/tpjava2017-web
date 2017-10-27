<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form class="form-signin" name="signin" action="realizaAltaTipo" method="post">
	<div>
	<p>ID:</p><input type="text" name="idtxt">
	</div>
	<div>
	<p>Descripcion:</p><input type="text" name="desctxt">
	</div>
	<div>
	<p>Cantidad Dias Max</p><input type="text" name="canttxt">
	</div>
	<div>
	<button class="btn btn-lg btn-primary btn-block" type="submit">CONFIRMAR</button> 
	</div>
  </form>
</body>
</html>