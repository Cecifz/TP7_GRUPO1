<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entidad.TipoSeguro" %>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agregar Seguro</title>
</head>
<body>
<!-- 
ACA HAY QUE HACER UNA REQUEST Buscando el proximo ID

-->
<% 
	ArrayList<TipoSeguro> listaSeguros= null;
	if(request.getAttribute("TipoSeguros")!=null)
	{
		listaSeguros = (ArrayList<TipoSeguro>) request.getAttribute("TipoSeguros");
	}
 %>


<a href="Inicio.jsp"> Inicio </a>
<a href="/TP7_GRUPO1/ServletAgregarSeguro?getID"> Agregar seguro </a>
<a href="ListarSeguros.jsp"> Listar Seguros </a>
<h1>Agregar Seguros</h1>


 <form method="get" action="ServletAgregarSeguro">
 <input type="hidden" name="txtIdSeguro" value= ${id}>
 <label for="labelIdSeguro">Id Seguro: ${id}</label><br><br>
 <label for="txtDescripcion">Descrición:</label><br>
 <input type="text" name="txtDescripcion"><br><br>
Tipo de seguros:<br>
<select name="TipoSeguro">
   <!--  <option value="tech">Technology</option>--> 
   
  <%
 	if(listaSeguros!=null)
		for(TipoSeguro ts:listaSeguros)
		{
	%>
	<option value="<%=ts.getIdTipo()%>" > <%=ts.getDescripcion()%></option>
	<%	}%>
  
</select><br><br>
 <label for="txtCostoContratacion">Costo de Contratación:</label><br>
 <input type="text" name="txtCostoContratacion"><br>
 <label for="txtCostoAsegurado">Costo máximo asegurado: </label><br>
 <input type="text" name="txtCostoAsegurado"><br><br>
 <input type="submit" value="Agregar" name="btnAgregar">
</form>

</body>
</html>