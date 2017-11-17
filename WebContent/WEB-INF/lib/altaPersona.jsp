<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form class="form-signin" name="signin" action="realizaAltaPersona" method="post">
	<p>Nombre<input type="text" name="nombretxt"></p>
	<p>Apellido<input type="text" name="apellidotxt"></p>
	<p>DNI<input type="text" name="dnitxt"></p>
	<p>Habilitado <input type="checkbox" name="habchecbox"></p>
	Tipo Usuario: <select name="tipouser" >
	<option  value="1" >User</option>
	<option  value="2" >Admin</option>
	<option  value="3" >Encargado</option>
	</select>
	<p>Usuario<input type="text" name="usuariotxt"></p>
	<p>Password<input type="text" name="passwordtxt"></p>
	<div>
	<button class="btn btn-lg btn-primary btn-block" type="submit">CONFIRMAR</button> 
	</div>
  </form>
</body>
</html>