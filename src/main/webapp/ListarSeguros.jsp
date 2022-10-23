<%@page import="java.util.ArrayList"%>
<%@page import="entidad.Seguro" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Seguros</title>
</head>
<body>
<a href="Inicio.jsp"> Inicio </a>
<a href="/TP7_GRUPO1/ServletAgregarSeguro?getID"> Agregar seguro </a>
<a href="ListarSeguros.jsp"> Listar Seguros </a>

<% 
	ArrayList<Seguro> listaSeguros= null;
	if(request.getAttribute("lista")!=null)
	{
		listaSeguros = (ArrayList<Seguro>) request.getAttribute("lista");
	}
 %>

"Tipos de seguros de la base de datos"
<br>
<br>
Busqueda por tipo de Seguros: 
<form >
	<select>
		<option> Seguro de casas </option>
		<option> Seguro de vida </option>
		<option> Seguro de motos </option>
	</select>
</form>
<br>
<form  method="get" action="servletSeguro" name="listar">
	<table border=1>
	<tr>
		<th>Id<br>Seguro</th>
		<th>Descripción de seguro </th>
		<th>Descripción tipo seguro </th>
		<th>Costo contratación </th>
		<th>Costo máximo asegurado </th>
	</tr>
	<%	if(listaSeguros!=null)
		for(Seguro user:listaSeguros)
		{
	%>
	<tr>
		<th><%=user.getIdSeguro() %></th>
		<th><%=user.getDescripcion() %></th>
		<th><%=user.getIdTipo()%></th>
		<th><%=user.getCostoContratacion()%></th>
		<th><%=user.getCostoAsegurado() %></th>
	</tr>
	
	<%	}%>
	</table>
</form>

</body>
</html>